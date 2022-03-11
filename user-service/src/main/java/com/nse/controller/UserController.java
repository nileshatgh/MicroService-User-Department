package com.nse.controller;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nse.VO.Department;
import com.nse.VO.ResponseTemplateVO;
import com.nse.entity.User;
import com.nse.service.UserService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	public static final String USER_SERVICE="userServiceFallback";
	
	@PostMapping("/")
	public User saveUser(@RequestBody User user)
	{
		return userService.saveUser(user);
	}
	
	
	@GetMapping("/{id}")
	@CircuitBreaker(name=USER_SERVICE,fallbackMethod="getAllAvailableUsers")
	public ResponseTemplateVO getUserWithDepartment(@PathVariable("id") Long userId) {
		return userService.getUserWithDepartment(userId);
	}
	
	public ResponseTemplateVO getAllAvailableUsers(Exception e) {
		
		return new ResponseTemplateVO(new User(1L,"Gadadhar","Pandit","gadhar@gmail.com",16L),new Department(16L,"Preach","Mayapur","Preach001"));
	}
	
}
