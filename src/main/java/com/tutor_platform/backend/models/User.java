package com.tutor_platform.backend.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.validator.constraints.URL;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "users")
public class User extends AbstractAuditingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;

    private String password;

    @Column(unique = true)
    private String email;

    private String contacts;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "second_name", nullable = false)
    private String secondName;

    @URL
    private String avatar;

    @Column(name = "is_activated")
    @ColumnDefault(value = "false")
    private boolean isActivated;

    @ElementCollection(fetch = FetchType.EAGER)
    private Set<String> roles = new HashSet<>();
}
