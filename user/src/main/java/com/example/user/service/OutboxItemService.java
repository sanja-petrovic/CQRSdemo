package com.example.user.service;

import com.example.user.dto.UserDto;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface OutboxItemService {
    public void save(UserDto userDto) throws JsonProcessingException;
}
