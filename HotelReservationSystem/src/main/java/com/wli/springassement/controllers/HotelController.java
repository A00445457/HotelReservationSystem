package com.wli.springassement.controllers;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wli.springassement.entities.HotelDetail;

import com.wli.datarepository.TempDataRepository;

@RestController
public class HotelController {
	
//	public TempDataRepository tempHotelList;

	@RequestMapping("hotellist")
	public ArrayList<HotelDetail> hotelList() {
		return TempDataRepository.getTempHotelList();
	}
}
