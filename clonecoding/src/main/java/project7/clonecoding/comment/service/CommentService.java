package project7.clonecoding.comment.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project7.clonecoding.comment.dto.CommentRequestDto;
import project7.clonecoding.comment.entity.Comment;
import project7.clonecoding.comment.repository.CommentRepository;
import project7.clonecoding.game.dto.ResponseDto;
import project7.clonecoding.game.entity.Game;
import project7.clonecoding.game.repository.GameRepository;
import project7.clonecoding.user.UserRepository;
import project7.clonecoding.user.entity.Users;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final GameRepository gameRepository;

    @Transactional
    public ResponseDto createComments(Long gameId, CommentRequestDto commentRequestDto, Users user) {
        // 사용자 확인하기
        String username = user.getUserName();
        Users userFind = userRepository.findByUserName(username);
//        Game game = gameRepository.findById(gameId);

        if (userFind == null){
            throw new IllegalArgumentException("해당 사용자가 없습니다.");
        }
        //댓글저장
        Comment comment = new Comment(commentRequestDto,user);

        commentRepository.save(comment);

        return new ResponseDto("댓글 작성 완료");
    }

    @Transactional
    public ResponseDto updateComment(Long commentId, CommentRequestDto requestDto, Users user) {
        // 사용자 확인하기
        String username = user.getUserName();

        //DB에서 댓글 찾아오기
        Comment comment = commentRepository.findById(commentId).orElseThrow(
                () -> new IllegalArgumentException("해당 댓글이 존재하지 않습니다.")
        );

        //본인이 쓴 댓글인지 확인
        if (!username.equals(comment.getUser().getUserName())) {
            throw new IllegalArgumentException("본인의 댓글만 수정 가능합니다");
        }
        comment.update(requestDto);

        return new ResponseDto("댓글 수정완료");
    }

    @Transactional
    public ResponseDto deleteComment(Long commentId, CommentRequestDto requestDto, Users user) {
        String username = user.getUserName();

        //DB에서 댓글 찾아오기
        Comment comment = commentRepository.findById(commentId).orElseThrow(
                () -> new IllegalArgumentException("해당 댓글은 없습니다.")
        );

        //본인이 쓴 댓글인지 확인
        if (!username.equals(comment.getUser().getUserName())) {
            throw new IllegalArgumentException("본인의 댓글만 삭제 가능합니다");
        }

        //댓글 삭제
        commentRepository.deleteById(commentId);
        return new ResponseDto("댓글 삭제 성공");
    }
}