package com.solvd.hotel_booking_system.dao;

import com.solvd.hotel_booking_system.model.RoomTypesModel;

import java.util.List;

public interface IRoomTypesDAO {
    RoomTypesModel getRoomTypesById(Long id);

    List<RoomTypesModel> getRoomTypesList();

    boolean insertRoomTypes(RoomTypesModel entity);

    boolean deleteRoomTypes(RoomTypesModel entity);

    boolean updateRoomTypes(RoomTypesModel entity);
}
