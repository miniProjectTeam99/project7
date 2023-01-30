package project7.clonecoding.like;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import project7.clonecoding.comment.entity.Comment;
import project7.clonecoding.comment.repository.CommentRepository;
import project7.clonecoding.user.dto.ResponseMsgDto;
import project7.clonecoding.user.entity.Users;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class CommentLikeService {

    private final CommentRepository commentRepository;
    private final CommentLikeRepository commentLikeRepository;

    @Transactional
    public ResponseMsgDto commentLike(Long commentId, Users user) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 댓글입니다.")
        );

        if (!commentLikeRepository.existsByCommentIdAndUserId(commentId, user.getId())) {
            commentLikeRepository.saveAndFlush(new CommentLike(comment, user));
            return new ResponseMsgDto("좋아요 완료", HttpStatus.OK.value());

        } else {
            commentLikeRepository.deleteByCommentIdAndUserId(comment.getId(), user.getId());
            return new ResponseMsgDto("좋아요 취소", HttpStatus.OK.value());
        }
    }
}
