package com.wli.springassement.services;

import com.wli.springassement.entities.ReservationDetails;

import java.util.List;

public interface ReservationService {
    List<ReservationDetails> getAllReservation();

    String makeReservation(ReservationDetails reservationDetails);
}
