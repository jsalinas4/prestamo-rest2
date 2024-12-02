package com.TechConnecGrupo3.TechConnecapi.repository;

import com.TechConnecGrupo3.TechConnecapi.model.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}
