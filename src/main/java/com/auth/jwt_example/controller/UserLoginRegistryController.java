package com.auth.jwt_example.controller;

import com.auth.jwt_example.dto.LoginResponse;
import com.auth.jwt_example.dto.LoginUserDto;
import com.auth.jwt_example.dto.RegisterUserDto;
import com.auth.jwt_example.entity.User;
import com.auth.jwt_example.exception.CustomBadRequestException;
import com.auth.jwt_example.exception.CustomSubException;
import com.auth.jwt_example.exception.ExceptionResponse;
import com.auth.jwt_example.services.AuthenticationService;
import com.auth.jwt_example.services.JwtService;
import org.springframework.http.HttpStatusCode;
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
    public ResponseEntity<?> register(@RequestBody RegisterUserDto registerUserDto) {
        User registeredUser = null;
        try {
            registeredUser = authenticationService.signup(registerUserDto);
        } catch (Exception ex){
            throw new CustomBadRequestException(ex.getLocalizedMessage());
        }
        return ResponseEntity.ok(registeredUser); // http response entity
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginUserDto loginUserDto) {
        LoginResponse loginResponse = null;
        try {
            User authenticatedUser = authenticationService.authenticate(loginUserDto);
            String jwtToken = jwtService.generateToken(authenticatedUser);

            loginResponse =
                    new LoginResponse();
            loginResponse.setExpiresIn(jwtService.getExpirationTime());
            loginResponse.setToken(jwtToken);
        } catch (Exception ex){
            throw new CustomSubException(ex.getLocalizedMessage());
        }
        return ResponseEntity.ok(loginResponse);
    }

    /**
     * wherever BadRequestException will be thrown, it will be caught here
     * it takes the same class as parameter
     * only works for one class, so can use subclass for diff apis
     *
      */
    @ExceptionHandler(CustomBadRequestException.class)
    public ResponseEntity<?> handleException(CustomBadRequestException badRequestException){
        ExceptionResponse exceptionResponse = new ExceptionResponse(HttpStatusCode.valueOf(403),
                badRequestException.getLocalizedMessage());
        return ResponseEntity.badRequest().body(exceptionResponse);
    }
}
