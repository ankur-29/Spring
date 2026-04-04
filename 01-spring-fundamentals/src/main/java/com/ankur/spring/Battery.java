package com.ankur.spring;

import org.springframework.stereotype.Component;

@Component
public class Battery {
    public String switchedOn() {
        return "Battery is switched on";
    }
}
