package project7.clonecoding.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import project7.clonecoding.jwt.JwtUtil;
import project7.clonecoding.user.dto.LoginRequestDto;
import project7.clonecoding.user.dto.ResponseMsgDto;
import project7.clonecoding.user.dto.SignupRequestDto;
import project7.clonecoding.user.entity.Users;
import project7.clonecoding.user.entity.UserRoleEnum;

import javax.servlet.http.HttpServletResponse;

import static java.util.regex.Pattern.matches;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    public ResponseMsgDto signup(SignupRequestDto signupRequestDto){

        String password = passwordEncoder.encode(signupRequestDto.getPassword());

        Users users = userRepository.findByUserName(signupRequestDto.getUserName());
        if(users != null){
            return new ResponseMsgDto("이미 등록된 아이디입니다.", HttpStatus.BAD_REQUEST.value());
        }

        Users email = userRepository.findByEmail(signupRequestDto.getEmail());
        if(email != null){
            return new ResponseMsgDto("이미 등록된 이메일입니다.", HttpStatus.BAD_REQUEST.value());
        }

        UserRoleEnum role = UserRoleEnum.USER;

        Users signRequest = new Users(signupRequestDto,role);
        userRepository.save(signRequest);

        return new ResponseMsgDto("회원 가입 성공", HttpStatus.OK.value());
    }

    public ResponseMsgDto login(LoginRequestDto loginRequestDto, HttpServletResponse response){
        String password = loginRequestDto.getPassword();

        Users users = userRepository.findByUserName(loginRequestDto.getUserName());
        if(users == null){
            return new ResponseMsgDto("등록되지 않은 아이디입니다.", HttpStatus.BAD_REQUEST.value());
        }

        if(!matches(password, users.getPassword())){
            return new ResponseMsgDto("비밀번호가 일치하지 않습니다.", HttpStatus.BAD_REQUEST.value());
        }
        response.addHeader(JwtUtil.AUTHORIZATION_HEADER,
                jwtUtil.createToken(users.getUserName(), users.getRole()));
        return new ResponseMsgDto("로그인 성공", HttpStatus.OK.value());
    }

}
