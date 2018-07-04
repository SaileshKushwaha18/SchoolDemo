package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="STUDENT_FEE_PARAMS")
public class StudentFeeParams {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="STUDENT_FEE_PARAMS_ID")
	private Long studentFeeParamsId;
	
	@Column(name="PARAM_TYPE_TXT")
	private String paramType;
	
	@Column(name="PARAMS_NAME_TXT")
	private String name;
	
	@Column(name="PARAMS_VALUE_TXT")
	private String value;

	
	public Long getStudentFeeParamsId() {
		return studentFeeParamsId;
	}

	public void setStudentFeeParamsId(Long studentFeeParamsId) {
		this.studentFeeParamsId = studentFeeParamsId;
	}

	public String getParamType() {
		return paramType;
	}

	public void setParamType(String paramType) {
		this.paramType = paramType;
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

	public StudentFeeParams(Long studentFeeParamsId, String paramType, String name, String value) {
		super();
		this.studentFeeParamsId = studentFeeParamsId;
		this.paramType = paramType;
		this.name = name;
		this.value = value;
	}

	public StudentFeeParams() {
		super();
		// TODO Auto-generated constructor stub
	} 
	
	
	
}
