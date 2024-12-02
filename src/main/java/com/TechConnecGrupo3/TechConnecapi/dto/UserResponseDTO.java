package com.TechConnecGrupo3.TechConnecapi.dto;

import lombok.Data;

@Data
public class UserResponseDTO {
    private Integer userId;
    private String name;
    private String email;
    private String interests;
    private String skills;
    private String link;
    private String profilePicture;
}
