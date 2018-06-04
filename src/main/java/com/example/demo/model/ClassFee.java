package com.example.demo.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

/**
 * @author Sailesh
 *
 */
@Entity
@Table(name="CLASS_FEE")
public class ClassFee {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="FEE_ID")
	private Long id;
	
	@Column(name="FEE_NAME_TXT")
	private String name;
	
	@Column(name="FEE_DESC_TXT")
	private String description;
	
	@Column(name="FEE_START_DT")
	@Temporal(TemporalType.TIMESTAMP)
	private Date startDate;
	
	@Column(name="FEE_END_DT")
	@Temporal(TemporalType.TIMESTAMP)
	private Date endDate;

	@JsonProperty(access = Access.READ_ONLY)
	@OneToMany(cascade = CascadeType.ALL,mappedBy="classFee")
//	@JoinTable(name = "CLASS_FEE_PARAMS", joinColumns = { @JoinColumn(name = "FEE_ID") }, inverseJoinColumns = { @JoinColumn(name = "CLASS_FEE_PARAMS_ID") })
	private List<ClassFeeParams> classFeeParams;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public ClassFee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ClassFee(Long id, String name, String description, Date startDate, Date endDate) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
	}


	public List<ClassFeeParams> getClassFeeParams() {
		return classFeeParams;
	}

	
	public void setClassFeeParams(List<ClassFeeParams> classFeeParams) {
		this.classFeeParams = classFeeParams;
	}

	public ClassFee(Long id, String name, String description, Date startDate, Date endDate,
			List<ClassFeeParams> classFeeParams) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
		this.classFeeParams = classFeeParams;
	}

	@Override
	public String toString() {
		return "ClassFee [id=" + id + ", name=" + name + ", description=" + description + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", classFeeParams=" + classFeeParams + "]";
	}


}
