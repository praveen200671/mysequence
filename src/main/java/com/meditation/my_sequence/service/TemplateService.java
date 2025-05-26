package com.meditation.my_sequence.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.stereotype.Service;
import com.meditation.my_sequence.dto.TemplateEntity;
import com.meditation.my_sequence.model.TemplateResponse;
import com.meditation.my_sequence.repositories.TemplateRepository;

@Service
public class TemplateService {
	
	@Autowired
	TemplateRepository templateRepository;
	
	public TemplateResponse Template(String datetime, String type)
	{
	  TemplateEntity template=templateRepository.findByType(type);
		  if (template.getModifiedOn().equalsIgnoreCase(datetime)) {
	            return new TemplateResponse("success", "No change in policy", "200",1,null,null,null,null);          
	        } else {	
	        	return new TemplateResponse("success", "Policy updated", "200",template.getId(),template.getType(),template.getTemplate(),template.getTemplateDesc(),template.getCreatedOn());      
	        }
	}

}
