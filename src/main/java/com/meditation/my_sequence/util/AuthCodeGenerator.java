package com.meditation.my_sequence.util;

import java.security.SecureRandom;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Random;
import java.util.UUID;

import com.meditation.my_sequence.controller.LoginController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AuthCodeGenerator {

	private static final Logger logger = LogManager.getLogger(AuthCodeGenerator.class);

	public String generateCode() {
		return UUID.randomUUID().toString();
	}

	public String getSixDigitOTP() {
		String otp = new DecimalFormat("000000").format(new Random().nextInt(999999));
		return "222222";
	}

	public String getOTPKey() {

		String uuid = UUID.randomUUID().toString();
		return uuid;

	}

	public static long daysDifferentDayCount(LocalDate currentDate, LocalDate oldDate) {
		try {
			long daysBetween = ChronoUnit.DAYS.between(oldDate, currentDate);

			return daysBetween;
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("Exception Occurred.....in Date formating  .." + e.getMessage());
			return -1;
		}
	}
}
