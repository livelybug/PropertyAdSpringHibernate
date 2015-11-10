package com.spring.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.validation.Valid;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@MappedSuperclass
public class PrpUser{
	@Column
	@NotEmpty
	private String username;
	@Column
	@NotEmpty
	private String password;
	@Column
	@NotEmpty
	private String firstName;
	@Column
	@NotEmpty
	private String lastName;
	@Column
	@NotEmpty
	private String gender;
	@Column
	@NotEmpty
	private String mobile;
	@Column
	@NotEmpty
	@Email
	private String email;
	@OneToOne(cascade=CascadeType.ALL)
	//@NotEmpty
	@Valid
	private UserAddress address;
	
	public PrpUser() {
	}

	public PrpUser(String username, String password, String firstName, String lastName, String gender, String mobile,
			String email, UserAddress address) {
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.mobile = mobile;
		this.email = email;
		this.address = address;
	}

	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UserAddress getAddress() {
		return address;
	}

	public void setAddress(UserAddress address) {
		this.address = address;
	}


}
