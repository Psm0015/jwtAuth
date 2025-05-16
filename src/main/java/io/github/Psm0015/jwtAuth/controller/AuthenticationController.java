package io.github.Psm0015.jwtAuth.controller;

import io.github.Psm0015.jwtAuth.model.Usuario;
import io.github.Psm0015.jwtAuth.model.dtos.LoginResponseDto;
import io.github.Psm0015.jwtAuth.model.dtos.LoginUserDto;
import io.github.Psm0015.jwtAuth.model.dtos.RegisterUserDto;
import io.github.Psm0015.jwtAuth.service.AuthenticationService;
import io.github.Psm0015.jwtAuth.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/auth")
@RestController
@RequiredArgsConstructor
public class AuthenticationController {

    private final JwtService jwtService;
    private final AuthenticationService authenticationService;

    @PostMapping("/signup")
    public ResponseEntity<Usuario> register(@RequestBody RegisterUserDto registerUserDto) {
        Usuario registeredUser = authenticationService.signup(registerUserDto);

        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> authenticate(@RequestBody LoginUserDto loginUserDto) {
        Usuario authenticatedUser = authenticationService.authenticate(loginUserDto);

        String jwtToken = jwtService.generateToken(authenticatedUser);

        LoginResponseDto loginResponse = new LoginResponseDto(jwtToken, jwtService.getExpirationTime());

        return ResponseEntity.ok(loginResponse);
    }
}
