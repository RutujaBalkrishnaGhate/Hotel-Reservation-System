package com.example.hotelreservation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hotelreservation.dao.UserDAO;
import com.example.hotelreservation.pojo.User;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
    UserDAO userDAO;

    @Override
    public void addUser(User user) {
        userDAO.save(user);
    }
    
    @Override
    public boolean authenticateUser(String email, String password, HttpServletRequest request) {
        User user = userDAO.getByEmail(email);
        HttpSession session= request.getSession();
        session.setAttribute("userid",user.getId());

        if (user != null) {
            // User with the provided email exists
            if (user.getEmail() != null && user.getEmail().equals(email)) {
                // Email is correct
                if (user.getPassword() != null && user.getPassword().equals(password)) {
                    // Password is correct
                    return true;
                } else {
                    // Password is incorrect
                    return false;
                }
            } else {
                // Email is incorrect
                return false;
            }
        } else {
            // User with the provided email doesn't exist
            return false;
        }
    }

    @Override
    public void updateUser(User user) {
        userDAO.update(user);
    }

    @Override
    public void deleteUser(User user) {
        userDAO.delete(user);
    }

    @Override
    public User getUserById(long id) {
        return userDAO.getById(id);
    }

    @Override
    public User getUserByEmail(String email) {
        return userDAO.getByEmail(email);
    }

    @Override
    public void deleteUserById(long id) {
        userDAO.deleteById(id);
    }

    @Override
    public void deleteUserByEmail(String email) {
        userDAO.deleteByEmail(email);
    }

    @Override
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

}
