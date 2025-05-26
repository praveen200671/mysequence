package com.meditation.my_sequence.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.meditation.my_sequence.dto.StepsMasterEntity;


@Repository
public interface StepMasterRepository extends JpaRepository<StepsMasterEntity,Integer> {
	List<StepsMasterEntity> findByIdGreaterThan(int id);
}
