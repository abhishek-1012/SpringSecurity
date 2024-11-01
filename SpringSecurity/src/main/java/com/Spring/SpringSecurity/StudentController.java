package com.Spring.SpringSecurity;

import java.util.*;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class StudentController {

	private List<Student>st=new ArrayList<>(List.of(new Student("Abhishek",80,1),new Student("John",76,2)));
	
	@GetMapping("Students")
	private List<Student> getStudents(){
		return st;
	}
	
	//CSRF token is required for requests where we are changing something(PUT, DELETE & UPDATE0
	@PostMapping("Students")
	private String getStudents(@RequestBody Student student) {
		st.add(student);
		return "New Student added";
		
	}
	
	@GetMapping("/getCSRFToken")
	public CsrfToken getCSRFToken(HttpServletRequest request) {
		return (CsrfToken)request.getAttribute("_csrf");
	}
	
	
}
