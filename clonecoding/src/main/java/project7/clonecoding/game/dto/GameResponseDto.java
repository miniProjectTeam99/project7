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

    public GameResponseDto(List<Game> game, int sc) {
        games = game;
    }

    public GameResponseDto(List<Game> game, String Rct) {
        games = game;
    }
    public GameResponseDto(List<Game> gameList) {
        games = gameList;
    }
    public GameResponseDto(Game game, int sc) {//평점순
        this.id = game.getId();
        titleImg = game.getTitleImg();
        gameTitle = game.getGameTitle();
        star = game.getStar();
        if (game.getGamePrice()==0) {
            gamePrice = "무료";
        } else {
            gamePrice = String.valueOf(game.getGamePrice());
        }
        story = game.getStory();
    }

    public GameResponseDto(Game game, String Rct) {//최신순
        this.id = game.getId();
        titleImg = game.getTitleImg();
        gameTitle = game.getGameTitle();
        if (game.getGamePrice()==0) {
            gamePrice = "무료";
        } else {
            gamePrice = String.valueOf(game.getGamePrice());
        }
        gameDesc = game.getGameDesc();
        category = game.getCategory();
    }

    public GameResponseDto(Game game, Long Id, int sc) {//게임 이미지+스토리
        this.id = game.getId();
        titleImg = game.getTitleImg();
        gameImg = game.getGameImg();
        story = game.getStory();
        gameDesc = game.getGameDesc();
    }

    public GameResponseDto(Game game, Long Id, String Rct) {//게임 필요인원 및 평점 등등
        this.id = game.getId();
        playType = game.getPlayType();
        gameTitle = game.getGameTitle();
        star = game.getStar();
        if (game.getGamePrice()==0) {
            gamePrice = "무료";
        } else {
            gamePrice = String.valueOf(game.getGamePrice());
        }
        difficulty = game.getDifficulty();
        playTime = game.getPlayTime();
        kit = game.getKit();
    }


}
