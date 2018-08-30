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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Sailesh
 *
 */
@Entity
@Table(name="CLASS_FEE")
public class ClassFee  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CLASS_FEE_ID")
	private Long classFeeId;
	
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

	//@Column(name="FEE_AMT")
	//private String classFeeAmount;
	
	//@JsonProperty(access = Access.READ_ONLY)
	@OneToMany
    @JoinTable(name="CLASSFEE_CLASSFEEPARAMS",
    joinColumns={@JoinColumn(name="CLASS_FEE_ID", referencedColumnName="CLASS_FEE_ID")},
    inverseJoinColumns={@JoinColumn(name="CLASS_FEE_PARAMS_ID", referencedColumnName="CLASS_FEE_PARAMS_ID")})
	private List<ClassFeeParams> classFeeParams;
	

	public Long getClassFeeId() {
		return classFeeId;
	}

	public void setClassFeeId(Long classFeeId) {
		this.classFeeId = classFeeId;
	}

	/*public String getClassFeeAmount() {
		return classFeeAmount;
	}

	public void setClassFeeAmount(String classFeeAmount) {
		this.classFeeAmount = classFeeAmount;
	}*/

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

	public ClassFee(Long classFeeId, String name, String description, Date startDate, Date endDate) {
		super();
		this.classFeeId = classFeeId;
		this.name = name;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
	}


	public ClassFee(Long classFeeId, String name, String description, Date startDate, Date endDate,
			List<ClassFeeParams> classFeeParams) {
		super();
		this.classFeeId = classFeeId;
		this.name = name;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
		this.classFeeParams = classFeeParams;
	}

	public List<ClassFeeParams> getClassFeeParams() {
		return classFeeParams;
	}

	
	public void setClassFeeParams(List<ClassFeeParams> classFeeParams) {
		this.classFeeParams = classFeeParams;
	}



	@Override
	public String toString() {
		return "ClassFee [classFeeId=" + classFeeId + ", name=" + name + ", description=" + description + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", classFeeParams=" + classFeeParams + "]";
	}


}
