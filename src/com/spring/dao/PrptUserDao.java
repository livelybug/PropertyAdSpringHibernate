package com.spring.dao;

import java.util.List;

import com.spring.domain.PrpUser;


public interface PrptUserDao {
	public void addUser(PrpUser user);
	public PrpUser getUserById(Integer id);
	public List<PrpUser> getUserList();
	public void deleteUserById(Integer id);
	public List<PrpUser> duplcExist(PrpUser user);
	public PrpUser findUserByName(String userName);
}
