package project7.clonecoding.user;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import project7.clonecoding.user.dto.ResponseMsgDto;
import project7.clonecoding.user.dto.UserRequestDto;

import javax.servlet.http.HttpServletResponse;


@Api(tags = {"Users"})
@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @ApiOperation(value = "회원가입", notes = "회원가입")
    @PostMapping("/user/signup")
    public ResponseMsgDto signup(@RequestBody UserRequestDto userRequestDto, HttpServletResponse response){
        return userService.signup(userRequestDto, response);
    }

    @ApiOperation(value = "로그인", notes = "로그인을 한다")
    @PostMapping("/user/login")
    public ResponseMsgDto login(@RequestBody UserRequestDto userRequestDto, HttpServletResponse response){
        return userService.login(userRequestDto,response);
    }

    @ApiOperation(value = "유저 비번 변경")
    @PutMapping("/user/{id}")
    public Long changePassword(@PathVariable long id,@RequestBody UserRequestDto userRequestDto){
        return userService.changeData(id, userRequestDto);
    }
}
