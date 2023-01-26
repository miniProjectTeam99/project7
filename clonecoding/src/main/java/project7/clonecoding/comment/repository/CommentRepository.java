package project7.clonecoding.comment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project7.clonecoding.comment.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
