package com.ankur.spring;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class PetrolEngine implements Engine {
    private final Battery battery;

    public PetrolEngine(Battery battery) {
        this.battery = battery;
    }

    @Override
    public String start() {
        return battery.switchedOn() + "\nPetrol Engine started";
    }   
    
}
