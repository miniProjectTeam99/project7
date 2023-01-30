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

    public GameResponseDto(List<Game> game){
        games = game;
    }

    public GameResponseDto(Game game){
        this.id = game.getId();
        gameTitle = game.getGameTitle();
        titleImg = game.getTitleImg();
        playType = game.getPlayType();
        gamePrice = game.getGamePrice();
        star = game.getStar();
        difficulty = game.getDifficulty();
        kit = game.getKit();
        playTime = game.getPlayTime();
        gameImg = game.getGameImg();
        story = game.getStory();
        people = game.getPeople();
        gameDesc = game.getGameDesc();
        category = game.getCategory();
    }

}
