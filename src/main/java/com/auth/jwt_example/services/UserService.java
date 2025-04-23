package com.auth.jwt_example.services;

import com.auth.jwt_example.entity.User;
import com.auth.jwt_example.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public String getUserNameByEmail(String email) {
        return this.userRepository.findByEmail(email).get().getUsername();
    }
}
