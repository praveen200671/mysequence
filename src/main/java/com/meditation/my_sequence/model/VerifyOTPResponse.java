package com.meditation.my_sequence.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class VerifyOTPResponse {

	private String status;
	private String message;
	private String token;
	private int token_expiry;

}
