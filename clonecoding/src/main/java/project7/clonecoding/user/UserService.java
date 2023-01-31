package project7.clonecoding.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project7.clonecoding.jwt.JwtUtil;
import project7.clonecoding.user.dto.ResponseMsgDto;
import project7.clonecoding.user.dto.UserRequestDto;
import project7.clonecoding.user.entity.Users;
import project7.clonecoding.user.entity.UserRoleEnum;
import project7.clonecoding.user.entity.Users;

import javax.servlet.http.HttpServletResponse;

import static java.util.regex.Pattern.matches;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {
    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;


    public ResponseMsgDto signup(UserRequestDto userRequestDto, HttpServletResponse response) {

        String password = userRequestDto.getPassword();
        String passwordCheck = userRequestDto.getPasswordCheck();

        UserRoleEnum role = UserRoleEnum.USER;

        // 비밀번호 길이 체크 & 비밀번호와 비밀번호 체크 입력값 확인 후 같을 경우 암호화
        if(password.length()<8){
            return new ResponseMsgDto("8글자 이상으로 만들어주세요.", HttpStatus.BAD_REQUEST.value());
        }

        if(!matches(password,passwordCheck)){
            return new ResponseMsgDto("비밀번호가 서로 다릅니다.", HttpStatus.BAD_REQUEST.value());
        }

        String encodingPassword = passwordEncoder.encode(password);


        //아이디&이메일 중복 확인
        Users users = userRepository.findByUserName(userRequestDto.getUserName());
        if (users != null) {
            return new ResponseMsgDto("이미 등록된 아이디입니다.", HttpStatus.BAD_REQUEST.value());
        }

        Users emails = userRepository.findByEmail(userRequestDto.getEmail());
        if (emails != null) {
            return new ResponseMsgDto("이미 등록된 이메일입니다.", HttpStatus.BAD_REQUEST.value());
        }


       //제한 사항
       String nameCheck = userRequestDto.getUserName();
       String nameRegexp = "^[가-힣a-zA-Z0-9._-]{2,20}$";
       if(!nameCheck.matches(nameRegexp)){
           return new ResponseMsgDto("아이디는 2~20자 내외여야합니다.", HttpStatus.BAD_REQUEST.value());
       }

       String emailCheck = userRequestDto.getEmail();
       String emailRegexp = "^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        if(!emailCheck.matches(emailRegexp)){
            return new ResponseMsgDto("이메일 형식으로 등록해주세요.", HttpStatus.BAD_REQUEST.value());
        }


        Users signRequest = new Users(userRequestDto, encodingPassword, role);
        userRepository.save(signRequest);

        response.setHeader("Access-Control-Allow-Origin", "http://localhost:3000");

        return new ResponseMsgDto("회원 가입 성공", HttpStatus.OK.value());
    }

    public ResponseMsgDto login(UserRequestDto userRequestDto, HttpServletResponse response) {
        String password = userRequestDto.getPassword();

        Users users = userRepository.findByEmail(userRequestDto.getEmail());
        if (users == null) {
            return new ResponseMsgDto("등록되지 않은 이메일입니다.",HttpStatus.BAD_REQUEST.value());
        }

        if (!passwordEncoder.matches(password, users.getPassword())) {
            return new ResponseMsgDto("비밀번호가 일치하지 않습니다.", HttpStatus.BAD_REQUEST.value());
        }

        // 토큰
        response.addHeader(JwtUtil.AUTHORIZATION_HEADER,
                jwtUtil.createToken(users.getUserName(), users.getRole()));

        return new ResponseMsgDto("로그인 성공", HttpStatus.OK.value());
    }

    @Transactional
    public Integer changeData(Long id, UserRequestDto userRequestDto,Users users) {

        String password = userRequestDto.getPassword();

        if(password.length()<8)
            return HttpStatus.BAD_REQUEST.value();

        String encodedPassword = passwordEncoder.encode(userRequestDto.getPassword());

        users = userRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );

        users.changePassword(encodedPassword);

        return HttpStatus.OK.value();
    }

    @Transactional
    public Integer deleteUsersData(Long id, UserRequestDto userRequestDto,Users users){
        users = userRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        if(users.getUserName().equals(userRequestDto.getUserName())) {
            userRepository.delete(users);
        }
         return HttpStatus.OK.value();
    }

}
