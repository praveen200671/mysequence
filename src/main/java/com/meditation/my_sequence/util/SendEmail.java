package com.meditation.my_sequence.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.meditation.my_sequence.components.MailComponent;

import jakarta.mail.internet.MimeMessage;

@Service
public class SendEmail {
	private static final Logger logger = LogManager.getLogger(SendEmail.class);
	@Autowired
	private JavaMailSender mailSender;
	@Autowired
	private MailComponent mailComponent;

	public void sendEmailOTP(String to, String body, String subject)  {
		try {
			// SimpleMailMessage message = new SimpleMailMessage();

			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

			logger.info(" email message object..." + message.toString());
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(body, true);
			message.setFrom(mailComponent.getUsername());
			logger.info("mailComponent...." + mailComponent.toString());
			logger.info(" email message object..." + message.toString());

			mailSender.send(message);
			logger.info("mail sent..." + getClass().getName());
		} catch (Exception e) {
			logger.error(e.getMessage() + "Exception Occurred in sending email........." + getClass().getName());
	
		}

	}

}
