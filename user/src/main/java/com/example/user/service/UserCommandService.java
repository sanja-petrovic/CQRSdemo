package com.example.user.service;

import com.example.user.model.User;

public interface UserCommandService {
    public void createPreference(NotificationPreference preference);
    public void updatePreference(NotificationType type, User user);
}
