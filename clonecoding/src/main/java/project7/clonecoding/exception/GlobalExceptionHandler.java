package project7.clonecoding.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {IllegalArgumentException.class})
    public ResponseEntity<ErrorResponse> handleDuplicatedEmailException(IllegalArgumentException e) {
        log.error("IllegalArgumentException", e);
        final ErrorResponse response = ErrorResponse.of(ErrorCode.Duplicated_Email);
        return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
    }


//    @ExceptionHandler(Exception.class)
//    public  ResponseEntity<ErrorResponse> handleInvalidInputException(Exception e){
//        log.error("handleEntityNotFoundException",e);
//        final ErrorResponse response = ErrorResponse.of(ErrorCode.INVALID_INPUT_VALUE);
//        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
//    }
//
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<ErrorResponse> handleException(Exception e) {
////        ErrorCode errorCode = ErrorCode.INTERNAL_SERVER_ERROR;
////        ErrorResponse errorResponse = ErrorResponse.of(errorCode);
//        log.error("handleEntityNotFoundException",e);
//        final ErrorResponse response = ErrorResponse.of(ErrorCode.INTERNAL_SERVER_ERROR);
//        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
//    }
}