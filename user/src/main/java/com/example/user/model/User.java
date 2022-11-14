package com.example.user.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    private UUID id;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private String email;

    @OneToMany(mappedBy = "user", orphanRemoval = true)
    private Set<NotificationPreference> notificationPreferences = new LinkedHashSet<>();

}
