package com.example.user.controller;

import com.example.user.dto.UserDto;
import com.example.user.model.User;
import com.example.user.service.OutboxItemService;
import com.example.user.service.UserCommandService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/commands")
@ConditionalOnProperty(name = "app.write.enabled", havingValue = "true")
public class UserCommandController {
    private final UserCommandService userCommandService;
    private final OutboxItemService outboxItemService;

    public UserCommandController(UserCommandService userCommandService, OutboxItemService outboxItemService) {
        this.userCommandService = userCommandService;
        this.outboxItemService = outboxItemService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserDto dto) throws JsonProcessingException {
        User user = User.builder()
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .email(dto.getEmail())
                .build();
        userCommandService.register(user);
        outboxItemService.save(dto);
        return ResponseEntity.ok().build();
    }
}
