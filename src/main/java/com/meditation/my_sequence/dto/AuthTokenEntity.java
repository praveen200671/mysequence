package com.meditation.my_sequence.dto;

import java.time.LocalDateTime;

import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name="auth_token")
public class AuthTokenEntity {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private int id;
	 private String token;
	 
	 @Column(name="token_expiry")
	 private int tokenExpiry;
	 
	 @UpdateTimestamp
	 @Column(name="modified_on")
     private LocalDateTime updatedDate;
}
