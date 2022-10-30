package com.example.cau2server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class Cau2ServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(Cau2ServerApplication.class, args);
    }

}
