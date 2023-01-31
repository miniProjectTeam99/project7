package project7.clonecoding.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {
    Duplicated_Email,
    INVALID_INPUT_VALUE,
    RESOURCE_NOT_FOUND,
    INTERNAL_SERVER_ERROR
}