package com.example.notification.service;

import com.example.notification.model.NotificationType;
import com.example.notification.model.Preference;
import com.example.notification.repository.PreferenceRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class PreferenceCommandServiceImpl implements PreferenceCommandService {

    private final PreferenceRepository repository;

    public PreferenceCommandServiceImpl(PreferenceRepository repository) {
        this.repository = repository;
    }

    @Override
    public void setDefault(UUID userId) {
        Preference preference = Preference.builder()
                .id(UUID.randomUUID())
                .type(NotificationType.ALL)
                .userId(userId)
                .build();
        repository.save(preference);
    }

    @Override
    public void setPreference(UUID userId, NotificationType type) {
        Optional<Preference> optionalPreference = repository.findByUserId(userId);
        if(optionalPreference.isPresent()) {
            Preference preference = optionalPreference.get();
            preference.setType(type);
            repository.save(preference);
        } else {
            this.setDefault(userId);
        }
    }
}
