package project7.clonecoding.comment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project7.clonecoding.comment.entity.Comment;
import project7.clonecoding.game.entity.Game;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByGame(Game game);
}
