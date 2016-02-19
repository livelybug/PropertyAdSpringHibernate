package com.spring.domain.test;

import com.spring.domain.PropertyAgent;
import com.spring.domain.PropertyBld;
import com.spring.domain.UserAddress;

public class PropertyBldBuilder {

	private PropertyBld prptModel;
	private UserAddress address;
	private PropertyAgent pAgt;
	
	public PropertyBldBuilder() {
		prptModel = new PropertyBld();
		address = new UserAddress();
		pAgt = new PropertyAgent();
		this.setAddress();
		this.setPropertyAgent();
	}
	
    public PropertyBldBuilder setPropertyId(int propertyId) {
    	prptModel.setPropertyId(propertyId);
        return this;
    }

    public PropertyBldBuilder setPropertyName(String propertyName) {
    	prptModel.setPropertyName(propertyName);
        return this;
    }
    
    public PropertyBldBuilder setRent_sale(String rent_sale) {
    	prptModel.setRent_sale(rent_sale);
        return this;
    }

    public void setAddress() {    
    	address.setAddress("PA_UT");
    	address.setAddressId(201);
    	address.setPostcode("857644");
    	prptModel.setAddress(address);;
    }

    public void setPropertyAgent() {
    	pAgt.setAgentID(301);
    	pAgt.setAddress(address);
    	pAgt.setEmail("pAgt1@abc.com");
    	pAgt.setFirstName("PANF");
    	pAgt.setGender("male");
    	pAgt.setLastName("PANL");
    	pAgt.setLicence("kj1111");
    	pAgt.setMobile("9876787");
    	pAgt.setPassword("psdf");
    	pAgt.setUsername("paU");
    	prptModel.setpAgt(pAgt);
    }
    
    public PropertyBld build() {
        return prptModel;
    }
}
