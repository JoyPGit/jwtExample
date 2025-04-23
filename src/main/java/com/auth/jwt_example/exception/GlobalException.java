package com.auth.jwt_example.exception;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {

    /**
     * works for multiple apis in diff controllers
     *
     * @param badRequestException
     * @return
     */
    @ExceptionHandler(CustomBadRequestException.class)
    public ResponseEntity<?> handleException(CustomBadRequestException badRequestException){
        ExceptionResponse exceptionResponse = new ExceptionResponse(HttpStatusCode.valueOf(403),
                badRequestException.getLocalizedMessage());
        return ResponseEntity.badRequest().body(exceptionResponse);
    }
}
