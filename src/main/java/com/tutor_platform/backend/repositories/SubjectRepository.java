package com.tutor_platform.backend.repositories;

import com.tutor_platform.backend.models.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
}
