package com.example.hotelreservation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hotelreservation.dao.HotelDAO;
import com.example.hotelreservation.pojo.Hotel;

@Service
public class HotelServiceImpl implements HotelService{

	@Autowired
    HotelDAO hotelDAO;


	@Override
    public Hotel getHotelById(int id) {
        return hotelDAO.getById(id);
    }

    @Override
    public void deleteHotelById(int id) {
    	hotelDAO.deleteById(id);
    }

}
