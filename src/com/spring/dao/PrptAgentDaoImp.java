package com.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.domain.PropertyAgent;
import com.spring.domain.PrpUser;

@Repository
public class PrptAgentDaoImp implements PrptUserDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public void addUser(PrpUser user) {
		Session session = sessionFactory.getCurrentSession();
		session.save((PropertyAgent)user);
	}

	@Override
	public PrpUser getUserById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PrpUser> getUserList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUserById(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<PrpUser> duplcExist(PrpUser user) {
		// TODO Auto-generated method stub
		return null;
	}

}
