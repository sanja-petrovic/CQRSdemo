package com.example.user.controller;

import com.example.user.dto.OutboxDto;
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
public class UserCommandController {
    private final UserCommandService userCommandService;

    public UserCommandController(UserCommandService userCommandService) {
        this.userCommandService = userCommandService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserDto dto) throws JsonProcessingException {
        User user = User.builder()
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .email(dto.getEmail())
                .build();
        userCommandService.register(user);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/preferences/update")
    public ResponseEntity<?> update(@RequestBody OutboxDto dto) throws Exception {
        userCommandService.updatePreferences(dto.getId(), dto.getType());
        return ResponseEntity.ok().build();
    }
}
