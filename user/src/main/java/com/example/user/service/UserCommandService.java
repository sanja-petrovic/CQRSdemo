package com.example.user.service;

import com.example.user.model.User;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface UserCommandService {
    public void register(User user) throws JsonProcessingException;
}
