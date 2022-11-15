package com.example.notification.consumer;

import com.example.notification.dto.OutboxDto;
import com.example.notification.model.NotificationType;
import com.example.notification.service.PreferenceCommandService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
public class OutboxConsumer {
    private final ObjectMapper objectMapper;
    private final PreferenceCommandService preferenceCommandService;

    @Autowired
    public OutboxConsumer(ObjectMapper objectMapper, PreferenceCommandService preferenceCommandService) {
        this.objectMapper = objectMapper;
        this.preferenceCommandService = preferenceCommandService;
    }



    @KafkaListener(topics = "outbox.event.preference", groupId = "users")
    public void consumeMessage(String message,
                               @Header("correlation_id") String correlationID) throws JsonProcessingException {
        log.info("message consumed {}", message);
        OutboxDto dto = objectMapper.readValue(message, OutboxDto.class);
        preferenceCommandService.setPreference(UUID.fromString(dto.getId()), NotificationType.valueOf(dto.getType()));
    }

}