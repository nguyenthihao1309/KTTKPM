package com.example.cau2client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Cau2ClientApplication {
    @Value("${spring.datasource.url}")
    private String url;

    public static void main(String[] args) {
        SpringApplication.run(Cau2ClientApplication.class, args);
    }

    @GetMapping("/hi")
    public String hi() {
        return this.url;
    }

}
