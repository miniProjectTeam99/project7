package project7.clonecoding.game.entity;

import lombok.extern.slf4j.Slf4j;
import project7.clonecoding.game.dto.GameRequestDto;
import project7.clonecoding.game.dto.StarRequestDto;
import project7.clonecoding.timestamp.Timestamp;
import lombok.Getter;
import lombok.NoArgsConstructor;


import javax.persistence.*;

@Slf4j
@NoArgsConstructor
@Getter
@Entity
public class Game extends Timestamp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    //게임 이름
    private String gameTitle;
    @Column
    //상세정보
    private String description;

    @Column
    //스토리
    private String story;

    @Column
    //게임 타이틀 이미지 url
    private String imageUrl="";

    @Column
    //게임 플레이 이미지 url
    private String galleryUrl="";

    @Column
    //난이도
    private String difficulty;

    @Column
    //플레이타임
    private String playTime;

    @Column
    //사람 수
    private int people;

    @Column(nullable = false)
    //별점
    private float star=0;

    @Column
    //키트 유무
    private boolean kit=false;

    public Game(GameRequestDto gameRequestDto) {
//        if(gameRequestDto.getImageResponseDto().getUrl() == null) {
//            this.imageUrl = "기본 이미지 주소";
//        }else{
//            this.imageUrl = gameRequestDto.getImageResponseDto().getUrl();
//        }
        this.gameTitle = gameRequestDto.getGameTitle();
        this.description = gameRequestDto.getDescription();
    }

    public void update(GameRequestDto request) {
        if(request.getGameTitle() != null) {
            this.gameTitle = request.getGameTitle();
        }
        if(request.getDescription() != null) {
            this.description = request.getDescription();
        }
    }
    public void update(StarRequestDto request) {

        this.star=request.getStar();
        log.info(String.valueOf(getStar()));
    }
}
