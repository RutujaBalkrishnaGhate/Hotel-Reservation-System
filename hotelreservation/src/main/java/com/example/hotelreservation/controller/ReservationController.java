package com.example.hotelreservation.controller;

import com.example.hotelreservation.pojo.Hotel;
import com.example.hotelreservation.pojo.Reservation;
import com.example.hotelreservation.pojo.User;
import com.example.hotelreservation.service.HotelService;
import com.example.hotelreservation.service.ReservationService;
import com.example.hotelreservation.service.UserService;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Controller
public class ReservationController {

    private final HotelService hotelService;
    private final ReservationService reservationService;
    private final UserService userService;

    @Autowired
    public ReservationController(HotelService hotelService, ReservationService reservationService, UserService userService) {
        this.hotelService = hotelService;
        this.reservationService = reservationService;
        this.userService = userService;
    }

    @GetMapping("/book/{hotelid}")
    public String showReservationForm(@PathVariable int hotelid, Model model, HttpSession session) {       
    		Long userid = (Long) session.getAttribute("userid");
    		System.out.println("gkjkhl; " + userid);
    		if (userid != null) {
    	
            Hotel hotel = hotelService.getHotelById(hotelid);
            Reservation reservation = new Reservation();
            reservation.setHotel(hotel);
            reservation.setUser(userService.getUserById(userid));
            model.addAttribute("reservation", reservation);
            return "reservation";
    		 } else {
    	            return "redirect:/signin";
    	     }
       
    }

    @PostMapping("/book/{hotelid}")
    public String makeReservation(@ModelAttribute("reservation") Reservation reservation,
                                  @PathVariable int hotelid,
                                  @RequestParam("checkInDate") String checkInDate,
                                  @RequestParam("checkOutDate") String checkOutDate,
                                  HttpSession session) {

        Long userId = (Long) session.getAttribute("userid");

        if (userId != null) {
            reservation.setUser(userService.getUserById(userId));

            Hotel hotel = hotelService.getHotelById(hotelid);
            reservation.setHotel(hotel);
            reservation.setCheckInDate(LocalDate.parse(checkInDate));
            reservation.setCheckOutDate(LocalDate.parse(checkOutDate));

            reservationService.saveReservation(reservation);

            return "redirect:/myreservations";
        } else {
            return "redirect:/signin";
        }
    }
    

    @GetMapping("/myreservations")
    public String showReservations(Model model, HttpSession session) {
        // Retrieve the user ID from the session
        Long userId = (Long) session.getAttribute("userid");

        if (userId != null) {
            List<Reservation> reservations = reservationService.getReservationsByUserId(userId);

            model.addAttribute("reservations", reservations);
            return "myreservations";
        } else {
            return "redirect:/signin";
        }
    }
    
    @PostMapping("/cancelReservation")
    public String cancelReservation(@RequestParam Long reservationId) {
        reservationService.cancelReservation(reservationId);
        return "redirect:/myreservations";
        }

}
