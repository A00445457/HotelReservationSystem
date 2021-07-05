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
     * @return List<ReservationDetails>
     */
    @Override
    public List<ReservationDetails> getAllReservation(){
        return reservationMapper.findAll();
    }

    /**
     * query reservation relevant to guest
     * @param firstName firstname
     * @param lastName lastName
     * @return List<ReservationDetails>
     */
    public List<ReservationDetails> getAllReservationByGuest(String firstName, String lastName){
        return reservationMapper.findReservationByName(firstName, lastName);
    }

    /**
     * save reservation information in database
     * 1. reservation information (reservation table and reservation_guest relation table)
     * 2. guest list (guest table)
     * @param reservationDetails reservation info
     * @return confirm code
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
            //First, check if guest info has already in our database
            List<Guest> a = guestMapper.findGuestByName(guest.getFirstName(),guest.getLastName());
            if(a.size()==0){
                //if no, insert into guest table
                guestMapper.insertGuest(guest);
            }else{
                //if yes, get gid for inserting into relationship
                guest.setGid(a.get(0).getGid());
            }
            int gid = guest.getGid();
            reservationMapper.insertReservationGuest(rid,gid);
        }
        return confirm;
    }

    /**
     * generate a random 6 digit confirm code
     * @return confirm code
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
