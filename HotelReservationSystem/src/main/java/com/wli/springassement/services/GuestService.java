package com.wli.springassement.services;

import com.wli.springassement.entities.Guest;
import com.wli.springassement.mappers.GuestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestService {

    @Autowired
    GuestMapper guestMapper;

    public List<Guest> getAllGuests(){
        return guestMapper.findAll();
    }
}
