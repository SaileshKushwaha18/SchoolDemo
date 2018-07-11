package com.example.demo.model;
import java.io.Serializable;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonFormat;

public class GenerateFee  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ClassFee classFee;
	
	@JsonFormat
	private List<StudentClass> studentClasses;
	
	public ClassFee getClassFee() {
		return classFee;
	}
	public void setClassFee(ClassFee classFee) {
		this.classFee = classFee;
	}
	public List<StudentClass> getStudentClass() {
		return studentClasses;
	}
	public void setStudentClass(List<StudentClass> studentClasses) {
		this.studentClasses = studentClasses;
	}
	@Override
	public String toString() {
		return "GenerateFee [classFee=" + classFee + ", studentClasses=" + studentClasses + "]";
	}
	
	public GenerateFee() {
		super();
	}
	public GenerateFee(ClassFee classFee, List<StudentClass> studentClasses) {
		super();
		this.classFee = classFee;
		this.studentClasses = studentClasses;
	}
		

}
