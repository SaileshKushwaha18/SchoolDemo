package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Sailesh
 *
 */
@Entity
@Table(name="CLASS_FEE_TYPE")
public class ClassFeeType {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="FEE_TYPE_ID")
	private Long id;
	
	@Column(name="FEE_TYPE_NAME_TXT")
	private String name;
	
	@Column(name="FEE_TYPE_DESC_TXT")
	private String description;
	
	@Column(name="FEE_TYPE_FREQ_TXT")
	private Integer frequency;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getFrequency() {
		return frequency;
	}

	public void setFrequency(Integer frequency) {
		this.frequency = frequency;
	}

	public ClassFeeType(Long id, String name, String description, Integer frequency) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.frequency = frequency;
	}

	public ClassFeeType() {
		super();
	}


}
