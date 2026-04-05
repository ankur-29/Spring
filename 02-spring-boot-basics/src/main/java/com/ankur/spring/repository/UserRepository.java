package com.ankur.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ankur.spring.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    // JpaRepository provides basic CRUD operations for User entity
    // we will automatically get methods like save(), findById(), findAll(), deleteById() etc.
}