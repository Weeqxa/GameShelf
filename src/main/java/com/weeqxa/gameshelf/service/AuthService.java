package com.weeqxa.gameshelf.service;

import com.weeqxa.gameshelf.dto.RegisterRequest;
import com.weeqxa.gameshelf.dto.RegisterResponse;
import com.weeqxa.gameshelf.entity.User;
import com.weeqxa.gameshelf.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    public RegisterResponse register(RegisterRequest request) {

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new IllegalArgumentException("User with this email already exists");
        }

        User user = new User(request.getEmail(), passwordEncoder.encode(request.getPassword()), request.getUsername());

        user.setCreatedAt(LocalDateTime.now());

        userRepository.save(user);

        return new RegisterResponse("User registered successfully");
    }

}
