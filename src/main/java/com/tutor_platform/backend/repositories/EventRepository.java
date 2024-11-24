package com.tutor_platform.backend.repositories;

import com.tutor_platform.backend.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
