package com.TechConnecGrupo3.TechConnecapi.dto;

import com.TechConnecGrupo3.TechConnecapi.model.enums.RoleU;
import lombok.Data;

@Data
public class UserProfileDTO {

    private Integer id;
    private String email;
    private RoleU role; // El rol puede ser CUSTOMER o AUTHOR
    private String firstName;
    private String lastName;

    private String shippingAddress;
    private String bio;
}
