package com.wli.springassement.services;

import com.wli.springassement.entities.ReservationDetails;
import com.wli.springassement.mappers.ReservationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {

    @Autowired
    ReservationMapper reservationMapper;

    public List<ReservationDetails> getAllReservation(){
        return reservationMapper.findAll();
    }
}
