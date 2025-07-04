package com.meditation.my_sequence.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.meditation.my_sequence.dto.DeviceEntity;


@Repository
public interface DeviceRepository extends JpaRepository<DeviceEntity, Integer> {
    Optional<DeviceEntity> findByUserIdAndDeviceId(String userId, String deviceId);
}
