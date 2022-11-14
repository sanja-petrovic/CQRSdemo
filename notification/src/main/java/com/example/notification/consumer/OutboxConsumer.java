package com.example.notification.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.support.converter.JsonMessageConverter;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class OutboxConsumer {
    private final ObjectMapper objectMapper;

    @Autowired
    public OutboxConsumer(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @KafkaListener(topics = "outbox.event.event", groupId = "users")
    public void consumeMessage(String message,
                               @Header("correlation_id") String correlationID) throws JsonProcessingException {
        log.info("message consumed {}", message);
        log.info("correlationID {}", correlationID);
    }

}