package com.example.notification.service;

import com.example.notification.model.Notification;

import java.util.UUID;

public interface PreferenceCommandService {
    public void setDefault(UUID userId);
}
