package com.meditation.my_sequence.model;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class MySequenceStepsRequest {

	private int id;
	private String sequenceName;
	private int repeatCount;
	private int userId;
	private String status;
	private List<MyStepsRequest> stepOrders;

	

}
