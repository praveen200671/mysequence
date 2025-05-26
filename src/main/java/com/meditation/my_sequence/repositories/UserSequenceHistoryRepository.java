package com.meditation.my_sequence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.meditation.my_sequence.dto.UserSequenceHistoryEntity;
import com.meditation.my_sequence.model.UserSequenceHistoryRequest;

@Repository
public interface UserSequenceHistoryRepository extends JpaRepository<UserSequenceHistoryEntity, Integer> {
	//UserSequenceHistoryEntity findByUserIdAndDeviceId(String userId, String deviceId);

	void save(UserSequenceHistoryRequest log);
}
