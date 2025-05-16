package io.github.Psm0015.jwtAuth.model.dtos;

import jakarta.validation.constraints.NotBlank;

public record LoginUserDto(
        @NotBlank(message = "campo obrigatorio")
        String email,
        @NotBlank(message = "campo obrigatorio")
        String password
) {
}
