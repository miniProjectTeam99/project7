package project7.clonecoding.user.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import project7.clonecoding.comment.entity.Comment;
import project7.clonecoding.user.dto.UserRequestDto;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    //댓글과 연관관계
    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<Comment> comments = new ArrayList<>();

    public Users(UserRequestDto userRequestDto, String password, UserRoleEnum role){
        this.userName = userRequestDto.getUserName();
        this.email = userRequestDto.getEmail();
        this.password = password;
        this.role = UserRoleEnum.USER;
    }

    public void changePassword(String password){

        this.password = password;
    }

}
