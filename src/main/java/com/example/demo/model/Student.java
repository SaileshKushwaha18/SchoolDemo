/**
 * 
 */
package com.example.demo.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Sailesh
 *
 */

@Entity
@Table(name="STUDENT")
public class Student implements Serializable{

	private static final long serialVersionUID = -1056099330980863129L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="STUDENT_ID")
	private Long studentId;
	
	@Column(name="ADMISSION_NO_NUM")
	private String admissionno; 
	
	@Column(name="FIRST_NAME_TXT", nullable=false)
	private String firstName; 
	
	@Column(name="LAST_NAME_TXT")
	private String lastName; 
	
	@Column(name="STUDENT_ADHAR_ID")
	private String studentAdharId; 
	
	@Column(name="DOB_DT")
	private Date studentdob; 
	
	@Column(name="GENDER_TXT")
	private String gender; 
	
	@Column(name="START_DT")
	private Date startDate; 
	
	@Column(name="END_DT")
	private Date endDate; 
	
	@Column(name="FATHER_NAME_TXT")
	private String fathername;
	
	@Column(name="FATHER_AGE_NUM")
	private Integer fatherage;

	@Column(name="FATHER_QUALIFICATION_TXT")
	private String fatherqualification;
	
	@Column(name="FATHER_DOB_DT")
	private Date fatherdob; 
	
	@Column(name="FATHER_PROFESSION_TXT")
	private String fatherprofession;
	
	@Column(name="MOTHER_NAME_TXT")
	private String mothername;
	
	@Column(name="MOTHER_AGE_NUM")
	private Integer motherage;

	@Column(name="MOTHER_QUALIFICATION_TXT")
	private String motherqualification;
	
	@Column(name="MOTHER_DOB_DT")
	private Date motherdob; 
	
	@Column(name="MOTHER_PROFESSION_TXT")
	private String motherprofession;
	
	@Column(name="ADDRESS_TXT")
	private String address;
	
	@Column(name="PHONE_NO_TXT")
	private String phoneno;
	
	@Column(name="CELL_NO_TXT")
	private String cellno;
	
	@Column(name="EMAIL_ADDRESS_TXT")
	private String emailaddress;

    @OneToOne
    @JsonIgnoreProperties("students")
    @JoinTable(name="STUDENT_STUDENTCLASS",
    joinColumns={@JoinColumn(name="STUDENT_ID", referencedColumnName="STUDENT_ID")},
    inverseJoinColumns={@JoinColumn(name="STUDENT_CLASS_ID", referencedColumnName="STUDENT_CLASS_ID")})
	private StudentClass studentClass;
	
	@Transient
	private List<StudentFeeWaiver> studentFeeWaivers;
	
	@Column(name="ACTIVE_FLG")
	private boolean active =true;
	
	@Column(name="NEW_FLG")
	private boolean isNew =true;
	
	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public String getAdmissionno() {
		return admissionno;
	}

	public void setAdmissionno(String admissionno) {
		this.admissionno = admissionno;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getStudentAdharId() {
		return studentAdharId;
	}

	public void setStudentAdharId(String studentAdharId) {
		this.studentAdharId = studentAdharId;
	}

	public Date getStudentdob() {
		return studentdob;
	}

	public void setStudentdob(Date studentdob) {
		this.studentdob = studentdob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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

	public String getFathername() {
		return fathername;
	}

	public void setFathername(String fathername) {
		this.fathername = fathername;
	}

	public Integer getFatherage() {
		return fatherage;
	}

	public void setFatherage(Integer fatherage) {
		this.fatherage = fatherage;
	}

	public String getFatherqualification() {
		return fatherqualification;
	}

	public void setFatherqualification(String fatherqualification) {
		this.fatherqualification = fatherqualification;
	}

	public Date getFatherdob() {
		return fatherdob;
	}

	public void setFatherdob(Date fatherdob) {
		this.fatherdob = fatherdob;
	}

	public String getFatherprofession() {
		return fatherprofession;
	}

	public void setFatherprofession(String fatherprofession) {
		this.fatherprofession = fatherprofession;
	}

	public String getMothername() {
		return mothername;
	}

	public void setMothername(String mothername) {
		this.mothername = mothername;
	}

	public Integer getMotherage() {
		return motherage;
	}

	public void setMotherage(Integer motherage) {
		this.motherage = motherage;
	}

	public String getMotherqualification() {
		return motherqualification;
	}

	public void setMotherqualification(String motherqualification) {
		this.motherqualification = motherqualification;
	}

	public Date getMotherdob() {
		return motherdob;
	}

	public void setMotherdob(Date motherdob) {
		this.motherdob = motherdob;
	}

	public String getMotherprofession() {
		return motherprofession;
	}

	public void setMotherprofession(String motherprofession) {
		this.motherprofession = motherprofession;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	public String getCellno() {
		return cellno;
	}

	public void setCellno(String cellno) {
		this.cellno = cellno;
	}

	public String getEmailaddress() {
		return emailaddress;
	}

	public void setEmailaddress(String emailaddress) {
		this.emailaddress = emailaddress;
	}

	public List<StudentFeeWaiver> getStudentFeeWaivers() {
		return studentFeeWaivers;
	}

	public void setStudentFeeWaivers(List<StudentFeeWaiver> studentFeeWaivers) {
		this.studentFeeWaivers = studentFeeWaivers;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public StudentClass getStudentClass() {
		return studentClass;
	}
	
	public void setStudentClass(StudentClass studentClass) {
		this.studentClass = studentClass;
	}


	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public boolean isNew() {
		return isNew;
	}

	public void setNew(boolean isNew) {
		this.isNew = isNew;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(Long studentId, String admissionno, String firstName, String lastName, String studentAdharId,
			Date studentdob, String gender, Date startDate, Date endDate, String fathername, Integer fatherage,
			String fatherqualification, Date fatherdob, String fatherprofession, String mothername, Integer motherage,
			String motherqualification, Date motherdob, String motherprofession, String address, String phoneno,
			String cellno, String emailaddress, StudentClass studentClass, List<StudentFeeWaiver> studentFeeWaivers) {
		super();
		this.studentId = studentId;
		this.admissionno = admissionno;
		this.firstName = firstName;
		this.lastName = lastName;
		this.studentAdharId = studentAdharId;
		this.studentdob = studentdob;
		this.gender = gender;
		this.startDate = startDate;
		this.endDate = endDate;
		this.fathername = fathername;
		this.fatherage = fatherage;
		this.fatherqualification = fatherqualification;
		this.fatherdob = fatherdob;
		this.fatherprofession = fatherprofession;
		this.mothername = mothername;
		this.motherage = motherage;
		this.motherqualification = motherqualification;
		this.motherdob = motherdob;
		this.motherprofession = motherprofession;
		this.address = address;
		this.phoneno = phoneno;
		this.cellno = cellno;
		this.emailaddress = emailaddress;
		this.studentClass = studentClass;
		this.studentFeeWaivers = studentFeeWaivers;
	}

//	@Override
//	public String toString() {
//		return "Student [studentId=" + studentId + ", admissionno=" + admissionno + ", firstName=" + firstName
//				+ ", lastName=" + lastName + ", studentAdharId=" + studentAdharId + ", studentdob=" + studentdob
//				+ ", gender=" + gender + ", startDate=" + startDate + ", endDate=" + endDate + ", fathername="
//				+ fathername + ", fatherage=" + fatherage + ", fatherqualification=" + fatherqualification
//				+ ", fatherdob=" + fatherdob + ", fatherprofession=" + fatherprofession + ", mothername=" + mothername
//				+ ", motherage=" + motherage + ", motherqualification=" + motherqualification + ", motherdob="
//				+ motherdob + ", motherprofession=" + motherprofession + ", address=" + address + ", phoneno=" + phoneno
//				+ ", cellno=" + cellno + ", emailaddress=" + emailaddress + ", studentClass=" + studentClass
//				+ ", studentFeeWaivers=" + studentFeeWaivers + "]";
//	}
		
}
