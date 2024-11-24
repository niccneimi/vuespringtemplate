package com.tutor_platform.backend.models;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.sql.Timestamp;

@MappedSuperclass
public class AbstractAuditingEntity {
    @LastModifiedDate
    @Column(name = "updated_at", updatable = false, nullable = false)
    private Timestamp updatedAt;

    @CreatedDate
    @Column(name = "created_at", nullable = false)
    private Timestamp createdAt;
}
