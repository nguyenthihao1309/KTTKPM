package com.example.subcriberactivemq.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.TextMessage;
import java.util.Map;

@Component
public class SubscriberActiveMQListener {
    @Autowired
    @Qualifier("objectMap")
    private Map<Long, Object> message;

    @JmsListener(destination = "text-topic")
    public void receiveText(TextMessage textMessage) throws JMSException {
        message.put(System.currentTimeMillis(),"  Message: " +textMessage.getText());
        System.out.println(textMessage.getText());
    }
}
