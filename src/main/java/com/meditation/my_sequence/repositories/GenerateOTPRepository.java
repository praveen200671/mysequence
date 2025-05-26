package com.meditation.my_sequence.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.meditation.my_sequence.dto.GenerateOTPEntity;
import com.meditation.my_sequence.dto.VerifyOTPEntity;

@Repository
public interface GenerateOTPRepository extends JpaRepository<GenerateOTPEntity, Integer> {
	Optional<GenerateOTPEntity> findByOtpAndOtpKey( String otp,String otokey);
}
