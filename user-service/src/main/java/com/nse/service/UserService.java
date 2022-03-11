package com.nse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.nse.VO.Department;
import com.nse.VO.ResponseTemplateVO;
import com.nse.entity.User;
import com.nse.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RestTemplate restTemplate;

	
	public User saveUser(User user) {;
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}


	
	public ResponseTemplateVO getUserWithDepartment(Long userId) {
		// TODO Auto-generated method stub
		ResponseTemplateVO vo = new ResponseTemplateVO();
		User user = userRepository.findByUserId(userId);
	
		Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" + user.getDepartmentId(),Department.class);
		vo.setUser(user);
		vo.setDepartment(department);
		return vo;
	}

	
}
