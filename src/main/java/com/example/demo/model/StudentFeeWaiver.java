package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="STUDENT_FEE_WAIVER")
public class StudentFeeWaiver  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="STUDENT_FEE_WAIVER_ID")
	private Long studentFeeWaiverId;
	
	@OneToOne
	@JoinColumn(name="STUDENT_ID")
	private Student student;
	
	@Column(name="FEE_WAIVER_TYPE")
	private String feeWaiverType;

	@Column(name="FEE_WAIVER_AMT")
	private Integer feeWaiverAmt;
	

	@Column(name="FEE_WAIVER_CMT")
	private String feeWaiverCmt;
	
	@Column(name="ACTIVE_FLG")
	private boolean active;
	
	public Long getStudentFeeWaiverId() {
		return studentFeeWaiverId;
	}

	
	public void setStudentFeeWaiverId(Long studentFeeWaiverId) {
		this.studentFeeWaiverId = studentFeeWaiverId;
	}

	
	public String getFeeWaiverType() {
		return feeWaiverType;
	}

	public void setFeeWaiverType(String feeWaiverType) {
		this.feeWaiverType = feeWaiverType;
	}

	public Integer getFeeWaiverAmt() {
		return feeWaiverAmt;
	}

	public void setFeeWaiverAmt(Integer feeWaiverAmt) {
		this.feeWaiverAmt = feeWaiverAmt;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	
	public String getFeeWaiverCmt() {
		return feeWaiverCmt;
	}


	public void setFeeWaiverCmt(String feeWaiverCmt) {
		this.feeWaiverCmt = feeWaiverCmt;
	}


	public boolean isActive() {
		return active;
	}


	public void setActive(boolean active) {
		this.active = active;
	}


	public StudentFeeWaiver() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StudentFeeWaiver(Long studentFeeWaiverId, Student student, String feeWaiverType, Integer feeWaiverAmt) {
		super();
		this.studentFeeWaiverId = studentFeeWaiverId;
		this.student = student;
		this.feeWaiverType = feeWaiverType;
		this.feeWaiverAmt = feeWaiverAmt;
	}

	public StudentFeeWaiver(Long studentFeeWaiverId, Student student, String feeWaiverType, Integer feeWaiverAmt,
			String feeWaiverCmt, boolean active) {
		super();
		this.studentFeeWaiverId = studentFeeWaiverId;
		this.student = student;
		this.feeWaiverType = feeWaiverType;
		this.feeWaiverAmt = feeWaiverAmt;
		this.feeWaiverCmt = feeWaiverCmt;
		this.active = active;
	}

//
//	@Override
//	public String toString() {
//		return "StudentFeeWaiver [studentFeeWaiverId=" + studentFeeWaiverId + ", feeWaiverType=" + feeWaiverType
//				+ ", feeWaiverAmt=" + feeWaiverAmt + "]";
//	}

	
}
