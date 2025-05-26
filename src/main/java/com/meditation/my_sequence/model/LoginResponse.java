package com.meditation.my_sequence.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponse {
	
	
	    private String status;
	    private String message;
	    private String email; 
	    private String otpKey;
	    // Optional: return a JWT or session token

	  		

}
