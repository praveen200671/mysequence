package com.meditation.my_sequence.service;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meditation.my_sequence.dto.DeviceEntity;
import com.meditation.my_sequence.dto.UserEntity;
import com.meditation.my_sequence.model.RegisterDeviceRequest;
import com.meditation.my_sequence.model.RegisterDeviceResponse;
import com.meditation.my_sequence.model.UserRequest;
import com.meditation.my_sequence.model.UserResponse;
import com.meditation.my_sequence.repositories.DeviceRepository;
import com.meditation.my_sequence.repositories.UserRepository;

import lombok.Data;



@Service
public class UserService {

    @Autowired
    private UserRepository userRepository; 

    public UserResponse registerDevice(UserRequest user) {
        // Check if device already exists for this user
    	try {
        Optional<UserEntity> userinfoOptional= userRepository.findById(
            user.getId()
        );
        
        
       
        if (userinfoOptional.isPresent() ==true) {
            // Update existing device
        	UserEntity userinfo= userinfoOptional.get();
        	userinfo.setName(user.getName());
        	userinfo.setEmail(user.getEmail());
        	userinfo.setMobile(user.getMobile());
        	userinfo.setPhotoUrl(user.getPhotoUrl());
        	userinfo.setAge(user.getAge());
        	userinfo.setCountry(user.getCountry());
        	userinfo.setGender(user.getGender());
        	userinfo.setCity(user.getCity());
        	userinfo.setLat(user.getLat());
        	userinfo.setLongitude(user.getLongitude());
        	userRepository.save(userinfo);
        }
        else
        {
        	UserEntity userentity=new UserEntity();
        	userentity.setName(user.getName());
        	userentity.setEmail(user.getEmail());
        	userentity.setMobile(user.getMobile());
        	userentity.setPhotoUrl(user.getPhotoUrl());
        	userentity.setAge(user.getAge());
        	userentity.setCountry(user.getCountry());
        	userentity.setGender(user.getGender());
        	userentity.setCity(user.getCity());
        	userentity.setLat(user.getLat());
        	userentity.setLongitude(user.getLongitude());
        	userRepository.save(userentity);
        	
        	
        }
        return null;//new UserResponse("success","User data saved successfully.");
    	}
    	catch (Exception e) {
    		 return null;//new UserResponse("failed","Request failed.");
		}

    }
}
