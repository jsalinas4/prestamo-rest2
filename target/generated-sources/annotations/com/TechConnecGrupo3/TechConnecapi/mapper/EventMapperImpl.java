package com.TechConnecGrupo3.TechConnecapi.mapper;

import com.TechConnecGrupo3.TechConnecapi.model.entity.User;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-01T13:51:22-0500",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.4 (Eclipse Adoptium)"
)
@Component
public class EventMapperImpl implements EventMapper {

    @Override
    public EventDTO toDTO(Event event) {
        if ( event == null ) {
            return null;
        }

        EventDTO eventDTO = new EventDTO();

        eventDTO.setOrganizerId( eventOrganizerUserId( event ) );
        eventDTO.setCategoryId( eventCategoryCategoryId( event ) );
        eventDTO.setExponentId( eventExponentExponent_id( event ) );
        eventDTO.setEventId( event.getEventId() );
        eventDTO.setTitle( event.getTitle() );
        eventDTO.setEventDate( event.getEventDate() );
        eventDTO.setUpdatedAt( event.getUpdatedAt() );
        eventDTO.setCreatedAt( event.getCreatedAt() );
        eventDTO.setEventTime( event.getEventTime() );
        if ( event.getTypeEvent() != null ) {
            eventDTO.setTypeEvent( event.getTypeEvent().name() );
        }
        eventDTO.setRegistration( event.getRegistration() );
        eventDTO.setShare( event.getShare() );
        eventDTO.setLocation( event.getLocation() );
        eventDTO.setDescription( event.getDescription() );
        eventDTO.setPrice( event.getPrice() );

        return eventDTO;
    }

    @Override
    public Event toEntity(EventDTO eventDTO) {
        if ( eventDTO == null ) {
            return null;
        }

        Event event = new Event();

        event.setEventId( eventDTO.getEventId() );
        event.setTitle( eventDTO.getTitle() );
        event.setDescription( eventDTO.getDescription() );
        event.setLocation( eventDTO.getLocation() );
        event.setShare( eventDTO.getShare() );
        event.setRegistration( eventDTO.getRegistration() );
        if ( eventDTO.getTypeEvent() != null ) {
            event.setTypeEvent( Enum.valueOf( EventType.class, eventDTO.getTypeEvent() ) );
        }
        event.setEventDate( eventDTO.getEventDate() );
        event.setEventTime( eventDTO.getEventTime() );
        event.setCreatedAt( eventDTO.getCreatedAt() );
        event.setUpdatedAt( eventDTO.getUpdatedAt() );
        event.setPrice( eventDTO.getPrice() );

        return event;
    }

    private Integer eventOrganizerUserId(Event event) {
        User organizer = event.getOrganizer();
        if ( organizer == null ) {
            return null;
        }
        return organizer.getUserId();
    }

    private Integer eventCategoryCategoryId(Event event) {
        Category category = event.getCategory();
        if ( category == null ) {
            return null;
        }
        return category.getCategoryId();
    }

    private Integer eventExponentExponent_id(Event event) {
        Exponent exponent = event.getExponent();
        if ( exponent == null ) {
            return null;
        }
        return exponent.getExponent_id();
    }
}
