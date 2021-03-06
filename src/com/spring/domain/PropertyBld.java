package com.spring.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.servlet.http.Part;
import javax.validation.Valid;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table
public class PropertyBld implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id //this is the primary key
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column 
	private int propertyId;
	@Column
	@NotEmpty
	private String propertyName;
	@OneToOne(cascade=CascadeType.ALL)
	@Valid
	private UserAddress address;
	@Column
	@NotEmpty
	private String rent_sale;
	@Column
	private String comment;
	@ManyToOne(cascade=CascadeType.ALL)
	@Valid
	private PropertyAgent pAgt;

	@Lob
    //@ElementCollection(targetClass=byte[].class)
	//@OrderColumn
	@Column
	//private List<byte[]> propertyImages;
	private byte[] propertyImage;	
	
	public int getPropertyId() {
		return propertyId;
	}
	public void setPropertyId(int propertyId) {
		this.propertyId = propertyId;
	}
	public String getPropertyName() {
		return propertyName;
	}
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
	public UserAddress getAddress() {
		return address;
	}
	public void setAddress(UserAddress address) {
		this.address = address;
	}
	public String getRent_sale() {
		return rent_sale;
	}
	public void setRent_sale(String rent_sale) {
		this.rent_sale = rent_sale;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public PropertyAgent getpAgt() {
		return pAgt;
	}
	public void setpAgt(PropertyAgent pAgt) {
		this.pAgt = pAgt;
	}
	public byte[] getPropertyImage() {
		return propertyImage;
	}
	public void setPropertyImage(byte[] propertyImage) {
		this.propertyImage = propertyImage;
	}
	
}
