package project7.clonecoding.user;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import project7.clonecoding.user.dto.LoginRequestDto;
import project7.clonecoding.user.dto.ResponseMsgDto;
import project7.clonecoding.user.dto.SignupRequestDto;

import javax.servlet.http.HttpServletResponse;


@Api(tags = {"Users"})
@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @ApiOperation(value = "회원가입", notes = "회원가입")
    @PostMapping("/user/signup")
    public ResponseMsgDto signup(@RequestBody SignupRequestDto signupRequestDto){
        return userService.signup(signupRequestDto);
    }

    @ApiOperation(value = "로그인", notes = "로그인을 한다")
    @PostMapping("/user/login")
    public ResponseMsgDto login(@RequestBody LoginRequestDto loginRequestDto, HttpServletResponse response){
        return userService.login(loginRequestDto,response);
    }
}
