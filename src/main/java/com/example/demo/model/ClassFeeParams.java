package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

/**
 * @author Sailesh
 *
 */
@Entity
@Table(name="CLASS_FEE_PARAMS")
public class ClassFeeParams {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CLASS_FEE_PARAMS_ID")
	private Integer id;
	
	@Column(name="PARAMS_NAME_TXT")
	private String name;
	
	@Column(name="PARAMS_VALUE_TXT")
	private String value;

	@JsonProperty(access = Access.WRITE_ONLY)
	@ManyToOne( fetch = FetchType.EAGER )
	@JoinColumn(name = "FEE_ID", nullable = false )
	private ClassFee classFee;
    
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public ClassFeeParams(Integer id, String name, String value) {
		super();
		this.id = id;
		this.name = name;
		this.value = value;
	}

	public ClassFeeParams() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ClassFee getClassFee() {
		return classFee;
	}

	public void setClassFee(ClassFee classFee) {
		this.classFee = classFee;
	}

	public ClassFeeParams(Integer id, String name, String value, ClassFee classFee) {
		super();
		this.id = id;
		this.name = name;
		this.value = value;
		this.classFee = classFee;
	}


}
