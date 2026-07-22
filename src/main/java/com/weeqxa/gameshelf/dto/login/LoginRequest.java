package com.weeqxa.gameshelf.dto.login;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Schema(
        name = "LoginRequest",
        description = "Request body for user authentication"
)
public class LoginRequest {


    @Schema(
            name = "email",
            description = "User email address used for authentication",
            example = "test@gmail.com"
    )
    @NotBlank(message = "Email is required")
    @Email(message = "Email is not valid")
    private String email;

    @Schema(
            name = "password",
            description = "User password. Length must be between 8 and 20 characters",
            example = "vQ7!mZ2#Lp9@xR4$Kd8",
            minLength = 8,
            maxLength = 20
    )
    @NotBlank(message = "Password is required")
    @Size(min = 8, max = 20)
    private String password;


}
