package com.spring.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.Pattern;

import org.codehaus.jackson.annotate.JsonManagedReference;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.spring.validation.DigitsAnn;

@MappedSuperclass
//@Entity
//@Inheritance(strategy=InheritanceType.JOINED)
public class PrpUser{

	@Id //this is the primary key
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="USER_ID") // if you want the col name to be diff, add (name="NNN")
	private int userID;
	
	@Column(unique=true)
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
	//@NotEmpty
	@DigitsAnn(message="invalide phone number")
	private String mobile;
	@Column(unique=true)
	@NotEmpty
	@Email
	private String email;
	@OneToOne(cascade=CascadeType.ALL)
	//@NotEmpty
	@Valid
	private UserAddress address;
	
	/*
	 *When the relationship is bidirectional, there are normally two associations defined : 
	 *one from source to target entity(having the JoinColumn annotation) , 
	 *and the other from target to source entity(having the mapped by attribute ). 
	 *OneToMany bidirectional mapping always implies a ManyToOne mapping back to the source.
	 *The other non-owner entity has to provide the mappedBy attribute to indicate that it is not the owner of the relationship.
	 *The mappedBy attribute refers to the attribute name "user", defined in the entity UserRole. 
	 *Ref: http://www.kumaranuj.com/
	 *mappedBy="user",
	 */
	@OneToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	//@JsonManagedReference
	private List<UserRole> roles = new ArrayList<>();
	
	@Column(nullable=false)
	private boolean enabled=true;
	
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

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
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

	public List<UserRole> getRoles() {
		return roles;
	}

	public void setRoles(List<UserRole> roles) {
		this.roles = roles;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public void addUserRole(UserRole userRole) {
		//userRole.setUser(this);
		roles.add(userRole);
	}

}
