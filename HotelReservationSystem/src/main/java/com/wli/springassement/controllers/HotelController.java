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

	/**
	 *
	 * @return json format hotel list
	 */
	@RequestMapping("/hotellist")
	public List<HotelDetail> hotelList() {
		//call service and get hotel list
		return hotelService.getAllHotels();
	}

	/**
	 *
	 * @return json format confirm guests list
	 */
	@RequestMapping("/guestslist")
	public List<Guest> guestsList(){
		//call service and get list list
		return guestService.getAllGuests();
	}

	/**
	 *
	 * @return json format confirm reservation list
	 */
	@RequestMapping("/reservationlist")
	public List<ReservationDetails> reservationList(){
		//call service and get reservation list
		return reservationService.getAllReservation();
	}

	/**
	 *
	 * @param reservationDetails json format parameters, which contains reservation and guest list
	 * @return json format confirm number
	 */
	@RequestMapping(value="/reservation", 
			method =RequestMethod.POST ,
			consumes="application/json")
	public String reserveHotel(@RequestBody ReservationDetails reservationDetails) {
		//call service and get confirm number
		String confirm = reservationService.saveReservation(reservationDetails);
		//format return in json
		Map map = new HashMap();
		map.put("confirmation_number", confirm);

		String result = JSONObject.toJSONString(map);
		return result;
	}
	
	
}
