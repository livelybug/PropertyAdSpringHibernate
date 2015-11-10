package com.spring.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Customer extends PrpUser implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id //this is the primary key
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column // if you want the col name to be diff, add (name="NNN")
	private int customerID;
	
	public Customer() {
		super();
	}

	
	public Customer(int customerID) {
		super();
		this.customerID = customerID;
	}


	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

}
