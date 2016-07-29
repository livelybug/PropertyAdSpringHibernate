package com.spring.service;

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
import com.spring.domain.PropertyAgent;
import com.spring.domain.PrpUser;
import com.spring.domain.UserRole;

@Service
public class PrptAgentServiceImp implements UserService, UserDetailsService {

	@Autowired
	PrptUserDao prptAgtDao;
	
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
	public void addUser(PrpUser user) {
		user.addUserRole(new UserRole("ROLE_AGENT"));
		prptAgtDao.addUser((PropertyAgent)user);
	}

	@Override
	public List<PrpUser> duplcExist(PrpUser user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDetails loadUserByUsername(String userName)	throws UsernameNotFoundException {

		if(userName == null )
			throw new UsernameNotFoundException("Username cannot be null");
				
		PropertyAgent agent = (PropertyAgent) prptAgtDao.findUserByName(userName);
		if(agent != null)
			return buildUserForAuthentication(agent);
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
	 * Convert from /com/spring/domain/PropertyAgent to org.springframework.security.core.userdetails.User
	 */
	private org.springframework.security.core.userdetails.User buildUserForAuthentication(PropertyAgent agent){
		
		return new org.springframework.security.core.userdetails.User(agent.getUsername(),agent.getPassword(),agent.isEnabled(),
				true,true,true,buildUserAuthority(agent.getRoles()));
		
	}
}
