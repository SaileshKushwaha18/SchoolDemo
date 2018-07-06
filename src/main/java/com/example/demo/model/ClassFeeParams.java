package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
	private Long classFeeParamsId;
	
//	@Column(name="PARAMS_NAME_TXT")
//	//private String name;

	@OneToOne
	//@Column(name="PARAMS_NAME_TXT")
	private ClassFeeType classFeeType;
	
	@Column(name="FEE_AMT")
	private String feeAmount;
    

	public Long getClassFeeParamsId() {
		return classFeeParamsId;
	}

	public void setClassFeeParamsId(Long classFeeParamsId) {
		this.classFeeParamsId = classFeeParamsId;
	}

//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}


//	public ClassFeeParams(Long classFeeParamsId, String name, String value) {
//		super();
//		this.classFeeParamsId = classFeeParamsId;
//		this.name = name;
//		this.value = value;
//	}

	public ClassFeeParams() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ClassFeeType getClassFeeType() {
		return classFeeType;
	}

	public void setClassFeeType(ClassFeeType classFeeType) {
		this.classFeeType = classFeeType;
	}

	public String getFeeAmount() {
		return feeAmount;
	}

	public void setFeeAmount(String feeAmount) {
		this.feeAmount = feeAmount;
	}

	public ClassFeeParams(Long classFeeParamsId, ClassFeeType classFeeType, String feeAmount) {
		super();
		this.classFeeParamsId = classFeeParamsId;
		this.classFeeType = classFeeType;
		this.feeAmount = feeAmount;
	}

}
