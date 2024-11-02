package com.Spring.SpringSecurity.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import com.Spring.SpringSecurity.model.UserPrincipal;
import org.springframework.stereotype.Service;

import com.Spring.SpringSecurity.Repo.UserRepo;
import com.Spring.SpringSecurity.model.Users;

@Service
public class MyUserDetailsService implements UserDetailsService{

	@Autowired
	private UserRepo UR;
	
	public UserPrincipal loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user=UR.findByUsername(username);
		
		if (user==null) {
			System.out.println("User not found");
			throw new UsernameNotFoundException("User not found");
		}
		
		return new UserPrincipal(user);
	}

	
}
