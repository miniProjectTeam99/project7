package project7.clonecoding.comment.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project7.clonecoding.comment.dto.CommentRequestDto;
import project7.clonecoding.comment.dto.CommentResponseDto;
import project7.clonecoding.comment.entity.Comment;
import project7.clonecoding.comment.repository.CommentRepository;
import project7.clonecoding.game.dto.ResponseDto;
import project7.clonecoding.game.entity.Game;
import project7.clonecoding.game.repository.GameRepository;
import project7.clonecoding.user.UserRepository;
import project7.clonecoding.user.entity.Users;

import java.sql.*;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final GameRepository gameRepository;

    @Transactional
    public ResponseDto createComments(Long gameId, CommentRequestDto commentRequestDto, Users user) throws SQLException {
        String url = "jdbc:mysql://database.cp7vsvj41kr8.ap-northeast-2.rds.amazonaws.com:3306/data";
        String userName = "admin";
        String password = "dks153153";
        Connection con = DriverManager.getConnection(url, userName, password);

        // 사용자 확인하기
        String username = user.getUserName();
        Users userFind = userRepository.findByUserName(username);
        Game game = gameRepository.findById(gameId).orElseThrow(
                () -> new IllegalArgumentException("해당 게임이 존재하지 않습니다.")
        );

        if (userFind == null){
            throw new IllegalArgumentException("해당 사용자가 없습니다.");
        }

        PreparedStatement pstmt = con.prepareStatement("SELECT content FROM comment WHERE id = (?)");
        pstmt.setInt(1, gameId.intValue());
        ResultSet rs = pstmt.executeQuery();
        rs.next();

        String comment = commentRequestDto.getComment().toString();
        String s[] = comment.split("[\\[,\\]]");
        String str= "\"dates\":" + "\"" +s[1].strip() + "\"" + "," + "\"user\":" + "\"" + s[2].strip() + "\"" + "," + "\"stars\":" + "\"" + s[3].strip() + "\"" + "," +  "\"comment\":" + "\"" + s[4].strip() + "\"" + "," +  "\"isSpoil\":" + s[5].strip() + "},";
        String strs = "[{" + str + rs.getString(1).substring(1);

        PreparedStatement pstmt1 = con.prepareStatement("UPDATE comment SET content = (?) WHERE id = (?)");
        pstmt1.setString(1, strs);
        pstmt1.setInt(2,gameId.intValue());
        pstmt1.execute();

        return new ResponseDto("댓글 작성 완료");
    }

    @Transactional
    public ResponseDto updateComment(Long commentId, CommentRequestDto requestDto, Users user) {
        // 사용자 확인하기
        Long userId = user.getId();

        //DB에서 댓글 찾아오기
        Comment comment = commentRepository.findById(commentId).orElseThrow(
                () -> new IllegalArgumentException("해당 댓글이 존재하지 않습니다.")
        );
        System.out.println("comment.getUser().getId(): "+comment.getUser());
        System.out.println(("userId: "+userId));
        //본인이 쓴 댓글인지 확인
        if (userId != comment.getUser().getId()) {
            throw new IllegalArgumentException("본인의 댓글만 수정 가능합니다");
        }
        comment.update(requestDto);

        return new ResponseDto("댓글 수정완료");
    }

    @Transactional
    public ResponseDto deleteComment(Long commentId, CommentRequestDto requestDto, Users user) {
        Long userId = user.getId();

        //DB에서 댓글 찾아오기
        Comment comment = commentRepository.findById(commentId).orElseThrow(
                () -> new IllegalArgumentException("해당 댓글은 없습니다.")
        );

        //본인이 쓴 댓글인지 확인
        if (userId != comment.getUser().getId()) {
            throw new IllegalArgumentException("본인의 댓글만 수정 가능합니다");
        }

        //댓글 삭제
        commentRepository.deleteById(commentId);
        return new ResponseDto("댓글 삭제 성공");
    }

    //게임 아이디에 맞는 댓글 전송
    public CommentResponseDto getComment(Long gameId) {

        //DB에서 댓글 찾아오기
        Comment comment = commentRepository.findById(gameId).orElseThrow(
                () -> new IllegalArgumentException("해당 게임의 댓글은 없습니다.")
        );

        return new CommentResponseDto(comment);
    }
}