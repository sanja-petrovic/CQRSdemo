package com.example.notification.controller;

import com.example.notification.service.NotificationQueryService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/queries")
@ConditionalOnProperty(name = "app.write.enabled", havingValue = "false")
public class NotificationQueryController {
    private final NotificationQueryService service;

    public NotificationQueryController(NotificationQueryService service) {
        this.service = service;
    }
}
