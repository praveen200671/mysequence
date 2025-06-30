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


import com.meditation.my_sequence.model.RegisterDeviceRequest;
import com.meditation.my_sequence.model.RegisterDeviceResponse;
import com.meditation.my_sequence.service.DeviceRegistrationService;
import com.meditation.my_sequence.service.VerifyOTPService;




@RestController
@RequestMapping("/api")
public class RegisterDeviceController {
	private static final Logger logger = LogManager.getLogger(RegisterDeviceController.class);
    @Autowired
    private DeviceRegistrationService registerDeviceService;
	
    @PostMapping("/registerdevice")
    public ResponseEntity<RegisterDeviceResponse> registerdevice(@RequestBody RegisterDeviceRequest registerdeviceRequest) {
    logger.info("Device Registeratino:  "+registerdeviceRequest.toString());
        return new ResponseEntity<>(registerDeviceService.registerDevice(registerdeviceRequest), HttpStatus.OK);
    }
}
