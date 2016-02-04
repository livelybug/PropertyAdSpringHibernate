package com.spring.service;

import java.util.List;

import com.spring.domain.PrpUser;


public interface UserService {
	public PrpUser getUserById(Integer id);
	public List<PrpUser> getUserList();
	public void deleteUserById(Integer id);
	public void addUser(PrpUser user);
	public List<PrpUser> duplcExist(PrpUser user);
}
