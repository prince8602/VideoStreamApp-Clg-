package com.example.video_platform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.example.video_platform.User;
import com.example.video_platform.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	
	@Autowired
	private UserService userService;
	
	
	@GetMapping
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	
	
	 @PostMapping
	    public User createUser(@RequestBody User user) {
	        return userService.createUser(user);
	    }
}
