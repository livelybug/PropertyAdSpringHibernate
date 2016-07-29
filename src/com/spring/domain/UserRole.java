package com.spring.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonBackReference;

@Entity
@Table
public class UserRole {
	
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long userRoleId;
	
/*	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="USER_ID", nullable=false) 
	// if no @JoinColumn is defined along with the @ManyToOne mapping, then a default name is assumed
	@JsonBackReference
	private PrpUser user;
*/	
	@Column(nullable=false)
	private String role;
	
	public UserRole() {
		super();
	}

	public UserRole(String role) {
		super();
		this.role = role;
	}

	public Long getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(Long userRoleId) {
		this.userRoleId = userRoleId;
	}

/*	public PrpUser getUser() {
		return user;
	}

	public void setUser(PrpUser user) {
		this.user = user;
	}
*/
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

/*	@Override
	public String toString() {
		return "UserRole [userRoleId=" + userRoleId + ", user=" + user + ", role=" + role + "]";
	}
*/}
