package com.tutor_platform.backend.repositories;

import com.tutor_platform.backend.models.File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<File, Long> {
}
