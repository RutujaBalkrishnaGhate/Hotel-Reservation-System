package com.example.hotelreservation.controller;

import java.util.List;

import javax.validation.constraints.Email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.hotelreservation.dao.HotelDAO;
import com.example.hotelreservation.pojo.User;
import com.example.hotelreservation.service.UserService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class SigninController {
	
	@Autowired
	UserService userService;

   
	
	
	@GetMapping("/signin")
    public ModelAndView redirectToLoginPage(){
        return new ModelAndView("signin");
    }
	@GetMapping("/userhome")
	public ModelAndView handleAllHotelGet(HotelDAO hoteldao) {
		
		return new ModelAndView("userhome","hotellist",hoteldao.getAllHotels());
	}
	
	@PostMapping("/authenticate")
    public String authenticateUser(
            @RequestParam @Email(message = "Email is not valid") String email,
            @RequestParam String password,
            Model model, HttpServletRequest request) {

        if (userService.authenticateUser(email, password, request)) {
            // Authentication successful, you can redirect to a secure page
            return "redirect:/userhome";
        } else {
            // Authentication failed, add an error message
            model.addAttribute("error", "Invalid credentials");
            return "signin"; // Return to the login page with an error message
        }
    }
	
	@GetMapping("/manageusers")
    public String getUserManagement(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "manageusers"; // The name of your Thymeleaf template
    }
	
	@PostMapping("/deleteUser")
    public String deleteUser(@RequestParam Long userId, Model model) {
        // Logic to delete user by userId
        userService.deleteUserById(userId);
        return "redirect:/manageusers";
    }
	
	@PostMapping("/updateUser")
	public String updateUser(@ModelAttribute User user) {
	    userService.updateUser(user);
	    return "redirect:/manageusers"; // Redirect to the page displaying the list of users
	}

}
