package com.example.publisheractivemq.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageType;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableJms
@ComponentScan(basePackages = "com.example")
public class PublisherActiveMQConfig {
    private static final String BROKER_URL = "tcp://localhost:61616";
    private static final String BROKER_USERNAME = "admin";
    private static final String BROKER_PASSWORD = "admin";

    @Bean
    public ActiveMQConnectionFactory activeMQConnectionFactory() {
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory();
        factory.setBrokerURL(BROKER_URL);
        factory.setUserName(BROKER_USERNAME);
        factory.setPassword(BROKER_PASSWORD);
        return factory;
    }

    @Bean
    public JmsTemplate jmsTemplate() {
        JmsTemplate jmsTemplate = new JmsTemplate();
        jmsTemplate.setConnectionFactory(activeMQConnectionFactory());
        return jmsTemplate;
    }

    
    @Bean
    public MappingJackson2MessageConverter messageConverter() {
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        converter.setTargetType(MessageType.TEXT);
        converter.setTypeIdPropertyName("_type");
        return converter;
    }

    @Bean
    public Map<Long, Object> objectMapMessage(){
        return  new HashMap<>();
    }
}
