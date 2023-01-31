package project7.clonecoding.user.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import project7.clonecoding.user.dto.UserRequestDto;

import javax.persistence.*;

@Slf4j
@Entity
@Getter
@Setter
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

    public int getFailCount() {
        return failCount;
    }

    @Column(nullable = false)
    private int failCount=0;
    public Users(UserRequestDto userRequestDto, String password, UserRoleEnum role){
        this.userName = userRequestDto.getUserName();
        this.email = userRequestDto.getEmail();
        this.password = password;
        this.role = UserRoleEnum.USER;
    }
    public void failCount(Users users, int i){
        this.failCount=users.failCount+i;
        iDStop(users.failCount);
    }

    public void changePassword(String password){
        this.password = password;
    }

    public void failClear() {
        this.failCount=0;
    }
    public void iDStop(int i){
        if (failCount>4){
            log.info("횟수: "+i+" 입니다. 아이디를 정지합니다.");}else{
            log.info("횟수: "+ i);
        }
    }
}

