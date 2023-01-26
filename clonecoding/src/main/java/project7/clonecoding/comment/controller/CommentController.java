package project7.clonecoding.comment.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import project7.clonecoding.comment.dto.CommentRequestDto;
import project7.clonecoding.comment.service.CommentService;
import project7.clonecoding.game.dto.ResponseDto;
import project7.clonecoding.security.UserDetailsImpl;


@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    //댓글 작성
    @PostMapping("/comments")
    public ResponseDto createComments(@RequestBody CommentRequestDto commentRequestDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return commentService.createComments(commentRequestDto, userDetails.getUser());
    }

    //댓글 수정
    @PatchMapping("/comment/{commentId}")
    public ResponseDto updateComment(@PathVariable Long commentId, @RequestBody CommentRequestDto requestDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return commentService.updateComment(commentId, requestDto, userDetails.getUser());
    }

    //댓글 삭제
    @DeleteMapping("/comment/{commentId}")
    public ResponseDto deleteComment(@PathVariable Long commentId, @RequestBody CommentRequestDto requestDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return commentService.deleteComment(commentId, requestDto, userDetails.getUser());
    }

}
