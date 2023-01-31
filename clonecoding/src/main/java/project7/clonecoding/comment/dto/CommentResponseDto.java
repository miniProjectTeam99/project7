package project7.clonecoding.comment.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import project7.clonecoding.comment.entity.Comment;
import project7.clonecoding.game.entity.Game;

import java.util.List;

@Getter
@NoArgsConstructor
public class CommentResponseDto {
    private List<String> comment;

    public CommentResponseDto(Comment comment) {//평점순
        this.comment = comment.getContent();
    }

}
