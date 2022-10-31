package com.example.cau01redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class Cau01RedisApplication {

    @Autowired
    private RedisTemplate template;

    public static void main(String[] args) {
        SpringApplication.run(Cau01RedisApplication.class, args);
    }

    @GetMapping("/")
    public String set() {
        template.opsForValue().set("spring", "hi spring-boot");
        return "Success";
    }

    @PostMapping("/")
    public String set(@RequestParam String key, @RequestParam String value){
        template.opsForValue().set(key,value);
        return "Add success!!!";
    }
    @GetMapping("/{key}")
    public String get(@PathVariable String key) {
        Object value = template.opsForValue().get(key);
        return (String) value;
    }

    @DeleteMapping("/{key}")
    public String delete(@PathVariable String key) {
        Object value = template.opsForValue().getAndDelete(key);
        return (String) value + " - DELETED";
    }

}
