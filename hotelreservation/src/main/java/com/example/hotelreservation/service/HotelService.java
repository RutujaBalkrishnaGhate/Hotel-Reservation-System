package com.example.hotelreservation.service;

import com.example.hotelreservation.pojo.Hotel;

public interface HotelService {

	Hotel getHotelById(int id);

//	Hotel getHotelByEmail(String email);

	void deleteHotelById(int id);
	
	

}
