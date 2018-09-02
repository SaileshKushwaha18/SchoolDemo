package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	@Column(name="STUDENT_FEE_WAIVER_CMT")
	private String waiverComment;
	
	@Column(name="STUDENT_FEE_WAIVER_TXT")
	private String waiverName;
	
	@Column(name="STUDENT_FEE_WAIVER_AMT")
	private String waiverAmt;

	public Long getStudentFeeWaiverId() {
		return studentFeeWaiverId;
	}

	public void setStudentFeeWaiverId(Long studentFeeWaiverId) {
		this.studentFeeWaiverId = studentFeeWaiverId;
	}

	public String getWaiverComment() {
		return waiverComment;
	}

	public void setWaiverComment(String waiverComment) {
		this.waiverComment = waiverComment;
	}

	public String getWaiverName() {
		return waiverName;
	}

	public void setWaiverName(String waiverName) {
		this.waiverName = waiverName;
	}

	public String getWaiverAmt() {
		return waiverAmt;
	}

	public void setWaiverAmt(String waiverAmt) {
		this.waiverAmt = waiverAmt;
	}

	public StudentFeeWaiver(Long studentFeeWaiverId, String waiverComment, String waiverName, String waiverAmt) {
		super();
		this.studentFeeWaiverId = studentFeeWaiverId;
		this.waiverComment = waiverComment;
		this.waiverName = waiverName;
		this.waiverAmt = waiverAmt;
	}

}
