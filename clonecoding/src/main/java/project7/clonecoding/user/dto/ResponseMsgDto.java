package project7.clonecoding.user.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseMsgDto {
    private String msg;
    private Integer httpStatus;

    public ResponseMsgDto(String msg, Integer httpStatus) {
        this.msg = msg;
        this.httpStatus = httpStatus;
    }
}

