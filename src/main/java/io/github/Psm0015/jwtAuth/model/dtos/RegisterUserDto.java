package io.github.Psm0015.jwtAuth.model.dtos;

import jakarta.validation.constraints.NotBlank;

public record RegisterUserDto(
        @NotBlank(message = "campo obrigatorio")
        String email,
        @NotBlank(message = "campo obrigatorio")
        String password,
        @NotBlank(message = "campo obrigatorio")
        String fullName
) {
}
