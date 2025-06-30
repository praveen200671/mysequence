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

import com.meditation.my_sequence.model.TemplateRequest;
import com.meditation.my_sequence.model.TemplateResponse;

import com.meditation.my_sequence.service.TemplateService;

@RestController
@RequestMapping("/api")
public class TemplateController {

	private static final Logger logger = LogManager.getLogger(TemplateController.class);
	@Autowired
	private TemplateService templateService;

	@PostMapping("/getpolicyortnc")
	public ResponseEntity<TemplateResponse> getPolicyorTnc(@RequestBody TemplateRequest templateRequest) {
		logger.info("inside controller.........." + getClass().getName());
		return new ResponseEntity<>(templateService.getTemplate(templateRequest.getId()), HttpStatus.OK);

	}
}
