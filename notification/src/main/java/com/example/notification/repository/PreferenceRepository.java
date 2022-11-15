package com.example.notification.repository;

import com.example.notification.model.Preference;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface PreferenceRepository extends JpaRepository<Preference, UUID> {
    Optional<Preference> findByUserId(UUID userId);
}
