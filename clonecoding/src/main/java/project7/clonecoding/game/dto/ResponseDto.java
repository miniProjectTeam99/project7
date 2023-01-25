package project7.clonecoding.game.dto;

import lombok.Getter;

@Getter
public class ResponseDto {
    private String message;

    public ResponseDto(String msg) {
        this.message = msg;
    }
}