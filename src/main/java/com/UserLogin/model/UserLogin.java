package com.UserLogin.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "userdetails")
public class UserLogin {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name= "firstname")
	private String firstname;
	
	@Column(name= "lastname")
	private String lastname;
	
	@Column(name= "password")
	private String password;
	
	@Id
	@Column(name= "email")
	private String email;
	
	@Column(name= "phonenumber")
	private String phonenumber;

	public UserLogin(){
		
	}
	
	

	public UserLogin(Long id, String firstname, String lastname, String password, String email, String phonenumber) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.password = password;
		this.email = email;
		this.phonenumber = phonenumber;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
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

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	
	

}


