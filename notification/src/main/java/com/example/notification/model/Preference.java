package com.example.notification.model;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
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
