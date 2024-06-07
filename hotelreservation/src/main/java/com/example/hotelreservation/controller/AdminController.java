package com.example.hotelreservation.controller;


import javax.validation.constraints.Email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.hotelreservation.service.AdminService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class AdminController {
	
	@Autowired
	AdminService adminService;
	
	
	
	
	
	@PostMapping("/adminauthenticate")
    public String authenticateAdmin(
            @RequestParam @Email(message = "Email is not valid") String email,
            @RequestParam String password,
            Model model, HttpServletRequest request) {

        if (adminService.authenticateAdmin(email, password, request)) {
            // Authentication successful, you can redirect to a secure page
            return "redirect:/adminhome";
        } else {
            // Authentication failed, add an error message
            model.addAttribute("error", "Invalid credentials");
            return "redirect:/adminlogin"; // Return to the login page with an error message
        }
    }
	
	
	


}
