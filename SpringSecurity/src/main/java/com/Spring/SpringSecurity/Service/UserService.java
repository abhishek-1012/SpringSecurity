package com.Spring.SpringSecurity.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.Spring.SpringSecurity.Repo.UserRepo;
import com.Spring.SpringSecurity.model.Users;

@Service
public class UserService {
	
	@Autowired
	private UserRepo ur;
	
	
	//In Spring security, Bcrypt is already available in SpringSecurity
	private BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(12);
	
	public Users register(Users user) {
		user.setPassword(encoder.encode(user.getPassword())); //By this, we encode the password and the encoded password is stored in the DB
		return ur.save(user);
		
	}
}
