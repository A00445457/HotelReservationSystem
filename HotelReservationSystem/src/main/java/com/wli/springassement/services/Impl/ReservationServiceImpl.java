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

    /**
     * call reservationMapper to get all ReservationDetails, which includes a list of reservation details
     * And in each reservationDetails there is a list of guest besides reservation information
     * @return
     */
    @Override
    public List<ReservationDetails> getAllReservation(){
        return reservationMapper.findAll();
    }

    /**
     * save reservation information in database
     * 1. reservation information (reservation table and reservation_guest relation table)
     * 2. guest list (guest table)
     * @param reservationDetails
     * @return
     */
    @Override
    public String saveReservation(ReservationDetails reservationDetails){
        //generate confirm code
        String confirm = getConfirmCode();
        //assign confirm code to reservation obj
        reservationDetails.setConfirm(confirm);
        //save reservation table
        reservationMapper.insertReservation(reservationDetails);
        //get the rid of reservation record which we just save in database
        int rid = reservationDetails.getRid();
        //save reservation_guest table
        for(Guest guest : reservationDetails.getGuest_list()){
            guestMapper.insertGuest(guest);
            int gid = guest.getGid();
            reservationMapper.insertReservationGuest(rid,gid);
        }
        return confirm;
    }

    /**
     * generate a random 6 digit confirm code
     * @return
     */
    private String getConfirmCode(){
        StringBuilder str = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            str.append(random.nextInt(10));
        }
        return str.toString();

    }
}
