package com.TechConnecGrupo3.TechConnecapi.service.impl;

import com.TechConnecGrupo3.TechConnecapi.dto.AuthResponseDTO;
import com.TechConnecGrupo3.TechConnecapi.dto.LoginDTO;
import com.TechConnecGrupo3.TechConnecapi.mapper.UserMapper;
import com.TechConnecGrupo3.TechConnecapi.model.entity.User;
import com.TechConnecGrupo3.TechConnecapi.model.enums.RoleU;
import com.TechConnecGrupo3.TechConnecapi.repository.RoleRepository;
import com.TechConnecGrupo3.TechConnecapi.repository.UserRepository;
import com.TechConnecGrupo3.TechConnecapi.security.TokenProvider;
import com.TechConnecGrupo3.TechConnecapi.security.UserPrincipal;
import com.TechConnecGrupo3.TechConnecapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;


    private final AuthenticationManager authenticationManager;
    private final TokenProvider tokenProvider;

    @Override
    public AuthResponseDTO login(LoginDTO loginDTO) {
        //Autenticar al usuario utilizando AuthenticationManager
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDTO.getEmail(), loginDTO.getPassword())
        );

        //Una vez autenticado, el objeto authentication contiene la informacion del usuario autenticado
        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
        User user = userPrincipal.getUser();

        // Verificar si es un administrador
        boolean isAdmin = user.getRole().getName().equals(RoleU.ADMIN);

        String token=tokenProvider.createAccessToken(authentication);

        AuthResponseDTO responseDTO = userMapper.toAuthResponseDTO(user, token);

        return responseDTO;
    }


}
