package com.wli.springassement.controllers;

import java.util.ArrayList;
import java.util.List;

import com.wli.springassement.entities.Gender;
import com.wli.springassement.entities.Guest;
import com.wli.springassement.services.GuestService;
import com.wli.springassement.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wli.springassement.entities.HotelDetail;
import com.wli.springassement.entities.ReservationDetails;
import com.wli.datarepository.TempDataRepository;

@RestController
public class HotelController {
	
	@Autowired
	GuestService guestService;
	@Autowired
	HotelService hotelService;

	@RequestMapping("/hotellist")
	public List<HotelDetail> hotelList() {
		return hotelService.getAllHotels();
	}

	@RequestMapping("/guestslist")
	public List<Guest> guestsList(){
		return guestService.getAllGuests();
	}
	
	@RequestMapping(value="/reservation", 
			method =RequestMethod.POST ,
			consumes="application/json")
	public String reserveHotel(@RequestBody ReservationDetails reservationDetails) {
		
		return reservationDetails.getHotel_name();
	}
	
	
}
