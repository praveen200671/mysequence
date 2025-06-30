package com.meditation.my_sequence.dto;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "steps_master")
public class StepsMasterEntity {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer id;

	    @Column(length = 100)
	    private String category;
	    
	    @Column(name = "modified_on")
	    private LocalDateTime modifiedOn;
	    
	    @Column(name = "step_name", length = 100)
	    private String stepName;

	    @Column(name = "step_desc", length = 100)
	    private String stepDesc;
	    
	   
	    @Column(name = "file_name", length = 200)
	    private String fileName;

	    @Column(name = "url", length = 200)
	    private String fileUrl;
	  

	  

	  
}
