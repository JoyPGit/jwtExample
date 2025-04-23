package com.auth.jwt_example.dto;

//import lombok.Builder;
//import lombok.Getter;
//import lombok.Setter;

//@Getter
//@Setter
//@Builder
public class LoginResponse {
    private String token;

    private long expiresIn;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public long getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(long expiresIn) {
        this.expiresIn = expiresIn;
    }
}
