package com.meditation.my_sequence.exception;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NoUserFoundException extends Exception {

	private String errorCode;
	private String errorMsg;
	private String datetime;

//	public NoUserFoundException(String msg) {
//		super(msg);
//
//	}
}
