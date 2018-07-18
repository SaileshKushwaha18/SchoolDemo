/**
 * 
 */
package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Sailesh
 *
 */

@Entity
@Table(name="APP_USER")
public class AppUser {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private Long id;
	
	@Column(name="USERNAME_TXT")
	private String username;
	
	@Column(name="PASSWORD_TXT")
	private String password;

	@Column(name="EMAIL_TXT", nullable=false)
	private String email;
	
	@Column(name="USER_ID_TXT")
	private String userId;
	
	@Column(name="USER_TYPE_TXT")
	private String userType;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	@Override
	public String toString() {
		return "AppUser [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", userId=" + userId + ", userType=" + userType + "]";
	}

	public AppUser(Long id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}

	public AppUser(Long id, String username, String password, String email) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
	}

	public AppUser(Long id, String username, String password, String email, String userId) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.userId = userId;
	}

	public AppUser(Long id, String username, String password, String email, String userId, String userType) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.userId = userId;
		this.userType = userType;
	}

	public AppUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
