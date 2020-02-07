package com.solvd.hotel_booking_system.dao;

import com.solvd.hotel_booking_system.model.PositionModel;

import java.util.List;

public interface IPositionDAO {
    PositionModel getPositionById(Long id);

    List<PositionModel> getPositionList();

    void insertPosition(PositionModel entity);

    void deletePosition(PositionModel entity);

    void updatePosition(PositionModel entity);
}
