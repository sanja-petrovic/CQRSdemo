package com.example.user.controller;

import com.example.user.service.UserCommandService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/commands")
@ConditionalOnProperty(name = "app.write.enabled", havingValue = "true")
public class UserCommandController {
    private final UserCommandService service;

    public UserCommandController(UserCommandService service) {
        this.service = service;
    }
}
