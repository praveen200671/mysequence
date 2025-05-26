package com.meditation.my_sequence.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meditation.my_sequence.dto.StepsMasterEntity;
import com.meditation.my_sequence.dto.TemplateEntity;
import com.meditation.my_sequence.model.LoginResponse;
import com.meditation.my_sequence.model.StepMasterResponse;
import com.meditation.my_sequence.repositories.StepMasterRepository;

@Service
public class StepMasterService {
	@Autowired
	StepMasterRepository stepMasterRepository;
    public 	List<StepsMasterEntity>  getSteps(int id) {
        // You would typically validate OTP here (e.g., from database)
    	List<StepsMasterEntity> stepsMasterEntity=stepMasterRepository.findByIdGreaterThan(id);
            return stepsMasterEntity;
    }
}
