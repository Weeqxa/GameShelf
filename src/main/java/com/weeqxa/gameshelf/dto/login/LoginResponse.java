package com.weeqxa.gameshelf.dto.login;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LoginResponse {

    private String message;

    private String token;
}
