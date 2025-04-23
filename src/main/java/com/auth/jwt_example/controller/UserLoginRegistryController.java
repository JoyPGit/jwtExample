package com.auth.jwt_example.controller;

import com.auth.jwt_example.dto.LoginResponse;
import com.auth.jwt_example.dto.LoginUserDto;
import com.auth.jwt_example.dto.RegisterUserDto;
import com.auth.jwt_example.entity.User;
import com.auth.jwt_example.exception.ExceptionResponse;
import com.auth.jwt_example.services.AuthenticationService;
import com.auth.jwt_example.services.JwtService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/auth")
@RestController
public class UserLoginRegistryController {
    private final JwtService jwtService;

    private final AuthenticationService authenticationService;

    public UserLoginRegistryController(JwtService jwtService, AuthenticationService authenticationService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/signup")
    public ResponseEntity<?> register(@RequestBody RegisterUserDto registerUserDto) throws ExceptionResponse {
        User registeredUser = null;
        try {
            registeredUser = authenticationService.signup(registerUserDto);
        } catch (Exception ex){
            return ResponseEntity.badRequest().body(ex.getMessage());
            // entity
        }

        return ResponseEntity.ok(registeredUser); // http response entity
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginUserDto loginUserDto) {
        User authenticatedUser = authenticationService.authenticate(loginUserDto);

        String jwtToken = jwtService.generateToken(authenticatedUser);

        LoginResponse loginResponse =
                new LoginResponse();
        loginResponse.setExpiresIn(jwtService.getExpirationTime());
        loginResponse.setToken(jwtToken);

        return ResponseEntity.ok(loginResponse);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)

    public ResponseEntity<ExceptionResponse> handleException(String msg) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(HttpStatus.BAD_REQUEST,
                msg));
    }

}
