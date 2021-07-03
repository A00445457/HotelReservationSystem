package com.wli.springassement.services.Impl;

import com.wli.springassement.entities.Guest;
import com.wli.springassement.entities.ReservationDetails;
import com.wli.springassement.mappers.GuestMapper;
import com.wli.springassement.mappers.ReservationMapper;
import com.wli.springassement.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    ReservationMapper reservationMapper;
    @Autowired
    GuestMapper guestMapper;

    @Override
    public List<ReservationDetails> getAllReservation(){
        return reservationMapper.findAll();
    }

    @Override
    public String saveReservation(ReservationDetails reservationDetails){
        String confirm = getConfirmCode();
        reservationDetails.setConfirm(confirm);
        reservationMapper.insertReservation(reservationDetails);
        int rid = reservationDetails.getRid();
        for(Guest guest : reservationDetails.getGuest_list()){
            guestMapper.insertGuest(guest);
            int gid = guest.getGid();
            reservationMapper.insertReservationGuest(rid,gid);
        }
        return confirm;
    }

    private String getConfirmCode(){
        StringBuilder str = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            str.append(random.nextInt(10));
        }
        return str.toString();

    }
}
