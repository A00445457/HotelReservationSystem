package com.wli.springassement.services;

import com.wli.springassement.entities.HotelDetail;

import java.util.List;

public interface HotelService {
    List<HotelDetail> getAllHotels();
    List<HotelDetail> getAvailableHotels();
}
