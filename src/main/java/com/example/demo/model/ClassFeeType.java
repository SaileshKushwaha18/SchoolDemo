package com.example.demo.model;

import java.io.Serializable;

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
public class ClassFeeType  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="FEE_TYPE_ID")
	private Long classFeeTypeId;
	
	@Column(name="FEE_TYPE_NAME_TXT")
	private String name;
	
	@Column(name="FEE_TYPE_DESC_TXT")
	private String description;
	
	@Column(name="FEE_TYPE_FREQ_TXT")
	private String frequency;


	public Long getClassFeeTypeId() {
		return classFeeTypeId;
	}

	public void setClassFeeTypeId(Long classFeeTypeId) {
		this.classFeeTypeId = classFeeTypeId;
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

	public String getFrequency() {
		return frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}



	public ClassFeeType(Long classFeeTypeId, String name, String description, String frequency) {
		super();
		this.classFeeTypeId = classFeeTypeId;
		this.name = name;
		this.description = description;
		this.frequency = frequency;
	}

	public ClassFeeType() {
		super();
	}

	@Override
	public String toString() {
		return "ClassFeeType [classFeeTypeId=" + classFeeTypeId + ", name=" + name + ", description=" + description
				+ ", frequency=" + frequency + "]";
	}


}
