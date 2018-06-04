package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="STUDENT_CLASS")
public class StudentClass {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="STUDENT_CLASS_ID")
	private Long StudentClassId;
	
	@Column(name="STUDENT_CLASS_NAME_TXT")
	private String name;
	
	@Column(name="STUDENT_CLASS_DESC_TXT")
	private String description;
	
	@Column(name="ACTIVE_FLG")
	private boolean isActive;

	@OneToMany(mappedBy = "studentClass")
	//@JoinTable(name = "STUDENT_STUDENTCLASS", joinColumns = { @JoinColumn(name = "STUDENT_CLASS_ID") }, inverseJoinColumns = { @JoinColumn(name = "STUDENT_ID") })
	private List<Student> students  = new ArrayList<Student>();
	
	public Long getStudentClassId() {
		return StudentClassId;
	}

	public void setStudentClassId(Long studentClassId) {
		StudentClassId = studentClassId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public StudentClass() {
		super();
		// TODO Auto-generated constructor stub
	}


	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public StudentClass(String name, String description, boolean isActive, List<Student> students) {
		super();
		this.name = name;
		this.description = description;
		this.isActive = isActive;
		this.students = students;
	}



}
