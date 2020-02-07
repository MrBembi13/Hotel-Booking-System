package com.solvd.hotel_booking_system.dao;

import com.solvd.hotel_booking_system.model.RoomsModel;

import java.util.List;

public interface IRoomsDAO {
    RoomsModel getRoomsById(Long id);

    List<RoomsModel> getRoomsList();

    void insertRooms(RoomsModel entity);

    void deleteRooms(RoomsModel entity);

    void updateRooms(RoomsModel entity);
}
