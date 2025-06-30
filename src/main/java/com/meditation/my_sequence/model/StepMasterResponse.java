package com.meditation.my_sequence.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class StepMasterResponse {
	
	
	private Integer id;
    private String stepName;
    private String url;
    private String stepDesc;
    private String category;
    private String fileName;
   // ISO string or formatted date
    private LocalDateTime modifiedOn;
    private String fileUrl;

}
