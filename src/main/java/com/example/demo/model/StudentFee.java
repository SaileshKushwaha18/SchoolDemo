package com.example.demo.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name="STUDENT_FEE")
public class StudentFee {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="STUDENT_FEE_ID")
	private Long studentFeeId;
	
	@OneToOne
	@JoinColumn(name="CLASS_FEE_ID")
	private ClassFee classFee;
	
	@OneToOne
	@JoinColumn(name="STUDENT_ID")
	private Student student;
	
	@Column(name="ACTIVE_FLG")
	private boolean isActive;
	
	@Column(name="STUDENT_FEE_AMT")
	private String studentFeeAmt;
	
	@JsonProperty(access = Access.READ_ONLY)
	@OneToMany
    @JoinTable(name="STUDENTFEE_STUDENTFEEPARAMS",
    joinColumns={@JoinColumn(name="STUDENT_FEE_ID", referencedColumnName="STUDENT_FEE_ID")},
    inverseJoinColumns={@JoinColumn(name="STUDENT_FEE_PARAMS_ID", referencedColumnName="STUDENT_FEE_PARAMS_ID")})
	private List<StudentFeeParams> studentFeeParams;
	
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

	public String getStudentFeeAmt() {
		return studentFeeAmt;
	}

	public void setStudentFeeAmt(String studentFeeAmt) {
		this.studentFeeAmt = studentFeeAmt;
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

	public List<StudentFeeParams> getStudentFeeParams() {
		return studentFeeParams;
	}

	public void setStudentFeeParams(List<StudentFeeParams> studentFeeParams) {
		this.studentFeeParams = studentFeeParams;
	}

	public StudentFee(Long studentFeeId, ClassFee classFee, Student student, boolean isActive) {
		super();
		this.studentFeeId = studentFeeId;
		this.classFee = classFee;
		this.student = student;
		this.isActive = isActive;
	}

	public StudentFee(Long studentFeeId, ClassFee classFee, Student student, boolean isActive, String studentFeeAmt) {
		super();
		this.studentFeeId = studentFeeId;
		this.classFee = classFee;
		this.student = student;
		this.isActive = isActive;
		this.studentFeeAmt = studentFeeAmt;
	}

	@Override
	public String toString() {
		return "StudentFee [studentFeeId=" + studentFeeId + ", classFee=" + classFee + ", student=" + student
				+ ", isActive=" + isActive + ", studentFeeAmt=" + studentFeeAmt + ", studentFeeParams="
				+ studentFeeParams + "]";
	}

}
