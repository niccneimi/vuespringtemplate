package com.tutor_platform.backend.repositories;

import com.tutor_platform.backend.models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
