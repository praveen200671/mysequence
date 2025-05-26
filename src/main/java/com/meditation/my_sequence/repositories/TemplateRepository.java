package com.meditation.my_sequence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meditation.my_sequence.dto.DeviceEntity;
import com.meditation.my_sequence.dto.TemplateEntity;

public interface TemplateRepository extends JpaRepository<TemplateEntity,Integer> {
    TemplateEntity findByType(String type);
}
