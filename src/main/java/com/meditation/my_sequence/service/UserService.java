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

    public UserResponse updateUser(UserRequest user) {
        // Check if device already exists for this user
    	try {
        Optional<UserEntity> userinfoOptional= userRepository.findById(
            user.getId()
        );
        
        
       UserResponse userResponse=new UserResponse();
       
        if (userinfoOptional.isPresent() ==true) {
            // Update existing device
        	UserEntity userInfo= userinfoOptional.get();
        	userInfo.setName(user.getName());
        	userInfo.setEmail(user.getEmail());
        	userInfo.setMobile(user.getMobile());
        	userInfo.setPhotoUrl(user.getPhotoUrl());
        	userInfo.setAge(user.getAge());
        	userInfo.setCountry(user.getCountry());
        	userInfo.setGender(user.getGender());
        	userInfo.setCity(user.getCity());
        	userInfo.setLat(user.getLat());
        	userInfo.setLongitude(user.getLongitude());
        	userRepository.save(userInfo);
        	
        	userResponse.setId(user.getId());
        	userResponse.setName(user.getName());
        	userResponse.setEmail(user.getEmail());
        	userResponse.setMobile(user.getMobile());
        	userResponse.setPhotoUrl(user.getPhotoUrl());
        	userResponse.setAge(user.getAge());
        	userResponse.setCountry(user.getCountry());
        	userResponse.setGender(user.getGender());
        	userResponse.setCity(user.getCity());
        	userResponse.setLat(user.getLat());
        	userResponse.setLongitude(user.getLongitude());
        	
        	
        	
        	return userResponse;
        	
        	
        }
        else
        {
        	UserEntity userInfo=new UserEntity();
        	userInfo.setName(user.getName());
        	userInfo.setEmail(user.getEmail());
        	userInfo.setMobile(user.getMobile());
        	userInfo.setPhotoUrl(user.getPhotoUrl());
        	userInfo.setAge(user.getAge());
        	userInfo.setCountry(user.getCountry());
        	userInfo.setGender(user.getGender());
        	userInfo.setCity(user.getCity());
        	userInfo.setLat(user.getLat());
        	userInfo.setLongitude(user.getLongitude());
        	userRepository.save(userInfo);
        	 Optional<UserEntity> optionalUserEntity =userRepository.findByEmail(user.getEmail());
                    
               if(optionalUserEntity.isPresent())
               {
            	userInfo =optionalUserEntity.get();
            	userResponse.setId(userInfo.getId());
               	userResponse.setName(userInfo.getName());
               	userResponse.setEmail(userInfo.getEmail());
               	userResponse.setMobile(userInfo.getMobile());
               	userResponse.setPhotoUrl(userInfo.getPhotoUrl());
               	userResponse.setAge(userInfo.getAge());
               	userResponse.setCountry(userInfo.getCountry());
               	userResponse.setGender(userInfo.getGender());
               	userResponse.setCity(userInfo.getCity());
               	userResponse.setLat(userInfo.getLat());
               	userResponse.setLongitude(userInfo.getLongitude());
            	   
               }
        	
        	 return userResponse;
        	
        }
       
    	}
    	catch (Exception e) {
    		 return new UserResponse();//new UserResponse("failed","Request failed.");
		}

    }
}
