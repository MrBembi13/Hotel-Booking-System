package com.solvd.hotel_booking_system.dao;

import com.solvd.hotel_booking_system.model.PositionModel;

import java.util.List;

public interface IPositionDAO {
    PositionModel getPositionById(Long id);

    List<PositionModel> getPositionList();

    boolean insertPosition(PositionModel entity);

    boolean deletePosition(PositionModel entity);

    boolean updatePosition(PositionModel entity);
}
