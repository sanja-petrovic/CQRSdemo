package com.example.notification.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "notifications")
public class Notification {
    @Id
    private UUID id;
    @Column
    private String title;
    @Column
    private String body;
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;
}
