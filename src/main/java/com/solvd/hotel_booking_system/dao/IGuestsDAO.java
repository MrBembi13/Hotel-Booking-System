package com.solvd.hotel_booking_system.dao;

import com.solvd.hotel_booking_system.model.GuestsModel;

import java.util.List;

public interface IGuestsDAO {
    GuestsModel getGuestsById(Long id);

    GuestsModel getGuestsByPhone(String phone);

    List<GuestsModel> getGuestsList();

    boolean insertGuests(GuestsModel entity);

    boolean deleteGuests(GuestsModel entity);

    boolean updateGuests(GuestsModel entity);
}
