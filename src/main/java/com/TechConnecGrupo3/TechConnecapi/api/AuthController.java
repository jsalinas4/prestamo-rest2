package com.TechConnecGrupo3.TechConnecapi.api;


import com.TechConnecGrupo3.TechConnecapi.dto.AuthResponseDTO;
import com.TechConnecGrupo3.TechConnecapi.dto.LoginDTO;
import com.TechConnecGrupo3.TechConnecapi.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;


    @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> login(@Valid  @RequestBody LoginDTO loginDTO) {
        AuthResponseDTO authResponse = userService.login(loginDTO);
        return new ResponseEntity<>(authResponse, HttpStatus.OK);
    }
}
