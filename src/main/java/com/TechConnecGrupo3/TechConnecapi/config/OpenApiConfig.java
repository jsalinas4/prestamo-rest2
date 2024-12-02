package com.TechConnecGrupo3.TechConnecapi.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info = @Info(title = "CRUD", version = "1.0.0", description = "Crud api rest"))
public class OpenApiConfig {
}
