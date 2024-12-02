package com.TechConnecGrupo3.TechConnecapi.model.entity;

import com.TechConnecGrupo3.TechConnecapi.model.enums.RoleU;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(name = "name", nullable = false, unique = true)
    private RoleU name;
}
