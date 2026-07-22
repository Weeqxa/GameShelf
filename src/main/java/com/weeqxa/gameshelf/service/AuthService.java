package com.weeqxa.gameshelf.service;

import com.weeqxa.gameshelf.dto.login.LoginRequest;
import com.weeqxa.gameshelf.dto.login.LoginResponse;
import com.weeqxa.gameshelf.dto.register.RegisterRequest;
import com.weeqxa.gameshelf.dto.register.RegisterResponse;
import com.weeqxa.gameshelf.entity.User;
import com.weeqxa.gameshelf.repository.UserRepository;
import com.weeqxa.gameshelf.security.JwtService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;


    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }


    public RegisterResponse register(RegisterRequest request) {

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new IllegalArgumentException("User with this email already exists");
        }

        User user = new User(request.getEmail(), passwordEncoder.encode(request.getPassword()), request.getUsername());

        userRepository.save(user);

        return new RegisterResponse("User registered successfully");
    }


    public LoginResponse login(LoginRequest request) {

        User user = userRepository.findByEmail(request.getEmail()).orElseThrow(() -> new IllegalArgumentException("User with this email not found"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())){
            throw new IllegalArgumentException("Wrong password");
        }

        return new LoginResponse("User successfully logged in", jwtService.generateToken(user));
    }





}
