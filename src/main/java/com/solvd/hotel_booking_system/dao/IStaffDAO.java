package com.solvd.hotel_booking_system.dao;

import com.solvd.hotel_booking_system.model.StaffModel;

import java.util.List;

public interface IStaffDAO {
    StaffModel getStaffById(Long id);

    List<StaffModel> getStaffList();

    void insertStaff(StaffModel entity);

    void deleteStaff(StaffModel entity);

    void updateStaff(StaffModel entity);
}
