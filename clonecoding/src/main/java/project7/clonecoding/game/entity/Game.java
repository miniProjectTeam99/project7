package project7.clonecoding.game.entity;

import lombok.extern.slf4j.Slf4j;
import project7.clonecoding.game.dto.GameRequestDto;
import project7.clonecoding.game.dto.StarRequestDto;
import project7.clonecoding.timestamp.Timestamp;
import project7.clonecoding.user.entity.User; //유저 값
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
    //게임 이름
    @Column(nullable = false)
    private String gameTitle;
    //게임 설명
    @Column
    private String description;
    //상품 이미지 url
    @Column
    private String imageUrl="";
    //난이도
    @Column
    private String difficulty;
    //플레이타임
    @Column
    private String playTime;
    //별점
    @Column
    private float star=0;
    //게시글을 작성한 유저
    @Column
    private Long userId;

    public Game(GameRequestDto gameRequestDto) {
//        if(gameRequestDto.getImageResponseDto().getUrl() == null) {
//            this.imageUrl = "기본 이미지 주소";
//        }else{
//            this.imageUrl = gameRequestDto.getImageResponseDto().getUrl();
//        }
        this.gameTitle = gameRequestDto.getGameTitle();
        this.description = gameRequestDto.getDescription();
//        this.userId = user.getId();
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
