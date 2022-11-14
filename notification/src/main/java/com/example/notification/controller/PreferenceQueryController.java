package com.example.notification.controller;

import com.example.notification.service.PreferenceQueryService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/queries")
@ConditionalOnProperty(name = "app.write.enabled", havingValue = "false")
public class PreferenceQueryController {
    private final PreferenceQueryService service;

    public PreferenceQueryController(PreferenceQueryService service) {
        this.service = service;
    }
}
