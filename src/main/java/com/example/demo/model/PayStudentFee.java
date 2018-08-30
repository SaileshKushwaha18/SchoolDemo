package com.example.demo.model;
import java.io.Serializable;

public class PayStudentFee  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private StudentFee studentFee;
	private String paymentAmount;
	private String paymentComments;
	
	
//	@Override
//	public String toString() {
//		return "PayStudentFee [studentFee=" + studentFee + ", paymentAmount=" + paymentAmount + ", paymentComments="
//				+ paymentComments + "]";
//	}
	
	public StudentFee getStudentFee() {
		return studentFee;
	}
	public void setStudentFee(StudentFee studentFee) {
		this.studentFee = studentFee;
	}
	public String getPaymentAmount() {
		return paymentAmount;
	}
	public void setPaymentAmount(String paymentAmount) {
		this.paymentAmount = paymentAmount;
	}
	public String getPaymentComments() {
		return paymentComments;
	}
	public void setPaymentComments(String paymentComments) {
		this.paymentComments = paymentComments;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
		

}
