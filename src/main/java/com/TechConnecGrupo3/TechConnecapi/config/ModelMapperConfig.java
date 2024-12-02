package com.TechConnecGrupo3.TechConnecapi.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
    @Bean public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
