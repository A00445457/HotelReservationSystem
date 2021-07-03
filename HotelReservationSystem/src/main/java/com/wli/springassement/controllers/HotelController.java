package com.wli.springassement.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.wli.springassement.entities.Guest;
import com.wli.springassement.services.GuestService;
import com.wli.springassement.services.HotelService;
import com.wli.springassement.services.ReservationService;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wli.springassement.entities.HotelDetail;
import com.wli.springassement.entities.ReservationDetails;

@RestController
public class HotelController {
	
	@Autowired
	GuestService guestService;
	@Autowired
	HotelService hotelService;
	@Autowired
	ReservationService reservationService;

	@RequestMapping("/hotellist")
	public List<HotelDetail> hotelList() {
		return hotelService.getAllHotels();
	}

	@RequestMapping("/guestslist")
	public List<Guest> guestsList(){
		return guestService.getAllGuests();
	}

	@RequestMapping("/reservationlist")
	public List<ReservationDetails> reservationList(){
		return reservationService.getAllReservation();
	}
	
	@RequestMapping(value="/reservation", 
			method =RequestMethod.POST ,
			consumes="application/json")
	public String reserveHotel(@RequestBody ReservationDetails reservationDetails) {
		String confirm = reservationService.saveReservation(reservationDetails);
		Map map = new HashMap();
		map.put("confirmation_number", confirm);

		String result = JSONObject.toJSONString(map);
		return result;
	}
	
	
}
