package com.example.onthigk.listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Subcriber {
    @JmsListener(destination = "text-topic")
    public void receiveMessage(String message){
        System.out.println(message);
    }
}
