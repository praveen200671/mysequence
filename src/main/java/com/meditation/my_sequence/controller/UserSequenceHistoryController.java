package com.meditation.my_sequence.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meditation.my_sequence.model.LoginRequest;
import com.meditation.my_sequence.model.LoginResponse;
import com.meditation.my_sequence.model.UserSequenceHistoryRequest;
import com.meditation.my_sequence.model.UserSequenceHistoryResponse;
import com.meditation.my_sequence.model.VerifyOTPRequest;
import com.meditation.my_sequence.service.LoginService;
import com.meditation.my_sequence.service.UserSequenceHistoryService;


@RestController
@RequestMapping("/api/auth")
public class UserSequenceHistoryController {

    @Autowired
    private UserSequenceHistoryService userSequenceHistoryService;

    @PostMapping("/saveusersequencehistory")
    public UserSequenceHistoryResponse saveUserSequenceHistory(@RequestBody UserSequenceHistoryRequest userSequence) {
            return userSequenceHistoryService.save(userSequence);
    }
    
    
}
