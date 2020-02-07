package com.solvd.hotel_booking_system.dao;

import com.solvd.hotel_booking_system.model.RoomTypesModel;

import java.util.List;

public interface IRoomTypesDAO {
    RoomTypesModel getRoomTypesById(Long id);

    List<RoomTypesModel> getRoomTypesList();

    void insertRoomTypes(RoomTypesModel entity);

    void deleteRoomTypes(RoomTypesModel entity);

    void updateRoomTypes(RoomTypesModel entity);
}
