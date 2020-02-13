package com.solvd.hotel_booking_system.dao;

import com.solvd.hotel_booking_system.model.BookingsModel;

import java.util.List;
import java.util.Map;

public interface IBookingsDAO {
    BookingsModel getBookingsById(Long id);

    List<BookingsModel> getBookingsList();

    List<BookingsModel> findByParameters(Map<String, Object> map);

    void insertBookings(BookingsModel entity);

    void deleteBookings(BookingsModel entity);

    void updateBookings(BookingsModel entity);
}
