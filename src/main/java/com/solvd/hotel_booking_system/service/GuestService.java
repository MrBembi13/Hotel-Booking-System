package com.solvd.hotel_booking_system.service;

import com.solvd.hotel_booking_system.dao.daoClass.GuestsDAO;
import com.solvd.hotel_booking_system.model.GuestsModel;

public class GuestService {

    private GuestsDAO guestsDAO = new GuestsDAO();

    public GuestsModel findByPhoneNumber(String phonenumber) {
        return guestsDAO.getGuestsByPhone(phonenumber);
    }
}
