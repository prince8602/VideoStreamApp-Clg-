package com.example.video_platform.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class HomeController {
	
	 @GetMapping("/")
	    public String home() {
	        return "एप्लिकेशन चल रही है!";
	    }

}
