package com.TechConnecGrupo3.TechConnecapi.service;

import com.TechConnecGrupo3.TechConnecapi.dto.UserDTO;
import com.TechConnecGrupo3.TechConnecapi.dto.UserResponseDTO;
import com.TechConnecGrupo3.TechConnecapi.model.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface AdminUserService {
    List<User> findAll();
    Page<User> paginate(Pageable pageable);
    UserDTO create(UserDTO user);
    UserResponseDTO findByIdDTO(Integer id);

    User findById(Integer id);

    @Transactional
    User update(Integer id, User updatedUser);

    void delete(Integer id);

    User resetPassword(Integer id,User user);
    void deleteAccount(Integer id);
}