package com.auth.jwt_example.dto;

//import lombok.Data;
//import lombok.Getter;
//import lombok.Setter;

//@Setter
//@Getter
public class LoginUserDto {
    private String email;

    private String password;

    // getters and setters here...

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
