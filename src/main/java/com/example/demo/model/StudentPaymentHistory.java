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
@Table(name="STUDENT_FEE_PAYMENT_HISTORY")
public class StudentPaymentHistory implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="STUDENT_FEE_PAYMENT_ID")
	private Long studentFeePaymentId;
	
	@OneToOne
	@JoinColumn(name="STUDENT_ID")
	private Student student;
	
	@OneToOne
	@JoinColumn(name="STUDENT_FEE_ID")
	private StudentFee studentFee;
	
	@Column(name="PAYMENT_DT")
	private Date startDate; 
	
	@Column(name="PAYMENT_STATUS_TXT")
	private String payamentStatus;
	
	@Column(name="STUDENT_FEE_PAYMENT_AMT")
	private Integer studentFeePaymentAmt;
	
	@Column(name="STUDENT_FEE_PAYMENT_CMT")
	private String studentFeePaymentCmt;

	public Long getStudentFeePaymentId() {
		return studentFeePaymentId;
	}

	public void setStudentFeePaymentId(Long studentFeePaymentId) {
		this.studentFeePaymentId = studentFeePaymentId;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public StudentFee getStudentFee() {
		return studentFee;
	}

	public void setStudentFee(StudentFee studentFee) {
		this.studentFee = studentFee;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public String getPayamentStatus() {
		return payamentStatus;
	}

	public void setPayamentStatus(String payamentStatus) {
		this.payamentStatus = payamentStatus;
	}

	public Integer getStudentFeePaymentAmt() {
		return studentFeePaymentAmt;
	}

	public void setStudentFeePaymentAmt(Integer studentFeePaymentAmt) {
		this.studentFeePaymentAmt = studentFeePaymentAmt;
	}

	@Override
	public String toString() {
		return "StudentPaymentHistory [studentFeePaymentId=" + studentFeePaymentId + ", student=" + student
				+ ", studentFee=" + studentFee + ", startDate=" + startDate + ", payamentStatus=" + payamentStatus
				+ ", studentFeePaymentAmt=" + studentFeePaymentAmt + "]";
	}

	public StudentPaymentHistory(Long studentFeePaymentId, Student student, StudentFee studentFee, Date startDate,
			String payamentStatus, Integer studentFeePaymentAmt) {
		super();
		this.studentFeePaymentId = studentFeePaymentId;
		this.student = student;
		this.studentFee = studentFee;
		this.startDate = startDate;
		this.payamentStatus = payamentStatus;
		this.studentFeePaymentAmt = studentFeePaymentAmt;
	}

	public StudentPaymentHistory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getStudentFeePaymentCmt() {
		return studentFeePaymentCmt;
	}

	public void setStudentFeePaymentCmt(String studentFeePaymentCmt) {
		this.studentFeePaymentCmt = studentFeePaymentCmt;
	}

	public StudentPaymentHistory(Long studentFeePaymentId, Student student, StudentFee studentFee, Date startDate,
			String payamentStatus, Integer studentFeePaymentAmt, String studentFeePaymentCmt) {
		super();
		this.studentFeePaymentId = studentFeePaymentId;
		this.student = student;
		this.studentFee = studentFee;
		this.startDate = startDate;
		this.payamentStatus = payamentStatus;
		this.studentFeePaymentAmt = studentFeePaymentAmt;
		this.studentFeePaymentCmt = studentFeePaymentCmt;
	}
	
	
}
