package com.example.onthigk.controller;

import com.example.onthigk.model.User;
import com.example.onthigk.repository.UserRepository;
import com.example.onthigk.service.JWTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.web.bind.annotation.*;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
public class UserRestController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JWTService jwtService;
    @Autowired
    private JmsTemplate jmsTemplate;

    @PostMapping("/messages")
    public String sendMessage(@RequestParam String message){
        jmsTemplate.send("text-topic", new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(message);
            }
        });
        return message;
    }

    @PostMapping("/login")
    public String login(HttpServletResponse res, @RequestParam(name = "userName") String userName, @RequestParam(name = "password") String password) throws IOException {
        User user = userRepository.findByUserName(userName);
        if (user != null) {
            if (user.getPassword().equals(password)) {
                String tokenJWT = jwtService.generateToken(user);
                return tokenJWT;
            } else {
                res.sendError(401);
            }
        } else {
            res.sendError(404);
        }
        return "error";
    }

    @GetMapping("/users")
    public List<User> getUser() {
        return userRepository.findAll();
    }

    @PostMapping("/user")
    public User addUser(@RequestBody User user){
        return userRepository.save(user);
    }
}
