package com.wli.springassement.controllers;

import java.util.*;
import java.util.stream.Stream;

import com.wli.springassement.entities.Guest;
import com.wli.springassement.services.GuestService;
import com.wli.springassement.services.HotelService;
import com.wli.springassement.services.ReservationService;
import com.wli.springassement.utility.Verification;
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
	@Autowired
	Verification verification;

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
	 * @param firstName guest first name
	 * @param lastName guest last name
	 * @return relevant reservation list
	 */
	@RequestMapping("/reservationlistbyname")
	public Object getReservationListByGuest(String firstName, String lastName){
		//check if first name and last name is empty
		if(firstName==null||firstName.isEmpty()||firstName.trim().isEmpty()||
				lastName==null||lastName.isEmpty()||lastName.trim().isEmpty())
			return JSONObject.toJSONString(Collections.singletonMap("error_msg","Please enter not null FirstName and LastName."));
		//call service and get reservation list
		return reservationService.getAllReservationByGuest(firstName, lastName);
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
		//Verify reservation (including guests info)
		Map<String,String> error = new HashMap<>();
		if(!verification.reservationVerification(reservationDetails,error)){
			return JSONObject.toJSONString(error);
		}

		//call service and get confirm number
		String confirm = reservationService.saveReservation(reservationDetails);
		//format return in json
		Map<String,String> map = new HashMap<>();
		map.put("confirmation_number", confirm);

		return JSONObject.toJSONString(map);
	}
	
	
}
