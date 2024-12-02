package com.TechConnecGrupo3.TechConnecapi.mapper;

import com.TechConnecGrupo3.TechConnecapi.dto.AuthResponseDTO;
import com.TechConnecGrupo3.TechConnecapi.dto.UserDTO;
import com.TechConnecGrupo3.TechConnecapi.dto.UserResponseDTO;
import com.TechConnecGrupo3.TechConnecapi.model.entity.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-02T18:28:18-0500",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.4 (Eclipse Adoptium)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDTO toDTO(User user) {
        if ( user == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setUserId( user.getUserId() );
        userDTO.setName( user.getName() );
        userDTO.setEmail( user.getEmail() );
        userDTO.setPassword( user.getPassword() );

        return userDTO;
    }

    @Override
    public User toEntity(UserDTO userDTO) {
        if ( userDTO == null ) {
            return null;
        }

        User user = new User();

        user.setUserId( userDTO.getUserId() );
        user.setName( userDTO.getName() );
        user.setEmail( userDTO.getEmail() );
        user.setPassword( userDTO.getPassword() );

        return user;
    }

    @Override
    public UserResponseDTO toResponseDTO(UserDTO userDTO) {
        if ( userDTO == null ) {
            return null;
        }

        UserResponseDTO userResponseDTO = new UserResponseDTO();

        userResponseDTO.setUserId( userDTO.getUserId() );
        userResponseDTO.setName( userDTO.getName() );
        userResponseDTO.setEmail( userDTO.getEmail() );

        return userResponseDTO;
    }

    @Override
    public AuthResponseDTO toAuthResponseDTO(User user, String token) {
        if ( user == null && token == null ) {
            return null;
        }

        AuthResponseDTO authResponseDTO = new AuthResponseDTO();

        if ( user != null ) {
            authResponseDTO.setId( user.getUserId() );
        }
        authResponseDTO.setToken( token );
        authResponseDTO.setFirstName( getFirstName(user) );
        authResponseDTO.setRole( user.getRole().getName().name() );

        return authResponseDTO;
    }
}
