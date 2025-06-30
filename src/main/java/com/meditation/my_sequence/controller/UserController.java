package com.meditation.my_sequence.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meditation.my_sequence.dto.UserEntity;
import com.meditation.my_sequence.model.RegisterDeviceRequest;
import com.meditation.my_sequence.model.RegisterDeviceResponse;
import com.meditation.my_sequence.model.UserRequest;
import com.meditation.my_sequence.model.UserResponse;
import com.meditation.my_sequence.service.DeviceRegistrationService;
import com.meditation.my_sequence.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/userupdate")
	public UserResponse updateUser(@RequestBody UserRequest userrequest) {

		return userService.updateUser(userrequest);
	}
}
