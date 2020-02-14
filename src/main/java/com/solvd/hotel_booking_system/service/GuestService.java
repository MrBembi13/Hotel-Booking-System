package com.solvd.hotel_booking_system.service;

import com.solvd.hotel_booking_system.dao.daoClass.AddressDAO;
import com.solvd.hotel_booking_system.dao.daoClass.GuestsDAO;
import com.solvd.hotel_booking_system.model.GuestsModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GuestService {

    private static final Logger LOGGER = LogManager.getLogger(AddressDAO.class);

    private GuestsDAO guestsDAO = new GuestsDAO();

    public GuestsModel findByPhoneNumber(String phonenumber) {
        return guestsDAO.getGuestsByPhone(phonenumber);
    }
}
