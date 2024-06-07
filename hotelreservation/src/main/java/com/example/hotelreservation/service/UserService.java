package com.example.hotelreservation.service;

import java.util.List;

import org.springframework.http.HttpRequest;

import com.example.hotelreservation.pojo.User;

import jakarta.servlet.http.HttpServletRequest;

public interface UserService {
	
	public void addUser(User user);

    public void updateUser(User user);

    public void deleteUser(User user);

    public User getUserById(long id);

    public User getUserByEmail(String email);

    public void deleteUserById(long id);

    public void deleteUserByEmail(String email);

    public List<User> getAllUsers();

	boolean authenticateUser(String email, String password, HttpServletRequest request);

}
