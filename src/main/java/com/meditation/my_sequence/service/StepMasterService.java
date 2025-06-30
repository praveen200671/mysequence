package com.meditation.my_sequence.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.meditation.my_sequence.controller.UserController;
import com.meditation.my_sequence.dto.StepsMasterEntity;
import com.meditation.my_sequence.dto.TemplateEntity;
import com.meditation.my_sequence.model.LoginResponse;
import com.meditation.my_sequence.model.StepMasterResponse;
import com.meditation.my_sequence.model.UserResponse;
import com.meditation.my_sequence.repositories.StepMasterRepository;

@Service
public class StepMasterService {

    private final UserController userController;
	@Autowired
	StepMasterRepository stepMasterRepository;

    StepMasterService(UserController userController) {
        this.userController = userController;
    }
	
    public 	List<StepMasterResponse> getSteps() {
        // You would typically validate OTP here (e.g., from database)
    	List<StepsMasterEntity> stepsMasterEntityList=stepMasterRepository.findAll();
    	List<StepMasterResponse> stepMasterResponseList=new ArrayList<>();
    	if(!stepsMasterEntityList.isEmpty())
    	{
    		for(StepsMasterEntity stepsMasterEntity:stepsMasterEntityList)
    		{
    			StepMasterResponse stepMasterResponse=new StepMasterResponse();
    			stepMasterResponse.setId(stepsMasterEntity.getId());
    			stepMasterResponse.setStepName(stepsMasterEntity.getStepName());
    			
    			stepMasterResponse.setFileName(stepsMasterEntity.getFileName());
    			stepMasterResponse.setStepDesc(stepsMasterEntity.getStepDesc());
    			stepMasterResponse.setModifiedOn(stepsMasterEntity.getModifiedOn());
    			stepMasterResponse.setCategory(stepsMasterEntity.getCategory());
    			stepMasterResponse.setFileUrl(stepsMasterEntity.getFileUrl());
    			stepMasterResponseList.add(stepMasterResponse);
    			
    		}
    	}
            return stepMasterResponseList;
    }
    

}
