package com.meditation.my_sequence.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class MyStepsRequest {

	private int stepId;
	private int duration;
	private int stepOrder;
}
