package com.auth.jwt_example.exception;

import org.springframework.http.HttpStatusCode;

import java.time.LocalDateTime;

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
