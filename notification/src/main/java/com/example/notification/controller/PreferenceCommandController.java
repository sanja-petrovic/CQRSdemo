package com.example.notification.controller;

import com.example.notification.service.PreferenceCommandService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/commands")
@ConditionalOnProperty(name = "app.write.enabled", havingValue = "true")
public class PreferenceCommandController {
    private final PreferenceCommandService service;

    public PreferenceCommandController(PreferenceCommandService service) {
        this.service = service;
    }
}
