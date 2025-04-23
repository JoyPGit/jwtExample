package com.auth.jwt_example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;

@ResponseStatus(value=HttpStatus.BAD_REQUEST, reason= "Error in json")
public class ExceptionResponse {
    private HttpStatusCode statusCode;
    private String errorMsg;
    private LocalDateTime timeStamp;

    public ExceptionResponse(HttpStatusCode code, String msg) {
        this.statusCode = code;
        this.errorMsg = msg;
        this.timeStamp =LocalDateTime.now();
    }

    // w.o getters and setters


    public HttpStatusCode getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(HttpStatusCode statusCode) {
        this.statusCode = statusCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }
}
