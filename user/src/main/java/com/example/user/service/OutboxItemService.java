package com.example.user.service;

import com.example.user.dto.OutboxDto;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface OutboxItemService {
    public void save(OutboxDto dto) throws JsonProcessingException;
}
