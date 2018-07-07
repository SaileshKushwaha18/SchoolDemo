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
@Table(name="STUDENT_FEE_WAIVER")
public class StudentFeeWaiver {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="STUDENT_FEE_WAIVER_ID")
	private Long studentFeeWaiverId;
	
	@OneToOne
	@JoinColumn(name="FEE_TYPE_ID")
	private ClassFeeType classFeeType;
	
	@OneToOne
	@JoinColumn(name="STUDENT_ID")
	private Student student;
	
	@Column(name="FEE_WAIVER_PERC")
	private String feeWaiverPer;

	public Long getStudentFeeWaiverId() {
		return studentFeeWaiverId;
	}

	public void setStudentFeeWaiverId(Long studentFeeWaiverId) {
		this.studentFeeWaiverId = studentFeeWaiverId;
	}

	public ClassFeeType getClassFeeType() {
		return classFeeType;
	}

	public void setClassFeeType(ClassFeeType classFeeType) {
		this.classFeeType = classFeeType;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public String getFeeWaiverPer() {
		return feeWaiverPer;
	}

	public void setFeeWaiverPer(String feeWaiverPer) {
		this.feeWaiverPer = feeWaiverPer;
	}

	public StudentFeeWaiver(Long studentFeeWaiverId, ClassFeeType classFeeType, Student student, String feeWaiverPer) {
		super();
		this.studentFeeWaiverId = studentFeeWaiverId;
		this.classFeeType = classFeeType;
		this.student = student;
		this.feeWaiverPer = feeWaiverPer;
	}

	public StudentFeeWaiver() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "StudentFeeWaiver [studentFeeWaiverId=" + studentFeeWaiverId + ", classFeeType=" + classFeeType
				+ ", student=" + student + ", feeWaiverPer=" + feeWaiverPer + "]";
	}
	
}
