package com.ankur.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class App 
{
    public static void main( String[] args ) {
        ApplicationContext context = SpringApplication.run(App.class, args);
        Car car = context.getBean(Car.class);
        car.drive();
    }
}
