package com.wli.springassement.entities;

public class HotelDetail {
	
	public HotelDetail(String hotel_name, int price, boolean availability) {
		this.hotel_name = hotel_name;
		this.price = price;
		this.availability = availability;
	}

	private String hotel_name;
	private int price;
	private boolean availability;
	
	
	public String getHotel_name() {
		return hotel_name;
	}
	public void setHotel_name(String hotel_name) {
		this.hotel_name = hotel_name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public boolean isAvailability() {
		return availability;
	}
	public void setAvailability(boolean availability) {
		this.availability = availability;
	}

}