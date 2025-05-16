package io.github.Psm0015.jwtAuth.model.dtos;

public record LoginResponseDto(
        String token,
        long expiresIn
) {
}
