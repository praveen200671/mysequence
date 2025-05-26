package com.meditation.my_sequence.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meditation.my_sequence.model.UserSequenceHistoryRequest;
import com.meditation.my_sequence.model.UserSequenceHistoryResponse;
import com.meditation.my_sequence.repositories.UserSequenceHistoryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserSequenceHistoryService {
	 @Autowired
	 private UserSequenceHistoryRepository repository;

	    public UserSequenceHistoryResponse save(UserSequenceHistoryRequest log) {
	    	
	         repository.save(log);
	         return new UserSequenceHistoryResponse("success", "uploaded successfully.");
	    }

}
