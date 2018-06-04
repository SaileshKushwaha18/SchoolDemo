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
	
	@Column(name="USERNAME_TXT", nullable=false)
	private String username;
	
	@Column(name="PASSWORD_TXT")
	private String password;

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

	@Override
	public String toString() {
		return "AppUser [id=" + id + ", username=" + username + ", password=" + password + ", getId()=" + getId()
				+ ", getUserName()=" + getUsername() + ", getPassword()=" + getPassword() + "]";
	}

	public AppUser(Long id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}

	public AppUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
