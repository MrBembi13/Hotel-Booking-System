package com.solvd.hotel_booking_system.service;

import com.solvd.hotel_booking_system.dao.daoClass.PositionDAO;
import com.solvd.hotel_booking_system.dao.daoClass.StaffDAO;
import com.solvd.hotel_booking_system.model.HotelsModel;
import com.solvd.hotel_booking_system.model.PositionModel;
import com.solvd.hotel_booking_system.model.StaffModel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StaffService {

    public Map<StaffModel, PositionModel> getAllHotelsStaff(HotelsModel hotel) {

        StaffDAO staffDAO = new StaffDAO();
        PositionDAO positionDAO = new PositionDAO();
        List<StaffModel> staffModels = staffDAO.getAllStaffForHotel(hotel.getIdHotels());
        Map<StaffModel, PositionModel> mapStaff = new HashMap<>();
        for(StaffModel staff: staffModels) {
            mapStaff.put(staff, positionDAO.getPositionById(staff.getPosition_id()));
        }
        return mapStaff;
    }
}
