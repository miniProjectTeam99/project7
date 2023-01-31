package project7.clonecoding.like;

import lombok.Getter;
import lombok.NoArgsConstructor;
import project7.clonecoding.comment.entity.Comment;
import project7.clonecoding.user.entity.Users;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class CommentLike {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
<<<<<<< HEAD

    @ManyToOne
    @JoinColumn(name = "comment_id")
    private Comment comment;

=======
    @ManyToOne
    @JoinColumn(name = "comment_id")
    private Comment comment;
>>>>>>> a4c3139b7f674a35b5775046c809e1ada92638fd
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;
    public CommentLike(Comment comment, Users user) {
        this.comment = comment;
        this.user = user;
    }
<<<<<<< HEAD
    
=======
>>>>>>> a4c3139b7f674a35b5775046c809e1ada92638fd
}
