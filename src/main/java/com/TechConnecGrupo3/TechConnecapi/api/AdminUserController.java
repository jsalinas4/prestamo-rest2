package com.TechConnecGrupo3.TechConnecapi.api;

import com.TechConnecGrupo3.TechConnecapi.dto.UserDTO;
import com.TechConnecGrupo3.TechConnecapi.dto.UserResponseDTO;
import com.TechConnecGrupo3.TechConnecapi.model.entity.User;
import com.TechConnecGrupo3.TechConnecapi.service.AdminUserService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/users")
@RequiredArgsConstructor
public class AdminUserController {

    private final AdminUserService adminUserService;

    @GetMapping
    public List<User> listAll() {
        return adminUserService.findAll();
    }

    @GetMapping("/page")
    public Page<User> paginate(@PageableDefault(size = 5, sort = "firstName") Pageable pageable) {
        return adminUserService.paginate(pageable);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public UserDTO create(@RequestBody UserDTO user) {
        return adminUserService.create(user);
    }

    @GetMapping("/{id}")
    public UserResponseDTO getById(@PathVariable Integer id) {
        return adminUserService.findByIdDTO(id);
    }

    @PutMapping("/{id}")
    public User update(@PathVariable Integer id, @RequestBody User user) {
        return adminUserService.update(id, user);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        adminUserService.delete(id);
    }

    @PostMapping("/reset/{id}")
    public User resetPassword(@PathVariable Integer id, @RequestBody User user) {return adminUserService.resetPassword(id, user);}

    @DeleteMapping("/delete-account/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable Integer id) {
        adminUserService.deleteAccount(id);
        return new ResponseEntity<>("Account deleted successfully", HttpStatus.OK);
    }
}
