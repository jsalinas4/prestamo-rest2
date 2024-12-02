package com.TechConnecGrupo3.TechConnecapi.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-01T13:51:21-0500",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.4 (Eclipse Adoptium)"
)
@Component
public class EventEditMapperImpl implements EventEditMapper {

    @Override
    public EventEditDTO toDTO(Event event) {
        if ( event == null ) {
            return null;
        }

        EventEditDTO eventEditDTO = new EventEditDTO();

        eventEditDTO.setId( event.getEventId() );
        eventEditDTO.setTitle( event.getTitle() );
        eventEditDTO.setDescription( event.getDescription() );
        eventEditDTO.setLocation( event.getLocation() );
        eventEditDTO.setEventDate( event.getEventDate() );
        eventEditDTO.setEventTime( event.getEventTime() );

        return eventEditDTO;
    }

    @Override
    public Event toEntity(EventEditDTO eventEditDTO) {
        if ( eventEditDTO == null ) {
            return null;
        }

        Event event = new Event();

        event.setTitle( eventEditDTO.getTitle() );
        event.setDescription( eventEditDTO.getDescription() );
        event.setLocation( eventEditDTO.getLocation() );
        event.setEventDate( eventEditDTO.getEventDate() );
        event.setEventTime( eventEditDTO.getEventTime() );

        return event;
    }
}
