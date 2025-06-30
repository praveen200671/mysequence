package com.meditation.my_sequence.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meditation.my_sequence.model.LoginRequest;
import com.meditation.my_sequence.model.LoginResponse;
import com.meditation.my_sequence.model.VerifyOTPRequest;
import com.meditation.my_sequence.model.VerifyOTPResponse;
import com.meditation.my_sequence.service.LoginService;
import com.meditation.my_sequence.service.VerifyOTPService;

@RestController
@RequestMapping("/api")
public class LoginController {

	private static final Logger logger = LogManager.getLogger(LoginController.class);

	@Autowired
	private LoginService loginService;

	@Autowired
	private VerifyOTPService verifyOTPService;

	@PostMapping("/sendOTP")
	public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {

		// Validate Request -- Email Mandatory

		// System.out.println("Inside controller"+ loginRequest.toString());
		return new ResponseEntity<>(loginService.SendOTP(loginRequest.getEmail()), HttpStatus.OK);
	}

	@PostMapping("/verifyOTP")
	public ResponseEntity<VerifyOTPResponse> login(@RequestBody VerifyOTPRequest verifyOTPRequest) {

		// Validate Request -- Email, Otp, Otpkey Mandatory

		logger.info("Inside controller" + verifyOTPRequest.toString());
		return new ResponseEntity<>(verifyOTPService.VerifyOTP(verifyOTPRequest), HttpStatus.OK);
	}
}
