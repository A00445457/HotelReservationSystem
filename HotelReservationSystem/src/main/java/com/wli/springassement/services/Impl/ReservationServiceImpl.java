package com.wli.springassement.services.Impl;

import com.wli.springassement.entities.ReservationDetails;
import com.wli.springassement.mappers.ReservationMapper;
import com.wli.springassement.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    ReservationMapper reservationMapper;

    @Override
    public List<ReservationDetails> getAllReservation(){
        return reservationMapper.findAll();
    }

    @Override
    public String makeReservation(ReservationDetails reservationDetails){

        return "";
    }
}
