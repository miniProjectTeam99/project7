package project7.clonecoding.comment.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import project7.clonecoding.comment.dto.CommentRequestDto;
import project7.clonecoding.game.entity.Game;
import project7.clonecoding.game.entity.StringArrayConverter;
import project7.clonecoding.timestamp.Timestamp;
import project7.clonecoding.user.entity.Users;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Getter
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //댓글내용
    @Column(columnDefinition = "json")
    @Convert(converter = StringArrayConverter.class)
    private List<String> content;

    //유저와 다대일 매핑
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Users user;

    //게임과 다대일 매핑
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "game_id")
    private Game game;

    public Comment (CommentRequestDto commentDto, Users user, Game game) {
        this.content = commentDto.getComment();
        this.user = user;
        this.game = game;
    }

    public void update(CommentRequestDto requestDto){
        this.content = requestDto.getComment();
    }
}
