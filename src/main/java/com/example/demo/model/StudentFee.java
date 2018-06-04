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
@Table(name="STUDENT_FEE")
public class StudentFee {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="STUDENT_FEE_ID")
	private Long studentFeeId;
	
	@OneToOne
	@JoinColumn(name="FEE_ID")
	private ClassFee classFee;
	
	@OneToOne
	@JoinColumn(name="STUDENT_ID")
	private Student student;
	
	@Column(name="ACTIVE_FLG")
	private boolean isActive;
	
	public Long getStudentFeeId() {
		return studentFeeId;
	}

	public void setStudentFeeId(Long studentFeeId) {
		this.studentFeeId = studentFeeId;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public StudentFee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ClassFee getClassFee() {
		return classFee;
	}

	public void setClassFee(ClassFee classFee) {
		this.classFee = classFee;
	}

	
	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public StudentFee(Long studentFeeId, ClassFee classFee, Student student, boolean isActive) {
		super();
		this.studentFeeId = studentFeeId;
		this.classFee = classFee;
		this.student = student;
		this.isActive = isActive;
	}



	
}
