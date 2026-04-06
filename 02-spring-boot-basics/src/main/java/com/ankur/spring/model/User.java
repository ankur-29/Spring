package com.ankur.spring.model;

import jakarta.persistence.*;

// @Entity meaning Map class to table
@Entity
// @Table meaning Map class to table with name "users", 
// if not specified, it will take class name as table name
@Table(name = "users") 
public class User {

    // @Id meaning Primary key
    @Id
    // @GeneratedValue meaning Auto-increment the id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String name;
    private int age;

    // Getters & Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Long getId() {
        return id;
    }
}