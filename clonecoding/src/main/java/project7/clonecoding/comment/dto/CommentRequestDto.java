package project7.clonecoding.comment.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CommentRequestDto {
    private String comment;
    private String star;
    private Boolean isSpoil;
}
