package com.example.demo.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="STUDENT_FEE_WAIVER_HISTORY")
public class StudentFeeWaiverHistory implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="STUDENT_FEE_WAIVER_HISTORY_ID")
	private Long studentFeeWaiverHistoryId;
	
	@OneToOne
	@JoinColumn(name="STUDENT_FEE_ID")
	private StudentFee studentFee;
	
	@Column(name="STUDENT_FEE_WAIVER_DT")
	private Date waiverDate; 
	
	@Column(name="STUDENT_FEE_WAIVER_AMT")
	private Integer studentFeeWaiverAmt;
	
	@Column(name="STUDENT_FEE_WAIVER_CMT")
	private String studentFeeWaiverCmt;

	public Long getStudentFeeWaiverHistoryId() {
		return studentFeeWaiverHistoryId;
	}

	public void setStudentFeeWaiverHistoryId(Long studentFeeWaiverHistoryId) {
		this.studentFeeWaiverHistoryId = studentFeeWaiverHistoryId;
	}

	public StudentFee getStudentFee() {
		return studentFee;
	}

	public void setStudentFee(StudentFee studentFee) {
		this.studentFee = studentFee;
	}

	public Date getWaiverDate() {
		return waiverDate;
	}

	public void setWaiverDate(Date waiverDate) {
		this.waiverDate = waiverDate;
	}

	public Integer getStudentFeeWaiverAmt() {
		return studentFeeWaiverAmt;
	}

	public void setStudentFeeWaiverAmt(Integer studentFeeWaiverAmt) {
		this.studentFeeWaiverAmt = studentFeeWaiverAmt;
	}

	public String getStudentFeeWaiverCmt() {
		return studentFeeWaiverCmt;
	}

	public void setStudentFeeWaiverCmt(String studentFeeWaiverCmt) {
		this.studentFeeWaiverCmt = studentFeeWaiverCmt;
	}

	public StudentFeeWaiverHistory(Long studentFeeWaiverHistoryId, StudentFee studentFee, Date waiverDate,
			Integer studentFeeWaiverAmt, String studentFeeWaiverCmt) {
		super();
		this.studentFeeWaiverHistoryId = studentFeeWaiverHistoryId;
		this.studentFee = studentFee;
		this.waiverDate = waiverDate;
		this.studentFeeWaiverAmt = studentFeeWaiverAmt;
		this.studentFeeWaiverCmt = studentFeeWaiverCmt;
	}

	public StudentFeeWaiverHistory() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
