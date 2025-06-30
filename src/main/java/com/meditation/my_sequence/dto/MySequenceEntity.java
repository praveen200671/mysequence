package com.meditation.my_sequence.dto;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.meditation.my_sequence.model.MyStepsRequest;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "stepOrders")
@Entity
@Table(name = "my_sequences")
public class MySequenceEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "sequence_name")
	private String sequenceName;
	@Column(name = "repeat_count")
	private Integer repeatCount;
	private String status;

	@Column(name = "fk_user_id")
	private Integer userId;
	
	@OneToMany(mappedBy = "sequence", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonManagedReference
	private List<MyStepOrderEntity> stepOrders;

	@Column(name = "created_on", nullable = false, updatable = false)
	@CreationTimestamp
	private LocalDateTime createdOn;
	
	@Column(name = "modified_on")
	@CreationTimestamp
	private LocalDateTime modifiedOn;
	
	
	

}
