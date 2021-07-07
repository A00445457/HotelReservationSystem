package com.wli.springassement.utility;

import com.wli.springassement.entities.Guest;
import com.wli.springassement.entities.ReservationDetails;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class Verification {


    /**
     * check if reservation information is valid
     * return match error message
     * @param reservation resservation information
     * @return boolean represent valid or not
     */
    public boolean reservationVerification(ReservationDetails reservation, Map<String,String> error) {
        if(!guestsVerification(reservation.getGuest_list())){
            error.put("error_msg","Empty guest information, please check and try again.");
            return false;
        }
        if(reservation.getHotel_name().isEmpty()){
            error.put("error_msg","Empty hotel name, please check and try again.");
            return false;
        }
        if(reservation.getCheckin()==null||reservation.getCheckout()==null){
            error.put("error_msg","Empty check in(out) date, please check and try again.");
            return false;
        }
        if(reservation.getCheckin().after(reservation.getCheckout())){
            error.put("error_msg","Invalid check in(out) date, please check and try again.");
            return false;
        }
        return true;
    }

    /**
     * check if guest information is valid
     * @param guests guest information
     * @return boolean represent valid or not
     */
    public boolean guestsVerification(List<Guest> guests) {
        for(Guest g : guests){
            if(g.getFirstName().isEmpty())
                return false;
            if(g.getLastName().isEmpty())
                return false;
        }
        return true;
    }
}
