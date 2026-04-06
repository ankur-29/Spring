package com.ankur.spring.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ankur.spring.dto.UserRequestDTO;
import com.ankur.spring.dto.UserResponseDTO;
import com.ankur.spring.service.UserService;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public ResponseEntity<?> getUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PostMapping("/users")
    public ResponseEntity<?> addUser(@RequestBody UserRequestDTO userDTO) {

        if (userDTO == null) {
            return ResponseEntity.badRequest().body("User cannot be null");
        }

        if (userDTO.getName() == null || userDTO.getName().trim().isEmpty()) {
            return ResponseEntity.badRequest().body("User name cannot be empty");
        }

        if (userDTO.getAge() < 18) {
            return ResponseEntity.badRequest().body("User must be at least 18 years old");
        }
        UserResponseDTO response = userService.createUser(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}