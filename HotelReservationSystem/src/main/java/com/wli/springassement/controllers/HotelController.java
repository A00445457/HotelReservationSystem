package com.wli.springassement.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wli.springassement.entities.HotelDetail;
import com.wli.springassement.entities.ReservationDetails;
import com.wli.datarepository.TempDataRepository;

@RestController
public class HotelController {
	

	@RequestMapping("/hotellist")
	public List<HotelDetail> hotelList() {
		return TempDataRepository.getTempHotelList();
	}
	
	@RequestMapping(value="/reservation", 
			method =RequestMethod.POST ,
			consumes="application/json")
	public String reserveHotel(@RequestBody ReservationDetails reservationDetails) {
		
		return reservationDetails.getHotel_name();
	}
	
	
}
