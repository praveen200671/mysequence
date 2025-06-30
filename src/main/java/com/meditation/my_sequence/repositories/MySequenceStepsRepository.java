package com.meditation.my_sequence.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.meditation.my_sequence.dto.MySequenceEntity;

public interface MySequenceStepsRepository extends JpaRepository<MySequenceEntity, Integer> {

	 @Query(value = "SELECT s.sequence_name AS sequenceName," +
             "so.step_order AS stepOrder, so.duration AS duration, so.status AS stepStatus " +
             "FROM my_sequence s " +
             "JOIN my_sequence_step_order so ON s.id = so.fk_sequence_id " +
             "WHERE s.id = :sequenceId", nativeQuery = true)
	 Optional<List<MySequenceEntity>> findSequenceSteps();//@Param("sequenceId") Integer sequenceId);
	 
	
	 Optional<MySequenceEntity> findBySequenceName(String name);
	 

}