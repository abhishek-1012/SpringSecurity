package com.Spring.SpringSecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Spring.SpringSecurity.Service.UserService;
import com.Spring.SpringSecurity.model.Users;

@RestController
public class UserController {
	
	@Autowired
	private UserService us;
	
	@PostMapping("/register")
	public Users register(@RequestBody Users user) {
		return us.register(user);
	}

}
