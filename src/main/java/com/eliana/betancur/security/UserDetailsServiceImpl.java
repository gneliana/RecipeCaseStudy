package com.eliana.betancur.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.eliana.betancur.dao.UserDAO;
import com.eliana.betancur.enitity.User;



@Component
public class UserDetailsServiceImpl implements UserDetailsService {

	public static final Logger LOG = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

	@Autowired
	private UserDAO userDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userDao.findByEmail(username);

		if (user == null) {
			throw new UsernameNotFoundException("Username '" + username + "' not found in database");
		}

		//List<UserRole> userRoles = userDao.getUserRoles(user.getId());

		// check the account status
		boolean accountIsEnabled = true;
		//accountIsEnabled = user.isActive();

		// spring security configs
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;

		// setup user roles
		// List<Permission> permissions = userDao.getPermissionsByEmail(username);
		// Collection<? extends GrantedAuthority> springRoles = buildGrantAuthorities(permissions);
		//Collection<? extends GrantedAuthority> springRoles = buildGrantAuthorities(userRoles);

		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), null);
	}

//	private Collection<? extends GrantedAuthority> buildGrantAuthorities(List<Permission> permissions) {
//		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
//		for (Permission permission : permissions) {
//			authorities.add(new SimpleGrantedAuthority(permission.getName()));
//		}
//
//		return authorities;
//	}

//	private Collection<? extends GrantedAuthority> buildGrantAuthorities(List<UserRole> userRoles) {
//		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
//
//		for (UserRole role : userRoles) {
//			authorities.add(new SimpleGrantedAuthority(role.getRole().toString()));
//		}
//
//		// always add the user role
//		authorities.add(new SimpleGrantedAuthority("USER"));
//
//		return authorities;
//	}

}
