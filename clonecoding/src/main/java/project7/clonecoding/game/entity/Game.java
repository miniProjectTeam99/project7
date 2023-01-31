package project7.clonecoding.game.entity;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.TypeDef;

import project7.clonecoding.comment.entity.Comment;
import project7.clonecoding.timestamp.Timestamp;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@NoArgsConstructor
@Getter
@Entity
@TypeDef(name = "json", typeClass = JsonBinaryType.class)
public class Game extends Timestamp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column//게임 이름
    private String gameTitle;

    @Column//게임 이미지(리스트)
    private String titleImg;

    @Column//모바일 or not
    private Boolean playType;

    @Column//게임 가격(예시: 4,000원)
    private int gamePrice;

    @Column//게임 점수(후시 4.9점)
    private String star;

    @Column//게임 난이도
    private String difficulty;

    @Column//kit유무
    private Boolean kit;

    @Column//게임 시간
    private String playTime;

    @Convert(converter = StringArrayConverter.class) // List<String> 때 사용
    @Column(columnDefinition = "json")
    private List<String> gameImg;

    @Column//게임 스토리
    private String story;

    @Column//게임 인원
    private String people;

    @Column//게임 상세
    private String gameDesc;

    @Column//게임 핵심 설명
    private String gameDescShort;

    @Column//게임 카테고리
    private String category;

    @OneToMany(mappedBy = "game", cascade = CascadeType.REMOVE)
    private List<Comment> comments = new ArrayList<>();
}
