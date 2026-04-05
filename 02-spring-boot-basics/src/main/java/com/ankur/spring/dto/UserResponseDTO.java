package com.ankur.spring.dto;

public class UserResponseDTO {

    private String name;

    public UserResponseDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}