package com.meditation.my_sequence.service;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meditation.my_sequence.dto.GenerateOTPEntity;
import com.meditation.my_sequence.dto.UserEntity;
import com.meditation.my_sequence.dto.VerifyOTPEntity;
import com.meditation.my_sequence.model.LoginResponse;
import com.meditation.my_sequence.repositories.GenerateOTPRepository;
import com.meditation.my_sequence.repositories.UserRepository;
import com.meditation.my_sequence.repositories.VerifyOTPRepository;
import com.meditation.my_sequence.util.AuthCodeGenerator;

@Service
public class LoginService {

	private static final Logger logger = LogManager.getLogger(VerifyOTPService.class);
	@Autowired
	UserRepository userRepository;
	@Autowired
	GenerateOTPRepository generateOTPRepository;

	public LoginResponse SendOTP(String email) {
		// check email in user table. if present then trigger otp, else save record in
		// user table and trigger OTP
		Optional<UserEntity> useOptional = userRepository.findByEmail(email);

		if (useOptional.isEmpty()) {
			// insert records and get record id.
			UserEntity user= new UserEntity();
			user.setEmail(email);
			user =userRepository.save(user);
			
		}
	
		GenerateOTPEntity generateOTPEntity=new GenerateOTPEntity();
		generateOTPEntity.setOtp(new AuthCodeGenerator().getSixDigitOTP());
		generateOTPEntity.setOtpKey(new AuthCodeGenerator().getOTPKey());
		generateOTPEntity =generateOTPRepository.save(generateOTPEntity);
		// TODO
		 
		if (generateOTPEntity.getId() >- 1) {

			return new LoginResponse("success", "OTP Sent", email,generateOTPEntity.getOtpKey());

		} else {
			logger.info(new LoginService().getClass()+"Inside Else otp failed");
			return new LoginResponse("fail", "Invalid OTP", email,null);
		}
	}
}
