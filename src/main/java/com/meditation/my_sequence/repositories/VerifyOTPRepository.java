package com.meditation.my_sequence.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.meditation.my_sequence.dto.AuthTokenEntity;
import com.meditation.my_sequence.dto.VerifyOTPEntity;

@Repository
public interface VerifyOTPRepository extends JpaRepository<VerifyOTPEntity, Integer> {
	
	Optional<VerifyOTPEntity> findByOtpAndOtpKey( String otp,String otokey);
	

}
