package com.example.user.controller;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/queries")
@ConditionalOnProperty(name = "app.write.enabled", havingValue = "false")
public class UserQueryController {
}
