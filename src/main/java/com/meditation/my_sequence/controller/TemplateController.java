package com.meditation.my_sequence.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meditation.my_sequence.dto.StepsMasterEntity;
import com.meditation.my_sequence.model.RegisterDeviceRequest;
import com.meditation.my_sequence.model.RegisterDeviceResponse;
import com.meditation.my_sequence.model.StepMasterRequest;
import com.meditation.my_sequence.model.StepMasterResponse;
import com.meditation.my_sequence.service.DeviceRegistrationService;
import com.meditation.my_sequence.service.StepMasterService;

@RestController
@RequestMapping("/api/auth")
public class TemplateController {
    @Autowired
    private StepMasterService stepMasterService;

    @PostMapping("/getstepsmaster")
    public List<StepsMasterEntity> getStepsList(@RequestBody StepMasterRequest stepMasterRequest) {
    	
        return stepMasterService.getSteps(stepMasterRequest.getId());
    }
}
