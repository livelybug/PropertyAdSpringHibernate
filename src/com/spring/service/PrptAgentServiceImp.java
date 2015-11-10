package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dao.PrptUserDao;
import com.spring.domain.Customer;
import com.spring.domain.PropertyAgent;
import com.spring.domain.PrpUser;

@Service
public class PrptAgentServiceImp implements UserService {

	@Autowired
	PrptUserDao prptAgtDao;
	
	@Override
	public Customer getUserById(Integer id) {
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
	public void addUser(PrpUser user) {
		prptAgtDao.addUser((PropertyAgent)user);
	}

}
