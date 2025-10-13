package com.example.video_platform.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.video_platform.User;
import com.example.video_platform.repository.UserRepository;
import java.util.List;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	
	public User createUser(User user) {
		return userRepository.save(user);
	}
	
	
	//

}
