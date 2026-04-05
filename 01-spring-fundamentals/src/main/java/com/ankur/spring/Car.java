package com.ankur.spring;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Car {
/**
 - private is used to encapsulate the Engine dependency, 
   ensuring it can only be accessed through the Car class
 - final is used to indicate that the Engine reference cannot be changed 
   after it is assigned in the constructor
**/
    private final Engine engine;

    // Constructor injection
    public Car(@Qualifier("dieselEngine") Engine engine) {
        this.engine = engine;
    }

    // field injection (not recommended)
    // @Autowired
    // private Engine engine;

    public void drive() {
        System.out.println(engine.start());
        System.out.println("Car is driving");
    }
}
