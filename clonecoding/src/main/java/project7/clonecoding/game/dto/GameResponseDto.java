package project7.clonecoding.game.dto;

import project7.clonecoding.game.entity.Game;
import lombok.Getter;
import project7.clonecoding.user.entity.Users;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class GameResponseDto {
    private Long id;
    private String username;
    private String gameTitle;
    private String description;
    private String category;
    private float star;
    private String createdAt;
    private String modifiedAt;
//    private String imageUrl;
    private boolean state;

    public GameResponseDto(Game game){
        this.id = game.getId();
        this.gameTitle = game.getGameTitle();
        this.description = game.getDescription();
//        this.imageUrl = game.getImageUrl();
        this.star= game.getStar();
        this.createdAt = game.getCreatedAt();
        this.modifiedAt = game.getModifiedAt();
    }

}
