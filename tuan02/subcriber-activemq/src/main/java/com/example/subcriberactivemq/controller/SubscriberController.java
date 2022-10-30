package com.example.subcriberactivemq.controller;

import com.example.subcriberactivemq.listener.SubscriberActiveMQListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class SubscriberController {
    @Autowired
    @Qualifier("objectMap")
    private Map<Long, Object> messages;

    private SubscriberActiveMQListener listener;

    @GetMapping("/")
    public String showHome(Model model){
        model.addAttribute("messages", messages);
        return "home";
    }
}
