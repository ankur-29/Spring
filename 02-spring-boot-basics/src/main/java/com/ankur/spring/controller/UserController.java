package com.ankur.spring.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import com.ankur.spring.dto.UserRequestDTO;
import com.ankur.spring.dto.UserResponseDTO;
import com.ankur.spring.service.UserService;

@RestController
public class UserController {

    private static  final Logger logger = LoggerFactory.getLogger(UserController.class);
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
    public ResponseEntity<?> addUser(@Valid @RequestBody UserRequestDTO userDTO) {
        logger.info("Received request to create user: {}", userDTO.getName());
        UserResponseDTO response = userService.createUser(userDTO);
        logger.info("User created successfully: {}", response.getName());
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}