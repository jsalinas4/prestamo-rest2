package com.TechConnecGrupo3.TechConnecapi.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-01T13:51:22-0500",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.4 (Eclipse Adoptium)"
)
@Component
public class ChatMapperImpl implements ChatMapper {

    @Override
    public ChatDTO toDTO(Chat chat) {
        if ( chat == null ) {
            return null;
        }

        ChatDTO chatDTO = new ChatDTO();

        chatDTO.setMessage( chat.getMessage() );
        if ( chat.getChatType() != null ) {
            chatDTO.setChatType( chat.getChatType().name() );
        }
        chatDTO.setCreatedAt( chat.getCreatedAt() );

        return chatDTO;
    }

    @Override
    public Chat toEntity(ChatDTO chatDTO) {
        if ( chatDTO == null ) {
            return null;
        }

        Chat chat = new Chat();

        chat.setMessage( chatDTO.getMessage() );
        if ( chatDTO.getChatType() != null ) {
            chat.setChatType( Enum.valueOf( ChatType.class, chatDTO.getChatType() ) );
        }
        chat.setCreatedAt( chatDTO.getCreatedAt() );

        return chat;
    }
}
