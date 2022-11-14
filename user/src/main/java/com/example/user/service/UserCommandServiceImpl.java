package com.example.user.service;

import com.example.user.model.OutboxItem;
import com.example.user.model.User;
import com.example.user.repository.OutboxItemRepository;
import com.example.user.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

@Service
public class UserCommandServiceImpl implements UserCommandService {

    private final UserRepository userRepository;
    private final OutboxItemRepository outboxItemRepository;

    public UserCommandServiceImpl(UserRepository userRepository, OutboxItemRepository outboxItemRepository) {
        this.userRepository = userRepository;
        this.outboxItemRepository = outboxItemRepository;
    }

    @Override
    public void register(User user) {
        userRepository.save(user);
    }
}
