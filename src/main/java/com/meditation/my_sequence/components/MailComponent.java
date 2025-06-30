package com.meditation.my_sequence.components;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.ToString;

@Data
@Component  
@ToString
@ConfigurationProperties(prefix = "spring.mail")
public class MailComponent {
	
	
	private int otpTemplateId;
	private String subject;
	private String host;
	private int port;
	private String username;
	private String password;
	
	@Value("${spring.mail.properties.mail.smtp.auth}")
	private String auth;
	@Value("${spring.mail.properties.mail.smtp.starttls.enable}")
	private String enable;
	
	@Value("${app.token_expiry}")
	private String tokenExpiry;
}
