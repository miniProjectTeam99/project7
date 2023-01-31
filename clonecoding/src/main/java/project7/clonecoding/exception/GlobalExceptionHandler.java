package project7.clonecoding.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
//    @ExceptionHandler(value = {IllegalArgumentException.class})
//    public ResponseEntity<ErrorResponse> handleApiRequestException(IllegalArgumentException ex) {
//        final ErrorCode errorCode = ErrorResponse.of(errorCode);
//        RestApiException restApiException = new RestApiException();
//        restApiException.setHttpStatus(HttpStatus.BAD_REQUEST);
//        restApiException.setErrorMessage(ex.getMessage());
//    }
}