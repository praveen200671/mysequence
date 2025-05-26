package com.meditation.my_sequence.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.meditation.my_sequence.model.RegisterDeviceRequest;
import com.meditation.my_sequence.model.RegisterDeviceResponse;
import com.meditation.my_sequence.service.DeviceRegistrationService;




@RestController
@RequestMapping("/api/auth")
public class RegisterDeviceController {

    @Autowired
    private DeviceRegistrationService registerDeviceService;

    @PostMapping("/registerdevice")
    public ResponseEntity<RegisterDeviceResponse> registerdevice(@RequestBody RegisterDeviceRequest registerdeviceRequest) {
    	
        return new ResponseEntity<>(registerDeviceService.registerDevice(registerdeviceRequest), HttpStatus.CREATED);
    }
}
