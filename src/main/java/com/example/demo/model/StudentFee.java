package com.example.demo.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="STUDENT_FEE")
public class StudentFee implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
	
	@OneToOne
	@JoinColumn(name="STUDENT_CLASS_ID")
	private StudentClass studentClass;
	
	@Column(name="ACTIVE_FLG")
	private boolean isActive = true;
	
	@Column(name="START_DT")
	private Date startDate; 
	
	@Column(name="END_DT")
	private Date endDate; 
	
	@Column(name="STUDENT_FEE_AMT")
	private Integer studentFeeAmt;
	
	@Column(name="STUDENT_PAID_FEE_AMT")
	private Integer studentPaidFeeAmt;

	@Column(name="STUDENT_BALANCE_FEE_AMT")
	private Integer studentBalanceFeeAmt;
	
	
	//@JsonProperty(access = Access.READ_ONLY)
	@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="STUDENTFEE_STUDENTFEEPARAMS",
    joinColumns={@JoinColumn(name="STUDENT_FEE_ID", referencedColumnName="STUDENT_FEE_ID")},
    inverseJoinColumns={@JoinColumn(name="STUDENT_FEE_PARAMS_ID", referencedColumnName="STUDENT_FEE_PARAMS_ID")})
	private List<StudentFeeParams> studentFeeParams;
	
	@OneToMany
    @JsonIgnoreProperties("studentFee")
	private List<StudentPaymentHistory> studentPaymentHistories;
	
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

	public Integer getStudentFeeAmt() {
		return studentFeeAmt;
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

	public StudentClass getStudentClass() {
		return studentClass;
	}

	public void setStudentClass(StudentClass studentClass) {
		this.studentClass = studentClass;
	}

	public void setStudentFeeParams(List<StudentFeeParams> studentFeeParams) {
		this.studentFeeParams = studentFeeParams;
	}


	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public void setStudentFeeAmt(Integer studentFeeAmt) {
		this.studentFeeAmt = studentFeeAmt;
	}


	public Integer getStudentPaidFeeAmt() {
		return studentPaidFeeAmt;
	}

	public void setStudentPaidFeeAmt(Integer studentPaidFeeAmt) {
		this.studentPaidFeeAmt = studentPaidFeeAmt;
	}

	public Integer getStudentBalanceFeeAmt() {
		return studentBalanceFeeAmt;
	}

	public void setStudentBalanceFeeAmt(Integer studentBalanceFeeAmt) {
		this.studentBalanceFeeAmt = studentBalanceFeeAmt;
	}

	
	public List<StudentPaymentHistory> getStudentPaymentHistories() {
		return studentPaymentHistories;
	}

	public void setStudentPaymentHistories(List<StudentPaymentHistory> studentPaymentHistories) {
		this.studentPaymentHistories = studentPaymentHistories;
	}

	public StudentFee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public StudentFee(Long studentFeeId, ClassFee classFee, Student student, boolean isActive) {
		super();
		this.studentFeeId = studentFeeId;
		this.classFee = classFee;
		this.student = student;
		this.isActive = isActive;
	}

	public StudentFee(Long studentFeeId, ClassFee classFee, Student student, boolean isActive, Integer studentFeeAmt) {
		super();
		this.studentFeeId = studentFeeId;
		this.classFee = classFee;
		this.student = student;
		this.isActive = isActive;
		this.studentFeeAmt = studentFeeAmt;
	}

	public StudentFee(Long studentFeeId, ClassFee classFee, Student student, StudentClass studentClass,
			boolean isActive, Integer studentFeeAmt, List<StudentFeeParams> studentFeeParams) {
		super();
		this.studentFeeId = studentFeeId;
		this.classFee = classFee;
		this.student = student;
		this.studentClass = studentClass;
		this.isActive = isActive;
		this.studentFeeAmt = studentFeeAmt;
		this.studentFeeParams = studentFeeParams;
	}

	@Override
	public String toString() {
		return "StudentFee [studentFeeId=" + studentFeeId 
				+ ", isActive=" + isActive + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", studentFeeAmt=" + studentFeeAmt + ", studentPaidFeeAmt="
				+ studentPaidFeeAmt + ", studentBalanceFeeAmt=" + studentBalanceFeeAmt + ", studentFeeParams="
				+ studentFeeParams + "]";
	}


	public StudentFee(Long studentFeeId, ClassFee classFee, Student student, StudentClass studentClass,
			boolean isActive, Integer studentFeeAmt, Integer studentPaidFeeAmt, Integer studentBalanceFeeAmt,
			List<StudentFeeParams> studentFeeParams) {
		super();
		this.studentFeeId = studentFeeId;
		this.classFee = classFee;
		this.student = student;
		this.studentClass = studentClass;
		this.isActive = isActive;
		this.studentFeeAmt = studentFeeAmt;
		this.studentPaidFeeAmt = studentPaidFeeAmt;
		this.studentBalanceFeeAmt = studentBalanceFeeAmt;
		this.studentFeeParams = studentFeeParams;
	}

	public StudentFee(Long studentFeeId, ClassFee classFee, Student student, StudentClass studentClass,
			boolean isActive, Date startDate, Date endDate, Integer studentFeeAmt, Integer studentPaidFeeAmt,
			Integer studentBalanceFeeAmt, List<StudentFeeParams> studentFeeParams) {
		super();
		this.studentFeeId = studentFeeId;
		this.classFee = classFee;
		this.student = student;
		this.studentClass = studentClass;
		this.isActive = isActive;
		this.startDate = startDate;
		this.endDate = endDate;
		this.studentFeeAmt = studentFeeAmt;
		this.studentPaidFeeAmt = studentPaidFeeAmt;
		this.studentBalanceFeeAmt = studentBalanceFeeAmt;
		this.studentFeeParams = studentFeeParams;
	}

	public StudentFee(Long studentFeeId, ClassFee classFee, Student student, StudentClass studentClass,
			boolean isActive, Date startDate, Date endDate, Integer studentFeeAmt, Integer studentPaidFeeAmt,
			Integer studentBalanceFeeAmt, List<StudentFeeParams> studentFeeParams,
			List<StudentPaymentHistory> studentPaymentHistories) {
		super();
		this.studentFeeId = studentFeeId;
		this.classFee = classFee;
		this.student = student;
		this.studentClass = studentClass;
		this.isActive = isActive;
		this.startDate = startDate;
		this.endDate = endDate;
		this.studentFeeAmt = studentFeeAmt;
		this.studentPaidFeeAmt = studentPaidFeeAmt;
		this.studentBalanceFeeAmt = studentBalanceFeeAmt;
		this.studentFeeParams = studentFeeParams;
		this.studentPaymentHistories = studentPaymentHistories;
	}

}
