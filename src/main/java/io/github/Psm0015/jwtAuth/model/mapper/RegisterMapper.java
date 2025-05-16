package io.github.Psm0015.jwtAuth.model.mapper;

import io.github.Psm0015.jwtAuth.model.Usuario;
import io.github.Psm0015.jwtAuth.model.dtos.RegisterUserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RegisterMapper {
    Usuario RegisterUserDtoToUsuario(RegisterUserDto registerUser);
    RegisterUserDto UsuarioDtoToRegisterUserDto(Usuario usuario);
}
