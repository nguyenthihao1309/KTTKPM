package com.example.publisheractivemq.service;

import com.example.publisheractivemq.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.jms.*;
import java.io.Serializable;
import java.util.Map;

@Service
public class PublisherService {
    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    @Qualifier("objectMapMessage")
    private Map<Long, Object> mapMessage;

    public void publishPerson(Person person){
        jmsTemplate.convertAndSend("person-topic", person);
        mapMessage.put(System.currentTimeMillis(), person);
    }

    public void publishText(String text){
        jmsTemplate.send("text-topic", new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                TextMessage textMessage = session.createTextMessage();
                textMessage.setText(text);
                mapMessage.put(System.currentTimeMillis(), text);
                return textMessage;
            }
        });
    }

    public void publishObject(Object value){
        jmsTemplate.send("object-topic", new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                ObjectMessage objectMessage = session.createObjectMessage();
                objectMessage.setObject((Serializable) value);
                mapMessage.put(System.currentTimeMillis(), value);
                return objectMessage;
            }
        });
    }

}
