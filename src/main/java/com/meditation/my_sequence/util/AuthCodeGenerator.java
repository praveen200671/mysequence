package com.meditation.my_sequence.util;

import java.security.SecureRandom;
import java.text.DecimalFormat;
import java.util.Random;
import java.util.UUID;

public class AuthCodeGenerator {
	public String generateCode() {
		return UUID.randomUUID().toString();
	}

	public String getSixDigitOTP() {
		String otp = new DecimalFormat("000000").format(new Random().nextInt(999999));
		return otp;
	}

	public String getOTPKey() {

		String uuid = UUID.randomUUID().toString();
		return uuid;

	}
}
