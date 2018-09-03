package com.example.demo.model;

import java.io.Serializable;
import java.util.List;


import com.fasterxml.jackson.annotation.JsonFormat;


public class StudentFeeWaiverHistories implements Serializable{

	private static final long serialVersionUID = 1L;

	@JsonFormat
	private List<StudentFeeWaiverHistory> studentFeeWaiverHistory;

	public List<StudentFeeWaiverHistory> getStudentFeeWaiverHistory() {
		return studentFeeWaiverHistory;
	}

	public void setStudentFeeWaiverHistory(List<StudentFeeWaiverHistory> studentFeeWaiverHistory) {
		this.studentFeeWaiverHistory = studentFeeWaiverHistory;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public StudentFeeWaiverHistories(List<StudentFeeWaiverHistory> studentFeeWaiverHistory) {
		super();
		this.studentFeeWaiverHistory = studentFeeWaiverHistory;
	}
	
	public StudentFeeWaiverHistories() {
		super();
	}
	
}
