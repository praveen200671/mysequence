package com.meditation.my_sequence.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Component
public class AuthTokenRequest {
	
	 private int id;
	 private String token;
	 private int tokenExpiry;
	
     private LocalDateTime updatedDate;
}
