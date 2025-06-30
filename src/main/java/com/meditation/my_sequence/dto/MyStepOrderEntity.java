package com.meditation.my_sequence.dto;

import java.sql.Timestamp;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "my_step_order")
public class MyStepOrderEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "step_id")
	private Integer stepId;

	private Integer stepOrder;
	private Integer duration;
//    @JoinColumn(name = "fk_sequence_id")
//	private Integer sequenceId;
	
	@ManyToOne
    @JoinColumn(name = "fk_sequence_id")
	@JsonBackReference
	private MySequenceEntity sequence;
	@UpdateTimestamp
	private Timestamp createdOn;
	@UpdateTimestamp
	private Timestamp modifiedOn;
	
	


}
