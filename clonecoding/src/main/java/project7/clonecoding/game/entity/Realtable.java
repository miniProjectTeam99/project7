package project7.clonecoding.game.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Realtable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String thumbnail;

    @Column
    private String value;

    @Column
    private String gameintro;

    @Column
    private String story;

    @Column
    private String users;

    @Column
    private String dates;

    @Column
    private String stars;

    @Column
    private String comment;

    @Column
    private String member;

    @Column
    private String guide;

    @Column
    private String category;

}
