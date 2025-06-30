package com.meditation.my_sequence.service;

import java.time.LocalDate;
import java.util.Optional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.meditation.my_sequence.components.MailComponent;
import com.meditation.my_sequence.dto.AuthTokenEntity;
import com.meditation.my_sequence.dto.GenerateOTPEntity;
import com.meditation.my_sequence.dto.TemplateEntity;
import com.meditation.my_sequence.dto.UserEntity;
import com.meditation.my_sequence.model.LoginResponse;
import com.meditation.my_sequence.repositories.AuthTokenRepository;
import com.meditation.my_sequence.repositories.GenerateOTPRepository;
import com.meditation.my_sequence.repositories.TemplateRepository;
import com.meditation.my_sequence.repositories.UserRepository;

import com.meditation.my_sequence.util.AuthCodeGenerator;
import com.meditation.my_sequence.util.SendEmail;

@Service
public class LoginService {

	private final DeviceRegistrationService deviceRegistrationService;
	
	

//    private final AuthTokenRepository authTokenRepository;

	private static final Logger logger = LogManager.getLogger(VerifyOTPService.class);
	@Autowired
	UserRepository userRepository;
	@Autowired
	GenerateOTPRepository generateOTPRepository;
	@Autowired
	AuthTokenRepository authTokenRepository;
	
	@Autowired
	TemplateRepository templateRepository;
	@Autowired
	MailComponent mailComponent;
	@Autowired
	private SendEmail sendEmail;

	LoginService(DeviceRegistrationService deviceRegistrationService) {
		this.deviceRegistrationService = deviceRegistrationService;
	}

//    LoginService(AuthTokenRepository authTokenRepository) {
//        this.authTokenRepository = authTokenRepository;
//    }

	public LoginResponse SendOTP(String userEmail) {
		// check email in user table. if present then trigger otp, else save record in
		// user table and trigger OTP
		Optional<UserEntity> useOptional = userRepository.findByEmail(userEmail);
		GenerateOTPEntity generateOTPEntity = new GenerateOTPEntity();
		logger.info("sending email template id reading from Property-->"+mailComponent.getOtpTemplateId()+"...............class" +getClass().getName());
		Optional<TemplateEntity> templateOptional = templateRepository.findByTemplateId(mailComponent.getOtpTemplateId());
		if (useOptional.isEmpty()) {
			// insert records and get record id.
			UserEntity user = new UserEntity();
			user.setEmail(userEmail);
			user = userRepository.save(user);

		}

		
		generateOTPEntity.setOtp(new AuthCodeGenerator().getSixDigitOTP());
		generateOTPEntity.setOtpKey(new AuthCodeGenerator().getOTPKey());
		generateOTPEntity = generateOTPRepository.save(generateOTPEntity);

		// TODO send email with OTP.....
		if(templateOptional.isPresent())
		{
			TemplateEntity templateEntity=templateOptional.get();
			
			String body=templateEntity.getTemplate().replace("#SixDigitOTP#", generateOTPEntity.getOtp());
			
		logger.info("sending email on user id for otp...............class" +getClass().getName());
		sendEmailOTP(userEmail, body,mailComponent.getSubject());
		}
		else
		{
			logger.info("Email OTP Template id 1001 does not exist..............class" +getClass().getName());
		}

		if (generateOTPEntity.getId() > -1) {
			logger.info("Email OTP Template id 1001 does not exist..............class" +getClass().getName());

			return new LoginResponse("success", "OTP Sent", userEmail, generateOTPEntity.getOtpKey());

		} else {
			logger.info(getClass().getName() + "Inside Else otp failed");
			return new LoginResponse("fail", "Invalid OTP", userEmail, null);
		}
	}

	@Async("asyncTaskExecutor")
	private void sendEmailOTP( String userEmailid, String body,String subject)  {

		logger.info("sending email by Executor thread..." +getClass().getName());
		 
		sendEmail.sendEmailOTP(userEmailid, body,subject);

	}

	public boolean validateToken(String token) {
		Optional<AuthTokenEntity> authOptional = authTokenRepository.findByToken(token);

		if (authOptional.isPresent()) {
			AuthTokenEntity authTokenEntity = authOptional.get();
			LocalDate myObj = LocalDate.now();
			logger.info("days difference .......... "+(AuthCodeGenerator.daysDifferentDayCount(myObj,
					authTokenEntity.getUpdatedDate().now().toLocalDate())));
			if (0 >= (AuthCodeGenerator.daysDifferentDayCount(myObj,
					authTokenEntity.getUpdatedDate().now().toLocalDate()))) {

				return true;
			}

		}
		return false;
	}
}
