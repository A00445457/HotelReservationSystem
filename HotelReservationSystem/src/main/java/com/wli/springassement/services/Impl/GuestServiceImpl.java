package com.wli.springassement.services.Impl;

import com.wli.springassement.entities.Guest;
import com.wli.springassement.mappers.GuestMapper;
import com.wli.springassement.services.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestServiceImpl implements GuestService {

    @Autowired
    GuestMapper guestMapper;

    @Override
    public List<Guest> getAllGuests(){
        return guestMapper.findAll();
    }
}
