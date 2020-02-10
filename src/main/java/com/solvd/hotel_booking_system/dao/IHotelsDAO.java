package com.solvd.hotel_booking_system.dao;

import com.solvd.hotel_booking_system.model.HotelsModel;

import java.util.List;

public interface IHotelsDAO {
    HotelsModel getHotelsById(Long id);

    List<HotelsModel> getHotelsList();

    void insertHotels(HotelsModel entity);

    void deleteHotels(HotelsModel entity);

    void updateHotels(HotelsModel entity);
}
