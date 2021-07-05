package com.wli.springassement.services;

import com.wli.springassement.entities.ReservationDetails;

import java.util.List;

public interface ReservationService {
    List<ReservationDetails> getAllReservation();

    List<ReservationDetails> getAllReservationByGuest(String firstName, String lastName);

    String saveReservation(ReservationDetails reservationDetails);
}
