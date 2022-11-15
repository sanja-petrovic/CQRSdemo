package com.example.user.service;

import com.example.user.dto.OutboxDto;
import com.example.user.model.User;
import com.example.user.repository.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

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
        outboxItemService.save(new OutboxDto(user.getId().toString(), "ALL"));
    }

    @Override
    @Transactional
    public void updatePreferences(String userId, String type) throws Exception {
        Optional<User> user = userRepository.findById(UUID.fromString(userId));
        if(user.isPresent()) {
            OutboxDto outboxDto = new OutboxDto(userId, type);
            outboxItemService.save(outboxDto);
        } else {
            throw new Exception("User not found!");
        }
    }
}
