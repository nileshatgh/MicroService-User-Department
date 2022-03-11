package com.nse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.nse.VO.Department;
import com.nse.VO.ResponseTemplateVO;
import com.nse.entity.User;

@SpringBootApplication
public class UserServiceApplication {

	public static final String USER_SERVICE="userService";

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}
	
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	public ResponseTemplateVO getAllAvailableUsers(Exception e) {
		
		return new ResponseTemplateVO(new User(1L,"Gadadhar","Pandit","gadhar@gmail.com",16L),new Department(16L,"Preach","Mayapur","Preach001"));
	}


}
