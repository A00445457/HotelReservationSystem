package com.wli.springassement.services.Impl;

import com.wli.springassement.entities.HotelDetail;
import com.wli.springassement.mappers.HotelMapper;
import com.wli.springassement.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServiceImpl implements HotelService {
    @Autowired
    HotelMapper hotelMapper;

    @Override
    public List<HotelDetail> getAllHotels(){
        return hotelMapper.findAll();
    }

    @Override
    public List<HotelDetail> getAvailableHotels(){
        return hotelMapper.findAllAvailable();
    }
}
