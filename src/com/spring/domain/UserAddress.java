package com.spring.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class UserAddress {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int addressId;

	@Column
	private String address;
	@Column
	private String postcode;
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	@Override
	public String toString() {
		return "UserAddress [address=" + address + ", postcode=" + postcode + "]";
	}
	
}
