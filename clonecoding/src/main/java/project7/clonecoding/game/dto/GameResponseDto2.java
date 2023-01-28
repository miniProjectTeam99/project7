package project7.clonecoding.game.dto;

import lombok.Getter;
import project7.clonecoding.game.entity.Realtable;

@Getter
public class GameResponseDto2 {
    private Long id;
    private String gameTitle;
    private String titleImg;
    private Boolean playType;
    private String gamePrice;
    private String star;
    private String difficulty;
    private Boolean kit;
    private String playTime;
    private String[] gameImg;
    private String story;
    private String people;
    private String gameDesc;
    private String category;

    public GameResponseDto2(Realtable realtable, String[] valueList, String[] gameintroList){
        this.id = realtable.getId();
        gameTitle = valueList[1];
        titleImg = realtable.getThumbnail();
        playType = valueList[0].equals("모바일");
        gamePrice = valueList[2];
        star = valueList[3];
        difficulty = valueList[5];
        kit = valueList[7].equals("키트 없음");
        playTime = valueList[6];
        gameImg = gameintroList;
        story = realtable.getStory();
        people = realtable.getMember();
        gameDesc = realtable.getGuide();
        category = realtable.getCategory();
    }

}
