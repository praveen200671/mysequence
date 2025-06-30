package com.meditation.my_sequence.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meditation.my_sequence.dto.MySequenceEntity;
import com.meditation.my_sequence.model.MySequenceStepsRequest;
import com.meditation.my_sequence.model.MySequenceStepsResponse;
import com.meditation.my_sequence.service.LoginService;
import com.meditation.my_sequence.service.MySequenceStepService;

@RestController
@RequestMapping("/api")
public class MySequenceOrdersController {

	@Autowired
	private MySequenceStepService mySequenceStepService;

	@Autowired
	private LoginService loginService;

	@GetMapping("/getmysequencesteps")
	public ResponseEntity<List<MySequenceStepsResponse>> getMySequenceandSteps(
			@RequestHeader(name = "Authorization", required = true) String authtoken) {

		// Validate token Expiry;

		if (loginService.validateToken(authtoken)) {
			return new ResponseEntity<>(mySequenceStepService.getSequenceandSteps(), HttpStatus.OK);
			// return new ResponseEntity<>(stepMasterService.(), HttpStatus.OK);
		} else {
//    		VerifyOTPResponse otpResponse=new VerifyOTPResponse("failed", "Token expired.", "",0);
			return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
		}
	}
	
	@PostMapping("/savemysequencesteps")
	public ResponseEntity<MySequenceEntity> createSequence(
			@RequestHeader(name = "Authorization", required = true) String authtoken,
			@RequestBody MySequenceStepsRequest sequence) {

//		mySequenceStepsRequest.setCreatedOn(LocalDateTime.now());
//		mySequenceStepsRequest.setModifiedOn(LocalDateTime.now());

		if (!loginService.validateToken(authtoken)) {
			return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
		}
		// Set back-reference from each step to the parent sequence
		MySequenceEntity mySequenceEntity=mySequenceStepService.saveMySequenceSteps(sequence);
		if ( mySequenceEntity!= null) {
			
			return new ResponseEntity<>(mySequenceEntity, HttpStatus.CREATED);
			
		}else {
			return  new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		
	}

}
