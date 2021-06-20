package com.wli.datarepository;

import java.util.ArrayList;
import com.wli.springassement.entities.HotelDetail;

public class TempDataRepository {

	private static ArrayList<HotelDetail> tempHotelList = new ArrayList<HotelDetail>(){{
		add(new HotelDetail("Sason Inn",350,true));
		add(new HotelDetail("Hotel Inn",270,false));
		add(new HotelDetail("Hilton Inn",470,true));
		add(new HotelDetail("Holiday Inn",330,false));
	}};

	public static ArrayList<HotelDetail> getTempHotelList() {
		return tempHotelList;
	}
	
}
