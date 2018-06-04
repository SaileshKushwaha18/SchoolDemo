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
	private Long studentFeeId;
	
	@Column(name="PARAM_TYPE_TXT")
	private String paramType;
	
	@Column(name="PARAMS_NAME_TXT")
	private String name;
	
	@Column(name="PARAMS_VALUE_TXT")
	private String value;

	@OneToOne
	@JoinColumn(name="STUDENT_FEE_ID")
	private StudentFee studenFee;

	public Long getStudentFeeId() {
		return studentFeeId;
	}

	public void setStudentFeeId(Long studentFeeId) {
		this.studentFeeId = studentFeeId;
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

	public StudentFee getStudenFee() {
		return studenFee;
	}

	public void setStudenFee(StudentFee studenFee) {
		this.studenFee = studenFee;
	}

	public StudentFeeParams(Long studentFeeId, String paramType, String name, String value, StudentFee studenFee) {
		super();
		this.studentFeeId = studentFeeId;
		this.paramType = paramType;
		this.name = name;
		this.value = value;
		this.studenFee = studenFee;
	}

	public StudentFeeParams() {
		super();
		// TODO Auto-generated constructor stub
	} 
	
	
	
}
