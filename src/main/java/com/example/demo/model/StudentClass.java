package com.example.demo.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="STUDENT_CLASS")
public class StudentClass implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="STUDENT_CLASS_ID")
	private Long studentClassId;
	
	@Column(name="STUDENT_CLASS_NAME_TXT")
	private String name;
	
	@Column(name="STUDENT_CLASS_DESC_TXT")
	private String description;
	
	@Column(name="ACTIVE_FLG")
	private boolean isActive;

    @OneToMany
    @JsonIgnoreProperties("studentClass")
    @JoinTable(name="STUDENT_STUDENTCLASS",
    joinColumns={@JoinColumn(name="STUDENT_CLASS_ID", referencedColumnName="STUDENT_CLASS_ID")},
    inverseJoinColumns={@JoinColumn(name="STUDENT_ID", referencedColumnName="STUDENT_ID")})
	private List<Student> students = new ArrayList<>();
	
	public Long getStudentClassId() {
		return studentClassId;
	}

	public void setStudentClassId(Long studentClassId) {
		this.studentClassId = studentClassId;
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

	@Override
	public String toString() {
		return "StudentClass [studentClassId=" + studentClassId + ", name=" + name + ", description=" + description
				+ ", isActive=" + isActive + ", students=" + students + "]";
	}



}
