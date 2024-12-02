package com.TechConnecGrupo3.TechConnecapi.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-01T13:51:21-0500",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.4 (Eclipse Adoptium)"
)
@Component
public class NotificationMapperImpl implements NotificationMapper {

    @Override
    public NotificationDTO toDTO(Notification notification) {
        if ( notification == null ) {
            return null;
        }

        NotificationDTO notificationDTO = new NotificationDTO();

        notificationDTO.setMessage( notification.getMessage() );
        if ( notification.getNotificationType() != null ) {
            notificationDTO.setNotificationType( notification.getNotificationType().name() );
        }
        notificationDTO.setSentAt( notification.getSentAt() );

        return notificationDTO;
    }

    @Override
    public Notification toEntity(NotificationDTO notificationDTO) {
        if ( notificationDTO == null ) {
            return null;
        }

        Notification notification = new Notification();

        notification.setMessage( notificationDTO.getMessage() );
        if ( notificationDTO.getNotificationType() != null ) {
            notification.setNotificationType( Enum.valueOf( NotificationType.class, notificationDTO.getNotificationType() ) );
        }
        notification.setSentAt( notificationDTO.getSentAt() );

        return notification;
    }
}
