package com.weeqxa.gameshelf.dto.register;

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
        name = "RegisterRequest",
        description = "Request body for creating a new user account"
)
public class RegisterRequest {

    @Schema(
            name = "email",
            description = "User email address used for registration",
            example = "test@gmail.com"
    )
    @NotBlank(message = "Email is required")
    @Email(message = "Email is not valid")
    private String email;


    @Schema(
            name = "password",
            description = "User password. Must contain between 8 and 20 characters",
            example = "vQ7!mZ2#Lp9@xR4$Kd8",
            minLength = 8,
            maxLength = 20
    )
    @NotBlank(message = "Password is required")
    @Size(min = 8, max = 20)
    private String password;


    @Schema(
            name = "username",
            description = "Unique username displayed to other users",
            example = "Alex_1999",
            minLength = 3,
            maxLength = 20
    )
    @NotBlank(message = "Username is required")
    @Size(min = 3, max = 20)
    private String username;

}
