package com.example.publisheractivemq.controller;

import com.example.publisheractivemq.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class PublisherController {
    @Autowired
    private PublisherService publisherService;
    @Autowired
    @Qualifier("objectMapMessage")
    private Map<Long, Object> mapMessage;

    @GetMapping("/")
    public String openHome(Model model) {
        model.addAttribute("messages", mapMessage);
        return "home";
    }

    @PostMapping("/publish")
    public String sendMessage(Model model, @RequestParam String message) {
        System.out.println(message);
        publisherService.publishText(message);
        System.out.println("list message: " + mapMessage);
        return "redirect:/";
    }

}
