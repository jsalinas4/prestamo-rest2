package com.TechConnecGrupo3.TechConnecapi.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Permite solicitudes desde cualquier origen
        registry.addMapping("/**") // Esto aplica CORS a todas las rutas de la API
                .allowedOrigins("*") // Permite todos los origenes
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Permite todos los metodos HTTP
                .allowedHeaders("*")  // Permite todos los encabezados
                .allowCredentials(false); // No permite enviar cookies o credenciales
    }
}
