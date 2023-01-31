package project7.clonecoding.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RestApiException {
    private String msg;
    private int httpStatus;
}