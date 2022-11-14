package com.example.notification.model;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "notification_preferences")
public class Preference {
    @Id
    private UUID id;
    @Column
    @Enumerated(EnumType.STRING)
    private NotificationType type;
    @Column
    private UUID userId;

}
