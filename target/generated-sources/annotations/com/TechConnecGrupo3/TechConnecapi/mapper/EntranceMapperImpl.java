package com.TechConnecGrupo3.TechConnecapi.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-01T13:51:21-0500",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.4 (Eclipse Adoptium)"
)
@Component
public class EntranceMapperImpl implements EntranceMapper {

    @Override
    public EntranceDTO toDTO(Entrance entrance) {
        if ( entrance == null ) {
            return null;
        }

        EntranceDTO entranceDTO = new EntranceDTO();

        entranceDTO.setCode( entrance.getCode() );

        return entranceDTO;
    }

    @Override
    public Entrance toEntity(EntranceDTO entranceDTO) {
        if ( entranceDTO == null ) {
            return null;
        }

        Entrance entrance = new Entrance();

        entrance.setCode( entranceDTO.getCode() );

        return entrance;
    }
}
