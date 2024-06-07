package com.example.hotelreservation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.hotelreservation.dao.HotelDAO;
import com.example.hotelreservation.pojo.Hotel;

import jakarta.servlet.http.HttpServletRequest;



@Controller
public class HotelController {
	
	@Autowired
	HotelDAO hoteldao;

	
	
	@GetMapping("/managehotel")
	public ModelAndView handleAllHotelGet(HotelDAO hoteldao) {
		
		return new ModelAndView("managehotel","hotellist",hoteldao.getAllHotels());
	}
	
	@GetMapping("/addhotel")
	public String addHotel(Model model) {
		
		Hotel hotel = new Hotel();
		
		model.addAttribute("hotel",hotel);
		
		return "addhotel";
	}
	
	@PostMapping("/addedHotel")
	public String addedhotel(@ModelAttribute("hotel") Hotel hotel) {
		
		hoteldao.saveHotel(hotel);
		
		
		return "redirect:/addhotel";
	}
	
	
	 @GetMapping("/updatehotel/{hotelid}")
	    public String updateHotel(@PathVariable int hotelid, Model model) {
	        
		 Hotel existingHotel = hoteldao.getById(hotelid);

	        if (existingHotel != null) {
	            // Populate the model with the existing hotel data
	            model.addAttribute("hotel", existingHotel);

	            return "updatehotel";
	        } else {
	            return "redirect:/managehotel";
	        }
	    }

	    @PostMapping("/updatedhotel")
	    public String updatedHotel(@ModelAttribute("hotel") Hotel updatedHotel, @RequestParam("hotelid") int hotelid) {
	    	 Hotel existingHotel = hoteldao.getById(hotelid);

	         if (existingHotel != null) {
	             // Update the existing hotel with the new values
	             existingHotel.setHotelname(updatedHotel.getHotelname());
	             existingHotel.setHotelcontact(updatedHotel.getHotelcontact());
	             existingHotel.setHotelemail(updatedHotel.getHotelemail());
	             existingHotel.setHotelcity(updatedHotel.getHotelcity());
	             existingHotel.setHoteladdress(updatedHotel.getHoteladdress());

	             hoteldao.updateHotel(existingHotel);

	             return "redirect:/managehotel";
	    }else {
            return "redirect:/managehotel";
        }

	    }	
	    
	    @GetMapping("/deletehotel/{hotelid}")
	    public String deleteHotel(@PathVariable int hotelid) {
	        Hotel existingHotel = hoteldao.getById(hotelid);

	        if (existingHotel != null) {
	            hoteldao.deleteHotel(existingHotel);

	            return "redirect:/managehotel";
	        } else {
	            return "redirect:/managehotel";
	        }
	    }
	    

}

