package com.spring.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.spring.dao.PrptUserDao;
import com.spring.domain.Customer;
import com.spring.domain.PrpUser;
import com.spring.domain.UserRole;

@Service
public class CustomerServiceImp implements UserService, UserDetailsService {

	@Autowired
	PrptUserDao custDao;
	
	@Override
	public void addUser(PrpUser user) {
		user.addUserRole(new UserRole("ROLE_USER"));
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

	@Override
	public List<PrpUser> duplcExist(PrpUser user) {
		return custDao.duplcExist(user);
	}

	@Override
	public UserDetails loadUserByUsername(String userName)	throws UsernameNotFoundException {

		if(userName == null )
			throw new UsernameNotFoundException("Username cannot be null");
				
		Customer customer = (Customer) custDao.findUserByName(userName);
		if(customer != null)
			return buildUserForAuthentication(customer);
		else
			throw new UsernameNotFoundException("Username cannot be found in DB");
	}

	private List<GrantedAuthority> buildUserAuthority(List<UserRole> userRoles) {
		
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for(UserRole userRole : userRoles) {
			authorities.add(new SimpleGrantedAuthority(userRole.getRole()));
		}
		return authorities;
	}
	
	/**
	 * Convert from /com/spring/domain/Customer to org.springframework.security.core.userdetails.User
	 */
	private org.springframework.security.core.userdetails.User buildUserForAuthentication(Customer customer){
		
		return new org.springframework.security.core.userdetails.User(customer.getUsername(),customer.getPassword(),customer.isEnabled(),
				true,true,true,buildUserAuthority(customer.getRoles()));
		
	}

}
