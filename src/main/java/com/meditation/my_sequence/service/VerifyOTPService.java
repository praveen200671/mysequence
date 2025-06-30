package com.meditation.my_sequence.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.weaver.patterns.ThisOrTargetAnnotationPointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.google.firebase.messaging.FirebaseMessagingException;
import com.meditation.my_sequence.dto.AuthTokenEntity;
import com.meditation.my_sequence.dto.UserEntity;
import com.meditation.my_sequence.dto.VerifyOTPEntity;
import com.meditation.my_sequence.model.AuthTokenRequest;
import com.meditation.my_sequence.model.LoginResponse;
import com.meditation.my_sequence.model.UserRequest;
import com.meditation.my_sequence.model.UserResponse;
import com.meditation.my_sequence.model.VerifyOTPRequest;
import com.meditation.my_sequence.model.VerifyOTPResponse;
import com.meditation.my_sequence.repositories.AuthTokenRepository;
import com.meditation.my_sequence.repositories.VerifyOTPRepository;
import com.meditation.my_sequence.util.AuthCodeGenerator;

@Service
public class VerifyOTPService {

	private static final Logger logger = LogManager.getLogger(VerifyOTPService.class);
	@Autowired
	private VerifyOTPRepository verifyOTPRepository;
	@Autowired
	PushNotificationService pushNotificationService;

	@Autowired
	private AuthTokenRequest authTokenRequest;

	@Autowired
	private AuthTokenRepository authTokenRepository;

//	@Value("${token_expiry}")
	private int TOKEN_EXPIRY = 1;

	public VerifyOTPResponse VerifyOTP(VerifyOTPRequest verifyOTPRequest) {

		logger.info("inside service class" + verifyOTPRequest.getOtp());

		Optional<VerifyOTPEntity> verifyOTPOptional = verifyOTPRepository.findByOtpAndOtpKey(verifyOTPRequest.getOtp(),
				verifyOTPRequest.getOtpKey());

		logger.info("inside service class" + verifyOTPOptional.isPresent());

		if (verifyOTPOptional.isPresent()) {
			
			logger.info("otp and kay found " + verifyOTPOptional.isPresent());
			AuthTokenEntity authTokenEntity = new AuthTokenEntity();
			VerifyOTPEntity verifyOTP = verifyOTPOptional.get();
			if (verifyOTP != null & verifyOTP.getOtp().equals(verifyOTPRequest.getOtp())
					&& verifyOTP.getOtpKey().equals(verifyOTPRequest.getOtpKey())) {

				if(verifyOTP.getVerifiedOn()!=null)
				{
					return new VerifyOTPResponse("failed", "OTP Expiried.", null, -1);
				}
				verifyOTPRepository.save(verifyOTP);
				
				logger.info("inside insert verify OTP date and time...." +verifyOTP.toString());
				LocalDateTime dateandtime = LocalDateTime.now();
				verifyOTP.setVerifiedOn( dateandtime);
				
				authTokenEntity.setToken(new AuthCodeGenerator().generateCode());
				authTokenEntity.setTokenExpiry(TOKEN_EXPIRY);
				logger.info(authTokenEntity.toString());
				authTokenEntity = authTokenRepository.save(authTokenEntity);
				
				//if()
				//sendPushNotification(null, null, null);
			}
			return new VerifyOTPResponse("success", "Logged in successfully.", authTokenEntity.getToken(),
					authTokenEntity.getTokenExpiry());

		} else {

			return new VerifyOTPResponse("failed", "Login failed", null, -1);
		}
	}
	
	@Async("asyncTaskExecutor")
	private void sendPushNotification( String token, String title,String body)  {

		logger.info("sending push notification..." +getClass().getName());
		 
		
		try {
			pushNotificationService.sendNotification(token, title,body);
		} catch (FirebaseMessagingException e) {
			e.printStackTrace();
		}

	}
	

}
