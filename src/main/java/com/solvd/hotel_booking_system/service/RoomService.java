package com.solvd.hotel_booking_system.service;

import com.solvd.hotel_booking_system.dao.daoClass.RoomsDAO;
import com.solvd.hotel_booking_system.model.HotelsModel;
import com.solvd.hotel_booking_system.model.RoomTypesModel;
import com.solvd.hotel_booking_system.model.RoomsModel;

import java.util.List;

public class RoomService {

    private RoomsDAO roomsDAO = new RoomsDAO();

    public List<RoomsModel> getRoomsByParameters(RoomTypesModel roomType, HotelsModel hotel) {

        return null;
    }
}
