package project7.clonecoding.comment.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import project7.clonecoding.comment.entity.Comment;
import project7.clonecoding.game.entity.Game;

@Getter
@NoArgsConstructor
public class CommentResponseDto {
    private String comment;

    public CommentResponseDto(Comment comment) {//평점순
        this.comment = comment.getContent();
    }

}
