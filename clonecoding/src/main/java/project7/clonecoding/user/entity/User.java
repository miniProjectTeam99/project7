package project7.clonecoding.user.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String nickname;
    @Column
    private Long kakaoId;
    @Column(nullable = false)
    private String password;
    @Column
    private String imgurl;
    @Column(nullable = false)
    private boolean state = true;

    public User(String username, Long kakaoId, String password, String imgurl) {
        this.username = username;
        this.nickname = username;
        this.kakaoId = kakaoId;
        this.password = password;
        this.imgurl = imgurl;
    }
}
