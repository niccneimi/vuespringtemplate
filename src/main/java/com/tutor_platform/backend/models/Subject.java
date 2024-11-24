package com.tutor_platform.backend.models;

import jakarta.persistence.*;

@Entity
public class Subject extends AbstractAuditingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;
}
