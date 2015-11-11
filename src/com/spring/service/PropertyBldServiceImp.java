package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.spring.dao.PropertyBldDao;
import com.spring.domain.PropertyBld;

public class PropertyBldServiceImp implements PropertyBldService {


	@Autowired
	PropertyBldDao prptDao;

	@Override
	public void addProperty(PropertyBld property) {
		prptDao.addProperty(property);
	}

	@Override
	public PropertyBld getPropertyById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PropertyBld> getPropertyList() {
		return prptDao.getPropertyList();
	}

	@Override
	public void deletePropertyById(Integer id) {
		// TODO Auto-generated method stub

	}

}
