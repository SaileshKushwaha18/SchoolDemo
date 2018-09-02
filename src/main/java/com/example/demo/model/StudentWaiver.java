package com.example.demo.model;
import java.io.Serializable;

import com.example.demo.model.StudentFee;

public class StudentWaiver  implements Serializable{

	private static final long serialVersionUID = 1L;

	private StudentFee studentFee;
	private String waiverName;
	private String waiverAmount;
	private String waiverComments;
	public StudentFee getStudentFee() {
		return studentFee;
	}
	public void setStudentFee(StudentFee studentFee) {
		this.studentFee = studentFee;
	}
	public String getWaiverName() {
		return waiverName;
	}
	public void setWaiverName(String waiverName) {
		this.waiverName = waiverName;
	}
	public String getWaiverAmount() {
		return waiverAmount;
	}
	public void setWaiverAmount(String waiverAmount) {
		this.waiverAmount = waiverAmount;
	}
	public String getWaiverComments() {
		return waiverComments;
	}
	public void setWaiverComments(String waiverComments) {
		this.waiverComments = waiverComments;
	}
	public StudentWaiver(StudentFee studentFee, String waiverName, String waiverAmount, String waiverComments) {
		super();
		this.studentFee = studentFee;
		this.waiverName = waiverName;
		this.waiverAmount = waiverAmount;
		this.waiverComments = waiverComments;
	}
	public StudentWaiver() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
