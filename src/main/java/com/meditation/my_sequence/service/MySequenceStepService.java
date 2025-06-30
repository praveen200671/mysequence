package com.meditation.my_sequence.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import com.meditation.my_sequence.util.SendEmail;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.meditation.my_sequence.controller.UserController;
import com.meditation.my_sequence.dto.MySequenceEntity;
import com.meditation.my_sequence.dto.MyStepOrderEntity;
import com.meditation.my_sequence.dto.StepsMasterEntity;
import com.meditation.my_sequence.dto.TemplateEntity;
import com.meditation.my_sequence.model.LoginResponse;
import com.meditation.my_sequence.model.MySequenceStepsRequest;
import com.meditation.my_sequence.model.MySequenceStepsResponse;
import com.meditation.my_sequence.model.MyStepsRequest;
import com.meditation.my_sequence.model.StepMasterResponse;
import com.meditation.my_sequence.model.UserResponse;
import com.meditation.my_sequence.repositories.MySequenceStepsRepository;
import com.meditation.my_sequence.repositories.StepMasterRepository;

@Service
public class MySequenceStepService {
	private static final Logger logger = LogManager.getLogger(MySequenceStepService.class);

	private final UserController userController;

	private final SendEmail sendEmail;
	@Autowired
	MySequenceStepsRepository mySequenceStepsRepository;

	MySequenceStepService(SendEmail sendEmail, UserController userController) {
		this.sendEmail = sendEmail;
		this.userController = userController;
	}

	public List<MySequenceStepsResponse> getSequenceandSteps() {
		// You would typically validate OTP here (e.g., from database)
		List<MySequenceEntity> mySequenceStepsList = mySequenceStepsRepository.findAll();
		List<MySequenceStepsResponse> mySequenceStepsResponseList = new ArrayList<>();
		if (!mySequenceStepsList.isEmpty()) {
			for (MySequenceEntity mySequenceEntity : mySequenceStepsList) {
				MySequenceStepsResponse mySequenceStepsResponse = new MySequenceStepsResponse();
				mySequenceStepsResponse.setId(mySequenceEntity.getId());
				mySequenceStepsResponse.setSequenceName(mySequenceEntity.getSequenceName());
				mySequenceStepsResponse.setRepeatCount(mySequenceEntity.getRepeatCount());
				mySequenceStepsResponse.setStepOrders(mySequenceEntity.getStepOrders());
				mySequenceStepsResponseList.add(mySequenceStepsResponse);

			}
		}
		return mySequenceStepsResponseList;
	}

	public MySequenceEntity saveMySequenceSteps(MySequenceStepsRequest mySequenceStepsRequest) {
		try {
			Optional<MySequenceEntity> mySequenceStepsOptional = mySequenceStepsRepository
					.findBySequenceName(mySequenceStepsRequest.getSequenceName());

			logger.info("exsiting records ..." + mySequenceStepsOptional.toString());
			MySequenceEntity mySequenceEntity = new MySequenceEntity();
			List<MyStepOrderEntity> stepOrders = new ArrayList<>();

			BeanUtils.copyProperties(mySequenceStepsRequest, mySequenceEntity);
//			stepOrders = convertItems(mySequenceStepsRequest.getStepOrders(), mySequenceEntity);
			
			
//			List<MyStepOrderEntity> steps = new ArrayList<>();
			for (MyStepsRequest myStepsRequest:  mySequenceStepsRequest.getStepOrders()) {
			    MyStepOrderEntity step = new MyStepOrderEntity();
			    // set fields...
			    BeanUtils.copyProperties(myStepsRequest, step);
			    step.setSequence(mySequenceEntity); // MUST set this
			    stepOrders.add(step);
			}

			logger.info("printing my sequence request object ..." + mySequenceStepsRequest.getStepOrders().toString()
					+ "\n. stepOrders entity.." + stepOrders.toString() + ".....\n\n" + mySequenceEntity.toString());
			
			mySequenceEntity.setStepOrders(stepOrders);

			if (mySequenceStepsOptional.isPresent()) {
				MySequenceEntity entity = mySequenceStepsOptional.get();
				if (entity.getId() > 0) {
					mySequenceEntity.setId(entity.getId());
				}

			}

			logger.info("saving my sequence object ..." + mySequenceEntity.toString());
			MySequenceEntity savedSequence = mySequenceStepsRepository.save(mySequenceEntity);
			logger.info("saved result my sequence object ..." + savedSequence.toString());
			return savedSequence;
		} catch (Exception e) {
			logger.info("Exception in MysequenceSteps saving ..." + e.getMessage());
			return null;
		}

	}

	public List<MyStepOrderEntity> convertItems(List<MyStepsRequest> steps, MySequenceEntity mySequenceEntity) {
		List<MyStepOrderEntity> myStepOrderEntities = new ArrayList<>();

		for (MyStepsRequest dto : steps) {
			MyStepOrderEntity entity = new MyStepOrderEntity();

			try {

				BeanUtils.copyProperties(dto, entity);
				entity.setSequence(mySequenceEntity);
				myStepOrderEntities.add(entity);
			} catch (Exception e) {
				// Handle exception
				e.printStackTrace();
			}
		}

		return myStepOrderEntities;
	}

}
