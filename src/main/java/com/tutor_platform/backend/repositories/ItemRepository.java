package com.tutor_platform.backend.repositories;

import com.tutor_platform.backend.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
