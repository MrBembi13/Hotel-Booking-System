package com.solvd.hotel_booking_system.dao;

import com.solvd.hotel_booking_system.model.StaffModel;

import java.util.List;

public interface IStaffDAO {
    StaffModel getStaffById(Long id);

    List<StaffModel> getAllStaffForHotel(Long hotels_id);

    List<StaffModel> getStaffList();

    boolean insertStaff(StaffModel entity);

    boolean deleteStaff(StaffModel entity);

    boolean updateStaff(StaffModel entity);
}
