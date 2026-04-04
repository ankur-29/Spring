package com.ankur.spring;

import org.springframework.stereotype.Component;

@Component
public class Engine {
    private final Battery battery;

    // Constructor injection
    public Engine(Battery battery) {
        this.battery = battery;
    }

    public String start() {
        return battery.switchedOn() + "\nEngine started";
    }
}