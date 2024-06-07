package com.example.hotelreservation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hotelreservation.dao.AdminDAO;
import com.example.hotelreservation.pojo.Admin;
import com.example.hotelreservation.pojo.User;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	AdminDAO adminDAO;
	
	
	@Override
    public boolean authenticateAdmin(String email, String password, HttpServletRequest request) {
        Admin admin = adminDAO.getByEmail(email);
        HttpSession session= request.getSession();
        session.setAttribute("aid",admin.getAid());

        // Check if the user exists and the password matches (plain text comparison)
        return admin != null
                && admin.getEmail() != null && admin.getEmail().equals(email)
                && admin.getPassword() != null && admin.getPassword().equals(password);}

}
