package project7.clonecoding.user.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import project7.clonecoding.user.dto.UserRequestDto;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Users extends Timestamped{
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

    public Users(UserRequestDto userRequestDto, String password, UserRoleEnum role){
        this.userName = userRequestDto.getUserName();
        this.email = userRequestDto.getEmail();
        this.password = password;
        this.role = UserRoleEnum.USER;
    }

    public void changePassword(UserRequestDto userRequestDto, String password){
        this.userName = userRequestDto.getUserName();
        this.password = password;
    }

}
