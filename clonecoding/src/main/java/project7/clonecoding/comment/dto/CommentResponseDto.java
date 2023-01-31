package project7.clonecoding.comment.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CommentResponseDto {
    private String userName;
    private String comment;
    private Integer star;
    private Boolean isSpoil;
}
