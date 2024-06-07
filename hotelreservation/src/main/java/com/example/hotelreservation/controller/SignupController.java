package com.example.hotelreservation.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.hotelreservation.dao.HotelDAO;
import com.example.hotelreservation.dao.UserDAO;
import com.example.hotelreservation.pojo.Hotel;
import com.example.hotelreservation.pojo.Role;
import com.example.hotelreservation.pojo.User;
import com.example.hotelreservation.service.UserService;

@Controller
@Validated
public class SignupController {
	
	@Autowired
	UserDAO userdao;
	
	
	
	
	@GetMapping("/signup")
	public String addUser(Model model) {
		
		User user = new User();
		
		model.addAttribute("user",user);
		
		return "signup";
	}
	
	@PostMapping("/addeduser")
	public String addedhotel(@ModelAttribute("user") User user) {
		
		
		System.out.println(user.getEmail());
		System.out.println(user.getFirstName());
		System.out.println(user.getLastName());
		System.out.println(user.getPassword());
		
		userdao.save(user);
		
		
		return "redirect:/signin";
	}
    
	

}
