package com.ankur.spring.service;

import org.springframework.stereotype.Service;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ankur.spring.repository.UserRepository;
import com.ankur.spring.dto.UserRequestDTO;
import com.ankur.spring.dto.UserResponseDTO;
import com.ankur.spring.model.User;
import com.ankur.spring.exception.UserNotFoundException;

@Service
public class UserService {

    private final UserRepository userRepository;
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponseDTO createUser(UserRequestDTO userDTO) {
        logger.debug("Converting DTO to Entity"); // Debug log for DTO to Entity conversion
        // Convert DTO → Entity
        User user = new User();
        user.setName(userDTO.getName());
        user.setAge(userDTO.getAge());
        
        logger.debug("Saving user to database");// Debug log before saving to DB
        
        // Save to DB
        User savedUser = userRepository.save(user);

        // Info log after saving to DB
        logger.info("User saved with id: {}", savedUser.getId());

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