package com.example.user.service;

import com.example.user.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserCommandServiceImpl implements UserCommandService {

    private final PreferenceRepository preferenceRepository;

    public UserCommandServiceImpl(PreferenceRepository preferenceRepository) {
        this.preferenceRepository = preferenceRepository;
    }

    @Override
    public void createPreference(NotificationPreference preference) {
        preferenceRepository.save(preference);
    }

    @Override
    public void updatePreference(NotificationType type, User user) {

    }
}
