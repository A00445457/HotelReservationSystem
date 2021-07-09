package com.wli.springassement.controllers;

import java.util.*;

import com.wli.springassement.entities.Guest;
import com.wli.springassement.services.GuestService;
import com.wli.springassement.services.HotelService;
import com.wli.springassement.services.ReservationService;
import com.wli.springassement.utility.Verification;
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
	public Map<String, List<HotelDetail>> hotelList() {
		//call service and get hotel list
		return Collections.singletonMap("hotels_list", hotelService.getAllHotels());
	}

	/**
	 * get hotel list which includes all available
	 * @return available hotel list
	 */
	@RequestMapping("/availablehotel")
	public Map<String, List<HotelDetail>> availableHotelList(){
		//call service and return available hotel list
		return Collections.singletonMap("hotels_list", hotelService.getAvailableHotels());
	}

	/**
	 *
	 * @return json format confirm guests list
	 */
	@RequestMapping("/guestslist")
	public Map<String, List<Guest>> guestsList(){
		//call service and get list list
		return Collections.singletonMap("guests_list", guestService.getAllGuests());
	}

	/**
	 *
	 * @return json format confirm reservation list
	 */
	@RequestMapping("/reservationlist")
	public Map<String,List<ReservationDetails>> reservationList(){
		//call service and get reservation list
		return Collections.singletonMap("reservations_list",reservationService.getAllReservation());
	}

	/**
	 *
	 * @param firstName guest first name
	 * @param lastName guest last name
	 * @return relevant reservation list
	 */
	@RequestMapping("/reservationlistbyname")
	public Map<String,?> getReservationListByGuest(String firstName, String lastName){
		//check if first name and last name is empty
		if(firstName==null||firstName.isEmpty()||firstName.trim().isEmpty()||
				lastName==null||lastName.isEmpty()||lastName.trim().isEmpty())
			return Collections.singletonMap("error_msg","Please enter not null FirstName and LastName.");
		//call service and get reservation list
		return Collections.singletonMap("reservations_list",reservationService.getAllReservationByGuest(firstName, lastName));
	}

	/**
	 *
	 * @param reservationDetails json format parameters, which contains reservation and guest list
	 * @return json format confirm number
	 */
	@RequestMapping(value="/reservation", 
			method =RequestMethod.POST ,
			consumes="application/json")
	public Map<String,?> reserveHotel(@RequestBody ReservationDetails reservationDetails) {
		//Verify reservation (including guests info)
		Map<String,String> error = new HashMap<>();
		if(!verification.reservationVerification(reservationDetails,error)){
			return error;
		}

		//call service and get confirm number
		return Collections.singletonMap("confirmation_number", reservationService.saveReservation(reservationDetails));
	}
	
	
}
