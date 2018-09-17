package com.example.demo.model;
import java.io.Serializable;

public class StudentPromotedClass  implements Serializable{

	private static final long serialVersionUID = 1L;
	private String studentId;
	private String student;
	private String currentClass;
	private String promotedToClass;
	private String passed;
	
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getStudent() {
		return student;
	}
	public void setStudent(String student) {
		this.student = student;
	}
	public String getCurrentClass() {
		return currentClass;
	}
	public void setCurrentClass(String currentClass) {
		this.currentClass = currentClass;
	}
	public String getPromotedToClass() {
		return promotedToClass;
	}
	public void setPromotedToClass(String promotedToClass) {
		this.promotedToClass = promotedToClass;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getPassed() {
		return passed;
	}
	public void setPassed(String passed) {
		this.passed = passed;
	}
	public StudentPromotedClass() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StudentPromotedClass(String studentId, String student, String currentClass, String promotedToClass,
			String passed) {
		super();
		this.studentId = studentId;
		this.student = student;
		this.currentClass = currentClass;
		this.promotedToClass = promotedToClass;
		this.passed = passed;
	}
	@Override
	public String toString() {
		return "StudentPromotedClass [studentId=" + studentId + ", student=" + student + ", currentClass="
				+ currentClass + ", promotedToClass=" + promotedToClass + ", passed=" + passed + "]";
	}
	
}
