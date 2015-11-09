package com.spring.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class PropertyAgent extends PrpUser implements Cloneable{
	@Column
	private String licence;
	@Column
	private int agentID;
	
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
