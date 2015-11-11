package com.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.domain.Customer;
import com.spring.domain.PropertyBld;
import com.spring.domain.PrpUser;

@Repository
public class PropertyBldDaoImp implements PropertyBldDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public void addProperty(PropertyBld property) {
		Session session = sessionFactory.getCurrentSession();
		session.save(property);
	}

	@Override
	@Transactional
	public PropertyBld getPropertyById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public List<PropertyBld> getPropertyList() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from PropertyBld").list();
	}

	@Override
	@Transactional
	public void deletePropertyById(Integer id) {
		// TODO Auto-generated method stub

	}

}
