package com.wli.springassement.services;

import com.wli.springassement.entities.HotelDetail;
import com.wli.springassement.mappers.HotelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {
    @Autowired
    HotelMapper hotelMapper;

    public List<HotelDetail> getAllHotels(){
        return hotelMapper.findAll();
    }
}
