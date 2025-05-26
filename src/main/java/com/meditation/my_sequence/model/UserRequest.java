package com.meditation.my_sequence.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class UserRequest {
	
	
	    private Integer id;

	    private String mobile;

	    private String email;

	    private String name;

	    private String photoUrl;

	    private String city;

	    private Integer age;

	    private String gender;

	    private Double lat;

	    private Double longitude;

	    private String country;
	   
	    private String authToken;

		
	    
	    


}
