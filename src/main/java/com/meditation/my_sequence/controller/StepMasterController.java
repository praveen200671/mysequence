package com.meditation.my_sequence.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meditation.my_sequence.dto.StepsMasterEntity;
import com.meditation.my_sequence.model.LoginRequest;
import com.meditation.my_sequence.model.LoginResponse;
import com.meditation.my_sequence.model.StepMasterRequest;
import com.meditation.my_sequence.model.StepMasterResponse;
import com.meditation.my_sequence.model.UserSequenceHistoryRequest;
import com.meditation.my_sequence.model.UserSequenceHistoryResponse;
import com.meditation.my_sequence.model.VerifyOTPRequest;
import com.meditation.my_sequence.model.VerifyOTPResponse;
import com.meditation.my_sequence.service.LoginService;
import com.meditation.my_sequence.service.StepMasterService;
import com.meditation.my_sequence.service.UserSequenceHistoryService;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/api")
public class StepMasterController {

    @Autowired
    private UserSequenceHistoryService userSequenceHistoryService;
    
    @Autowired
    private StepMasterService stepMasterService;
    @Autowired
    private LoginService loginService;

    @GetMapping("/getstepmaster")
    public ResponseEntity<List<StepMasterResponse>> getStepMaster(
    		@RequestHeader (name="Authorization", required=true) String authtoken
    		) {
    	
    	//Validate token Expiry;
    	
		if (loginService.validateToken(authtoken))
		{
			return new ResponseEntity<>(stepMasterService.getSteps(), HttpStatus.OK);
           //return new ResponseEntity<>(stepMasterService.(), HttpStatus.OK);
		}
    	else 
    	{
    		//VerifyOTPResponse otpResponse=new VerifyOTPResponse("failed", "Token expired.", "",0);
    		return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
    	}
    }
    
}

