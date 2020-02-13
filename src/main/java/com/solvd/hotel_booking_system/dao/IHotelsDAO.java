package com.solvd.hotel_booking_system.dao;

import com.solvd.hotel_booking_system.model.HotelsModel;

import java.util.List;
import java.util.Map;

public interface IHotelsDAO {
    HotelsModel getHotelsById(Long id);

    List<HotelsModel> getHotelsList();

    List<HotelsModel> findByParameters(Map<String, Object> map);

    void insertHotels(HotelsModel entity);

    void deleteHotels(HotelsModel entity);

    void updateHotels(HotelsModel entity);
}
