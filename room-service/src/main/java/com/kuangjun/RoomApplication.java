package com.kuangjun;

import com.kuangjun.controller.RoomController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RoomApplication {
    public static void main(String[] args) {
        SpringApplication.run(RoomController.class, args);
    }
}