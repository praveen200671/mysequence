package com.meditation.my_sequence.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class StepMasterResponse {
	
	private String status;
	private String message;
	private Integer id;
    private String stepName;
    private String url;
    private String stepDesc;
    private String category;
   // ISO string or formatted date
    private String modifiedOn;

}
