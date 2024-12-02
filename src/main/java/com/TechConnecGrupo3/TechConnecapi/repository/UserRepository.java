package com.TechConnecGrupo3.TechConnecapi.repository;

import com.TechConnecGrupo3.TechConnecapi.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    void deleteById(Integer id);
    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);

    // Metodo para verificar si ya existe un cliente con el mismo nombre y apellido, excepto el usuario actual
    //boolean existsByNameAndUserIdNot(String firstName, String lastName, Integer userId);
}