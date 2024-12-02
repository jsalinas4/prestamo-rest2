package com.TechConnecGrupo3.TechConnecapi.service;


import com.TechConnecGrupo3.TechConnecapi.dto.AuthResponseDTO;
import com.TechConnecGrupo3.TechConnecapi.dto.LoginDTO;


public interface UserService {

        // Authenticate user (login)
        AuthResponseDTO login(LoginDTO loginDTO);

}
