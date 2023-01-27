package project7.clonecoding.like;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import project7.clonecoding.comment.service.CommentService;
import project7.clonecoding.security.UserDetailsImpl;
import project7.clonecoding.user.dto.ResponseMsgDto;
import project7.clonecoding.like.CommentLike;

@Controller
@RequiredArgsConstructor
public class CommentLikeController {

    private final CommentLikeService commentLikeService;

    @PostMapping("/commentLike/{id}/{commentId}")
    public ResponseEntity<ResponseMsgDto> commentLike(@PathVariable Long id, @PathVariable Long commentId, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return ResponseEntity.ok().body(commentLikeService.commentLike(id,commentId,userDetails.getUser()));
    }
}
