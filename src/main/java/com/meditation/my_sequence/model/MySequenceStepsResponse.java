package com.meditation.my_sequence.model;

import java.util.List;

import com.meditation.my_sequence.dto.MyStepOrderEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MySequenceStepsResponse {
	private int id;
	private String sequenceName;
	private Integer repeatCount;
//	private String status;
//	private Integer userId;
	private List<MyStepOrderEntity> stepOrders;

}