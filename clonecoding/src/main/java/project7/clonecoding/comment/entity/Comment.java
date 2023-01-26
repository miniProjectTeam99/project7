package project7.clonecoding.comment.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import project7.clonecoding.comment.dto.CommentRequestDto;
import project7.clonecoding.game.entity.Game;
import project7.clonecoding.timestamp.Timestamp;
import project7.clonecoding.user.entity.Users;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class Comment extends Timestamp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //댓글내용
    @Column(nullable = false)
    private String content;

    //별점
    @Column(nullable = false)
    private String star;

    //스포일러 유무
    @Column(nullable = false)
    private boolean isspoil;

    //유저와 다대일 매핑
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Users user;

    //게임과 다대일 매핑
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "game_id")
    private Game game;

    public Comment (CommentRequestDto commentDto) {
        this.content = commentDto.getComment();
        this.star = commentDto.getStar();
        this.isspoil = commentDto.getIsSpoil();
    }

    public void update(CommentRequestDto requestDto){
        content = requestDto.getComment();
    }
}
