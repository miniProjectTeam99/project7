package project7.clonecoding.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project7.clonecoding.jwt.JwtUtil;
import project7.clonecoding.user.dto.ResponseMsgDto;
import project7.clonecoding.user.dto.UserRequestDto;
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


    public ResponseMsgDto signup(UserRequestDto userRequestDto, HttpServletResponse response) {

        String password = userRequestDto.getPassword();
        String passwordCheck = userRequestDto.getPasswordCheck();

        UserRoleEnum role = UserRoleEnum.USER;

        // 비밀 번호 입력 값 확인 후 같을 경우 암호화
        if(!matches(password,passwordCheck)){
            return new ResponseMsgDto("비밀번호가 서로 다릅니다.", HttpStatus.BAD_REQUEST.value());
        }

        String encodingPassword = passwordEncoder.encode(password);


        Users users = userRepository.findByUserName(userRequestDto.getUserName());
        if (users != null) {
            return new ResponseMsgDto("이미 등록된 아이디입니다.", HttpStatus.BAD_REQUEST.value());
        }

        Users email2 = userRepository.findByEmail(userRequestDto.getEmail());
        if (email2 != null) {
            return new ResponseMsgDto("이미 등록된 이메일입니다.", HttpStatus.BAD_REQUEST.value());
        }


        Users signRequest = new Users(userRequestDto, encodingPassword, role);
        userRepository.save(signRequest);

        response.setHeader("Access-Control-Allow-Origin", "http://localhost:3000");

        return new ResponseMsgDto("회원 가입 성공", HttpStatus.OK.value());
    }

    public ResponseMsgDto login(UserRequestDto userRequestDto, HttpServletResponse response) {
        String password = userRequestDto.getPassword();

        Users users = userRepository.findByUserName(userRequestDto.getUserName());
        if (users == null) {
            return new ResponseMsgDto("등록되지 않은 아이디입니다.", HttpStatus.BAD_REQUEST.value());
        }

        if (!matches(password, users.getPassword())) {
            return new ResponseMsgDto("비밀번호가 일치하지 않습니다.", HttpStatus.BAD_REQUEST.value());
        }

        // 토큰
        response.addHeader(JwtUtil.AUTHORIZATION_HEADER,
                jwtUtil.createToken(users.getUserName(), users.getRole()));

        return new ResponseMsgDto("로그인 성공", HttpStatus.OK.value());
    }

    @Transactional
    public Long changeData(Long id, UserRequestDto userRequestDto) {

        String password = passwordEncoder.encode(userRequestDto.getPassword());

        Users users = userRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );

        users.changePassword(userRequestDto,password);

        return users.getId();
    }

}
