package com.auth.jwt_example.exception;

public class CustomSubException extends CustomBadRequestException{
    public CustomSubException(String errorMsg) {
        super(errorMsg);
    }
}
