package com.meditation.my_sequence.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meditation.my_sequence.model.LoginRequest;
import com.meditation.my_sequence.model.LoginResponse;
import com.meditation.my_sequence.model.StepMasterRequest;
import com.meditation.my_sequence.model.UserSequenceHistoryRequest;
import com.meditation.my_sequence.model.UserSequenceHistoryResponse;
import com.meditation.my_sequence.model.VerifyOTPRequest;
import com.meditation.my_sequence.service.LoginService;
import com.meditation.my_sequence.service.UserSequenceHistoryService;


@RestController
@RequestMapping("/api/auth")
public class StepMasterController {

    @Autowired
    private UserSequenceHistoryService userSequenceHistoryService;

    @PostMapping("/getstepmaster")
    public ResponseEntity<UserSequenceHistoryResponse> saveUserSequenceHistory(@RequestBody StepMasterRequest stepMasterRequest) {
            return new ResponseEntity<>(new UserSequenceHistoryResponse(), HttpStatus.OK);
    }
    
    
}
