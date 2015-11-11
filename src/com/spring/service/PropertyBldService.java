package com.spring.service;

import java.util.List;

import com.spring.domain.PropertyBld;

public interface PropertyBldService {
	public void addProperty(PropertyBld property);
	public PropertyBld getPropertyById(Integer id);
	public List<PropertyBld> getPropertyList();
	public void deletePropertyById(Integer id);
}
