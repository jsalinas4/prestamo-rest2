package com.TechConnecGrupo3.TechConnecapi.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clientId;

    private String clientType; // Natural, Legal Entity, SME
    private String firstName;
    private String lastName;
    private String dniRuc;
    private String address;
    private String phone;
    private String email;

    // Getters and Setters
}