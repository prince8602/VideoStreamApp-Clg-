package com.example.video_platform.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.video_platform.User;
import com.example.video_platform.repository.UserRepository;
import java.util.List;
import java.util.Optional; // <-- जरूरी

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
	
	
	public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

	
	
	
	public User createUser(User user) {
		return userRepository.save(user);
	}
	
	
	
	
	 public User updateUser(Long id, User newUserData) {
	        return userRepository.findById(id)
	            .map(user -> {
	                user.setUsername(newUserData.getUsername());
	                user.setEmail(newUserData.getEmail());
	                return userRepository.save(user);
	            })
	            .orElseGet(() -> {
	                newUserData.setId(id);
	                return userRepository.save(newUserData);
	            });
	    }
	 
	 
	 public void deleteUser(Long id) {
	        userRepository.deleteById(id);
	    }

}
