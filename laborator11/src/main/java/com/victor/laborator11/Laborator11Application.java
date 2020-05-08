package com.victor.laborator11;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Laborator11Application {

    public static void main(String[] args) {
        System.setProperty("server.port", "8081");
        SpringApplication.run(Laborator11Application.class, args);
        System.out.println("Hello world!");
    }

}
