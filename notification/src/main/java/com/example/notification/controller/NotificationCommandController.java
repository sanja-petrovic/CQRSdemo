package com.example.notification.controller;

import com.example.notification.service.NotificationCommandService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/commands")
@ConditionalOnProperty(name = "app.write.enabled", havingValue = "true")
public class NotificationCommandController {
    private final NotificationCommandService service;

    public NotificationCommandController(NotificationCommandService service) {
        this.service = service;
    }
}
