package com.ankur.spring.service;

import org.springframework.stereotype.Service;

import com.ankur.spring.dto.UserRequestDTO;
import com.ankur.spring.dto.UserResponseDTO;
import com.ankur.spring.model.User;

@Service
public class UserService {

    public UserResponseDTO createUser(UserRequestDTO userDTO) {

        // Convert DTO → Entity
        User user = new User();
        user.setName(userDTO.getName());
        user.setAge(userDTO.getAge());

        // (Later: Save to DB)

        // Convert Entity → Response DTO
        return new UserResponseDTO(user.getName());
    }
}