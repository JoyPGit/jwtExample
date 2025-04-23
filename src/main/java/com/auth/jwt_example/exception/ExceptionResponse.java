package com.auth.jwt_example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;

@ResponseStatus(value=HttpStatus.BAD_REQUEST, reason= "Error in json")
public class ExceptionResponse extends Exception{
    private HttpStatus statusCode;
    private String errorMsg;
    private LocalDateTime timeStamp;

    public ExceptionResponse(HttpStatus code, String msg) {
        this.statusCode = code;
        this.errorMsg = msg;
        this.timeStamp =LocalDateTime.now();
    }
}
