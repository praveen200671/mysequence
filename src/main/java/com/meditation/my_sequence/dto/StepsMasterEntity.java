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

	    @Column(name = "step_name", length = 100)
	    private String stepName;

	    @Column(columnDefinition = "TEXT")
	    private String url;

	    @Column(name = "step_desc", length = 100)
	    private String stepDesc;

	    @Column(length = 100)
	    private String category;

	    @Column(name = "modified_on")
	    private LocalDateTime modifiedOn;
}
