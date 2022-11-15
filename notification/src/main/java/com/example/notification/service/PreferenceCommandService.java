package com.example.notification.service;

import com.example.notification.model.Notification;
import com.example.notification.model.NotificationType;

import java.util.UUID;

public interface PreferenceCommandService {
    public void setDefault(UUID userId);
    public void setPreference(UUID userId, NotificationType type);
}
