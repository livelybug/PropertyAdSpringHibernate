package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dao.PrptUserDao;
import com.spring.domain.PrpUser;

@Service
public class CustomerServiceImp implements UserService {

	@Autowired
	PrptUserDao custDao;
	
	@Override
	public void addUser(PrpUser user) {
		custDao.addUser(user);
	}

	@Override
	public PrpUser getUserById(Integer id) {
		return custDao.getUserById(id);
	}

	@Override
	public List<PrpUser> getUserList() {
		return custDao.getUserList();
	}

	@Override
	public void deleteUserById(Integer id) {
		custDao.deleteUserById(id);

	}

}
