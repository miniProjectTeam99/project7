package project7.clonecoding.user.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserRequestDto {

    private String userName;
    private String email;
    private String password;
    private String passwordCheck;

}
