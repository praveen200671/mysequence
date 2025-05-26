package com.meditation.my_sequence.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class VerifyOTPRequest {

	private String email;
	private String otp;
	private String otpKey;

}
