package project7.clonecoding.game.entity;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.TypeDef;

import project7.clonecoding.timestamp.Timestamp;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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
    private String gamePrice;

    @Column//게임 점수(후시 4.9점)
    private String star;

    @Column//게임 난이도
    private String difficulty;

    @Column//kit유무
    private Boolean kit;

    @Column//게임 시간
    private String playTime;

    @Column(columnDefinition = "json")
    private String gameImg;

    @Column//게임 스토리
    private String story;

    @Column//게임 인원
    private String people;

    @Column//게임 상세
    private String gameDesc;

    @Column//게임 카테고리
    private String category;

}
