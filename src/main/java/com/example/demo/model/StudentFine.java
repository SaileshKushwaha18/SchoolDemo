package com.example.demo.model;
import java.io.Serializable;

import com.example.demo.model.StudentFee;

public class StudentFine  implements Serializable{

	private static final long serialVersionUID = 1L;

	private StudentFee studentFee;
	private String fineAmount;
	private String fineComments;
	
	
	public StudentFee getStudentFee() {
		return studentFee;
	}
	public void setStudentFee(StudentFee studentFee) {
		this.studentFee = studentFee;
	}

	public String getFineAmount() {
		return fineAmount;
	}

	public void setFineAmount(String fineAmount) {
		this.fineAmount = fineAmount;
	}

	public String getFineComments() {
		return fineComments;
	}

	public void setFineComments(String fineComments) {
		this.fineComments = fineComments;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
