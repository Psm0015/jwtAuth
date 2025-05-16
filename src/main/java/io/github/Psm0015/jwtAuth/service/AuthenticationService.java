package io.github.Psm0015.jwtAuth.service;

import io.github.Psm0015.jwtAuth.model.Usuario;
import io.github.Psm0015.jwtAuth.model.dtos.LoginUserDto;
import io.github.Psm0015.jwtAuth.model.dtos.RegisterUserDto;
import io.github.Psm0015.jwtAuth.model.mapper.RegisterMapper;
import io.github.Psm0015.jwtAuth.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final RegisterMapper registerMapper;

    public Usuario signup(RegisterUserDto input) {
        Usuario user = registerMapper.RegisterUserDtoToUsuario(input);
        user.setPassword(passwordEncoder.encode(input.password()));
        return userRepository.save(user);
    }

    public Usuario authenticate(LoginUserDto input) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.email(),
                        input.password()
                )
        );

        return userRepository.findByEmail(input.email())
                .orElseThrow();
    }

}
