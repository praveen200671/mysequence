package com.meditation.my_sequence.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.meditation.my_sequence.dto.AuthTokenEntity;
import com.meditation.my_sequence.dto.StepsMasterEntity;


@Repository
public interface AuthTokenRepository extends JpaRepository<AuthTokenEntity,Integer> {
//	List<StepsMasterEntity> savetoken(int id,String authcode);
}
