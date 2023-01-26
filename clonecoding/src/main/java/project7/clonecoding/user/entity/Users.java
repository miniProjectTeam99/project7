package project7.clonecoding.user.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import project7.clonecoding.user.dto.LoginRequestDto;
import project7.clonecoding.user.dto.SignupRequestDto;

import javax.persistence.*;


@Entity
@Getter
@NoArgsConstructor
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String userName;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private UserRoleEnum role;

    public Users(SignupRequestDto signupRequestDto, UserRoleEnum role){
        this.userName = signupRequestDto.getUserName();
        this.password = signupRequestDto.getPassword();
        this.email = signupRequestDto.getEmail();
        this.role = UserRoleEnum.USER;
    }

    public void login(LoginRequestDto loginRequestDto){
        this.userName = loginRequestDto.getUserName();
        this.password = loginRequestDto.getPassword();
    }

}
