package com.solvd.hotel_booking_system.dao;

import com.solvd.hotel_booking_system.model.GuestsModel;

import java.util.List;

public interface IGuestsDAO {
    GuestsModel getGuestsById(Long id);

    List<GuestsModel> getGuestsList();

    void insertGuests(GuestsModel entity);

    void deleteGuests(GuestsModel entity);

    void updateGuests(GuestsModel entity);
}
