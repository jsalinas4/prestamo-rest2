package com.TechConnecGrupo3.TechConnecapi.service.impl;

import com.TechConnecGrupo3.TechConnecapi.dto.UserDTO;
import com.TechConnecGrupo3.TechConnecapi.dto.UserResponseDTO;
import com.TechConnecGrupo3.TechConnecapi.exception.RoleNotFoundException;
import com.TechConnecGrupo3.TechConnecapi.mapper.UserMapper;
import com.TechConnecGrupo3.TechConnecapi.model.entity.Role;
import com.TechConnecGrupo3.TechConnecapi.model.entity.User;
import com.TechConnecGrupo3.TechConnecapi.model.enums.RoleU;
import com.TechConnecGrupo3.TechConnecapi.repository.RoleRepository;
import com.TechConnecGrupo3.TechConnecapi.repository.UserRepository;
import com.TechConnecGrupo3.TechConnecapi.service.AdminUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class AdminUserServiceImpl implements AdminUserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional(readOnly = true)
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<User> paginate(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    @Transactional
    public UserDTO create(UserDTO user) {
        boolean existsByEmail = userRepository.existsByEmail(user.getEmail());
        if(existsByEmail){
            throw new IllegalArgumentException("El email ya esta registrado");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User newUser = userMapper.toEntity(user);
        RoleU roleEnum = RoleU.valueOf(user.getRole());
        Role role = roleRepository.findByName(roleEnum)
                .orElseThrow(() -> new RoleNotFoundException("Error: Role is not found."));
        newUser.setRole(role);
        userRepository.save(newUser);
        UserDTO userDTO = userMapper.toDTO(newUser);
        userDTO.setRole(newUser.getRole().getName().toString());
        return userDTO;
    }

    @Override
    @Transactional(readOnly = true)
    public UserResponseDTO findByIdDTO(Integer id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontró usuario con ese id: " + id));
        UserDTO userDTO = userMapper.toDTO(user);
        return userMapper.toResponseDTO(userDTO);
    }

    @Override
    @Transactional(readOnly = true)
    public User findById(Integer id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontró usuario con ese id: " + id));
    }

    @Override
    @Transactional
    public User update(Integer id, User updatedUser) {
        User userFromDb = findById(id);
        userFromDb.setName(updatedUser.getName());
        userFromDb.setEmail(updatedUser.getEmail());
        userFromDb.setPassword(updatedUser.getPassword());
        return userRepository.save(userFromDb);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        User user = findById(id);
        userRepository.delete(user);
    }
    @Override
    @Transactional
    public User resetPassword(Integer id, User user) {
        User userFromDb = findById(id);
        userFromDb.setPassword(user.getPassword());
        return userRepository.save(userFromDb);
    }

    @Override
    public void deleteAccount(Integer id) {
        User userFromDb = findById(id);
        userRepository.delete(userFromDb);
    }
    public ResponseEntity<String> deleteAccount(Integer id, User user) {
        User userFromDb = findById(id);
        userRepository.delete(userFromDb);
        return new ResponseEntity<>("Account deleted successfully", HttpStatus.OK);
    }
}
