package com.TechConnecGrupo3.TechConnecapi.mapper;

import com.TechConnecGrupo3.TechConnecapi.dto.AuthResponseDTO;
import com.TechConnecGrupo3.TechConnecapi.dto.UserDTO;
import com.TechConnecGrupo3.TechConnecapi.dto.UserResponseDTO;
import com.TechConnecGrupo3.TechConnecapi.model.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "role", ignore = true)
    UserDTO toDTO(User user);
    @Mapping(target = "role", ignore = true)
    User toEntity(UserDTO userDTO);

    UserResponseDTO toResponseDTO(UserDTO userDTO);

    @Mapping(target = "id", source = "user.userId")
    @Mapping(target = "token", source = "token")
    @Mapping(target = "firstName", expression = "java(getFirstName(user))")
    @Mapping(target = "role", expression = "java(user.getRole().getName().name())")
    AuthResponseDTO toAuthResponseDTO(User user, String token);

    default String getFirstName(User user) {


        return user.getName();
    }
}
