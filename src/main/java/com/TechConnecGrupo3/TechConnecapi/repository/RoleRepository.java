package com.TechConnecGrupo3.TechConnecapi.repository;


import com.TechConnecGrupo3.TechConnecapi.model.entity.Role;
import com.TechConnecGrupo3.TechConnecapi.model.enums.RoleU;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    //Buscar un rol por su nombre (usando el enum)
    Optional<Role> findByName(RoleU name);
}
