package com.TechConnecGrupo3.TechConnecapi.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

// JWTConfigurer integra el filtro JWTFilter en la configuracion de seguridad de Spring Security.
@RequiredArgsConstructor
public class JWTConfigurer extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

    private final TokenProvider tokenProvider;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        // TODO: Crear una instancia del filtro JWTFilter, pasandole el TokenProvider que manejara la logica del JWT
        JWTFilter jwtFilter = new JWTFilter(tokenProvider);

        // TODO: Agregar el filtro JWTFilter a la cadena de seguridad de Spring Security,
        // asegurando que se ejecute antes del filtro de autenticacion de usuario y contrasena (UsernamePasswordAuthenticationFilter)
        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
    }
}
