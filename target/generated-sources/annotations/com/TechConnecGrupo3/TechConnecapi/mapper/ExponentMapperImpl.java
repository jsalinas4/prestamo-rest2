package com.TechConnecGrupo3.TechConnecapi.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-01T13:51:22-0500",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.4 (Eclipse Adoptium)"
)
@Component
public class ExponentMapperImpl implements ExponentMapper {

    @Override
    public ExponentDTO toDTO(Exponent exponent) {
        if ( exponent == null ) {
            return null;
        }

        ExponentDTO exponentDTO = new ExponentDTO();

        exponentDTO.setName( exponent.getName() );
        exponentDTO.setDescription( exponent.getDescription() );
        exponentDTO.setExponent_id( exponent.getExponent_id() );

        return exponentDTO;
    }

    @Override
    public Exponent toEntity(ExponentDTO exponentDTO) {
        if ( exponentDTO == null ) {
            return null;
        }

        Exponent exponent = new Exponent();

        exponent.setExponent_id( exponentDTO.getExponent_id() );
        exponent.setName( exponentDTO.getName() );
        exponent.setDescription( exponentDTO.getDescription() );

        return exponent;
    }
}
