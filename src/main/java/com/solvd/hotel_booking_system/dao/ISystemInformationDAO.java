package com.solvd.hotel_booking_system.dao;

import java.sql.Date;

public interface ISystemInformationDAO {

    public Date getCurrentDate();

    public Long getActualInsertId(String tableName);
}
