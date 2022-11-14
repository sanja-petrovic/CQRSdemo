package com.example.user.service;

import com.example.user.dto.OutboxUserDto;
import com.example.user.model.User;
import com.example.user.repository.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserCommandServiceImpl implements UserCommandService {

    private final UserRepository userRepository;
    private final OutboxItemService outboxItemService;

    public UserCommandServiceImpl(UserRepository userRepository, OutboxItemService outboxItemService) {
        this.userRepository = userRepository;
        this.outboxItemService = outboxItemService;
    }

    @Override
    @Transactional
    public void register(User user) throws JsonProcessingException {
        userRepository.save(user);
        outboxItemService.save(new OutboxUserDto(user.getId().toString()));
    }
}
