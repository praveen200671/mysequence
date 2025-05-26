package com.meditation.my_sequence.model;

import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
	 private String status;
	 private String message;

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
	    private int Expiry;
	 }
