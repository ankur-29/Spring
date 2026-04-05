package com.ankur.spring;

import org.springframework.stereotype.Component;

@Component
public class DieselEngine implements Engine {
    private final Battery battery;

    public DieselEngine(Battery battery) {
        this.battery = battery;
    }

    @Override
    public String start() {
        return battery.switchedOn() + "\nDiesel Engine started";
    }   
    
}
