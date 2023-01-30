package project7.clonecoding.game.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import project7.clonecoding.game.entity.Game;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
public class GameResponseDto {
    private Long id;
    private String gameTitle;
    private String titleImg;
    private Boolean playType;
    private String gamePrice;
    private String star;
    private String difficulty;
    private Boolean kit;
    private String playTime;
    private String gameImg;
    private String story;
    private String people;
    private String gameDesc;
    private String category;
    private List<Game> games;

    public GameResponseDto(List<Game> game, int sc){
        games = game;
    }
    public GameResponseDto(List<Game> game, String Rct){
        games = game;
    }
//    public GameResponseDto(Game game, Long Id){
//        this.id = game.getId();
//        gameTitle = game.getGameTitle();
//        titleImg = game.getTitleImg();
//        playType = game.getPlayType();
//        gamePrice = game.getGamePrice();
//        star = game.getStar();
//        difficulty = game.getDifficulty();
//        kit = game.getKit();
//        playTime = game.getPlayTime();
//        gameImg = game.getGameImg();
//        story = game.getStory();
//        people = game.getPeople();
//        gameDesc = game.getGameDesc();
//        category = game.getCategory();
//    }
    public GameResponseDto(Game game, int sc){//평점순
        this.id = game.getId();
        titleImg = game.getTitleImg();
        gameTitle = game.getGameTitle();
        star = game.getStar();
        gamePrice = game.getGamePrice();
        gameDesc = game.getGameDesc();
    }
    public GameResponseDto(Game game, String Rct){//최신순
        this.id = game.getId();
        titleImg = game.getTitleImg();
        gameTitle = game.getGameTitle();
        gamePrice = game.getGamePrice();
        gameDesc = game.getGameDesc();
        category = game.getCategory();
    }
    public GameResponseDto(Game game, Long Id, int sc){//게임 이미지+스토리
        this.id = game.getId();
        titleImg = game.getTitleImg();
        gameImg = game.getGameImg();
        story = game.getStory();
        gameDesc = game.getGameDesc();
    }
    public GameResponseDto(Game game, Long Id, String Rct){//게임 필요인원 및 평점 등등
        this.id = game.getId();
        playType = game.getPlayType();
        gameTitle = game.getGameTitle();
        star = game.getStar();
        gamePrice = game.getGamePrice();
        difficulty = game.getDifficulty();
        playTime = game.getPlayTime();
        kit = game.getKit();
    }
}
