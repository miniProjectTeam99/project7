package project7.clonecoding.comment.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import springfox.documentation.spring.web.json.Json;

import java.util.List;

@Getter
@NoArgsConstructor
public class CommentRequestDto {
    private String comment;
    private Integer stars;
    private Boolean isSpoil;
}
