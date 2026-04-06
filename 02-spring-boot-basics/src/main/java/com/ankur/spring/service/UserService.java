package com.ankur.spring.service;

import org.springframework.stereotype.Service;
import java.util.List;

import com.ankur.spring.repository.UserRepository;
import com.ankur.spring.dto.UserRequestDTO;
import com.ankur.spring.dto.UserResponseDTO;
import com.ankur.spring.model.User;
import com.ankur.spring.exception.UserNotFoundException;

@Service
public class UserService {

    private final UserRepository userRepository;
    
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponseDTO createUser(UserRequestDTO userDTO) {
        // Convert DTO → Entity
        User user = new User();
        user.setName(userDTO.getName());
        user.setAge(userDTO.getAge());
        
        // Save to DB
        User savedUser = userRepository.save(user);

        // Convert Entity → Response DTO
        return new UserResponseDTO(savedUser.getName());
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));
    }
}