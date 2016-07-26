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
	 * If the class structure is changed in, e.g. phase II, update the "serialVersionUID" manually 
	 */
	private static final long serialVersionUID = 1L;
	
	public Customer() {
		super();
	}

	/*
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
*/}
