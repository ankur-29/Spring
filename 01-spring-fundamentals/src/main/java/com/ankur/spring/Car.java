package com.ankur.spring;

import org.springframework.stereotype.Component;

@Component
public class Car {
    private final Engine engine;

    // Constructor injection
    public Car(Engine engine) {
        this.engine = engine;
    }

    public void drive() {
        System.out.println(engine.start());
        System.out.println("Car is driving");
    }
}
