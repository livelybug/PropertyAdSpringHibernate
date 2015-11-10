package com.spring.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table
public class PropertyAgent extends PrpUser implements Cloneable{

	@Id //this is the primary key
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column // if you want the col name to be diff, add (name="NNN")
	private int agentID;

	@Column(unique=true)
	@NotEmpty
	private String licence;
	
	public PropertyAgent() {
		super();
	}

	public String getLicence() {
		return licence;
	}

	public void setLicence(String licence) {
		this.licence = licence;
	}

	public int getAgentID() {
		return agentID;
	}

	public void setAgentID(int agentID) {
		this.agentID = agentID;
	}

	 public Object clone() throws CloneNotSupportedException {
	        return super.clone();
	}
}
