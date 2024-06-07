package com.example.hotelreservation.service;

import com.example.hotelreservation.pojo.Admin;

import jakarta.servlet.http.HttpServletRequest;

public interface AdminService {

	boolean authenticateAdmin(String email, String password, HttpServletRequest request);


}
