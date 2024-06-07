package com.example.hotelreservation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.hotelreservation.pojo.Hotel;

@Controller
public class IndexController {
	
	
	@GetMapping("/")
	public String getHandle(Hotel h) {
		return "index";
	}
	
	@GetMapping("/adminlogin")
	public String getHandleAdmin() {
		return "adminlogin";
	}
	
	@GetMapping("/adminhome")
	public String getHandleHome() {
		return "adminhome";
	}
	
	

}
