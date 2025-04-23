package com.auth.jwt_example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;

//@ResponseStatus(value=HttpStatus.BAD_REQUEST, reason= "Error in json")
public class CustomBadRequestException extends RuntimeException{
    private String errorMsg;
    public CustomBadRequestException(String errorMsg){
        this.errorMsg = errorMsg;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
