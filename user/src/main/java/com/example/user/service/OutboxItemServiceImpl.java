package com.example.user.service;

import com.example.user.dto.UserDto;
import com.example.user.model.OutboxItem;
import com.example.user.repository.OutboxItemRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Slf4j
@Service
public class OutboxItemServiceImpl implements OutboxItemService {

    private final ObjectMapper objectMapper;
    private final OutboxItemRepository repository;

    public OutboxItemServiceImpl(ObjectMapper objectMapper, OutboxItemRepository repository) {
        this.objectMapper = objectMapper;
        this.repository = repository;
    }

    @Override
    public void save(UserDto userDto) throws JsonProcessingException {
        log.info(userDto.getEmail());
        OutboxItem outboxItem = OutboxItem.builder().payload(objectMapper.writeValueAsString(userDto)).type("User registered").timestamp(new Date()).aggregateType("event").aggregateId(UUID.randomUUID().toString()).correlationId(UUID.randomUUID().toString()).build();
        repository.save(outboxItem);
    }
}
