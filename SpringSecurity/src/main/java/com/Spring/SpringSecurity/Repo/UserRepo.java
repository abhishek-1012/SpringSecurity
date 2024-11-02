package com.Spring.SpringSecurity.Repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Spring.SpringSecurity.model.Users;


@Repository
public interface UserRepo extends JpaRepository<Users, Integer>{
	
	
public Users findByUsername(String name);



}
