package com.meditation.my_sequence.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "template")
public class TemplateEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String type;

    @Column(columnDefinition = "TEXT")
    private String template;

    @Column(name = "template_desc", length = 100)
    private String templateDesc;

    @Column(name = "created_on")
    private String createdOn;

    @Column(name = "modified_on")
    private String modifiedOn;
    
    @Column(name = "template_id")
    private int templateId;

    

}
