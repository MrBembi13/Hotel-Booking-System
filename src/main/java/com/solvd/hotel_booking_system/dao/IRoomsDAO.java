package com.solvd.hotel_booking_system.dao;

import com.solvd.hotel_booking_system.model.HotelsModel;
import com.solvd.hotel_booking_system.model.RoomTypesModel;
import com.solvd.hotel_booking_system.model.RoomsModel;

import java.util.List;
import java.util.Map;

public interface IRoomsDAO {
    RoomsModel getRoomsById(Long id);

    List<RoomsModel> getRoomsList();

    List<RoomsModel> getFreeRoomsForHotel(Map<String, Object> map);

    boolean insertRooms(RoomsModel entity);

    boolean deleteRooms(RoomsModel entity);

    boolean updateRooms(RoomsModel entity);
}
