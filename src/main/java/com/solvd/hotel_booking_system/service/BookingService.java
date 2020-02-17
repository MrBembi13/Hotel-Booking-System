package com.solvd.hotel_booking_system.service;

import com.solvd.hotel_booking_system.dao.ISystemInformationDAO;
import com.solvd.hotel_booking_system.dao.daoClass.BookingsDAO;
import com.solvd.hotel_booking_system.dao.daoClass.RoomsDAO;
import com.solvd.hotel_booking_system.dao.daoClass.SystemInformationDAO;
import com.solvd.hotel_booking_system.model.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Date;
import java.util.*;

public class BookingService {

    private static final Logger LOGGER = LogManager.getLogger(BookingService.class);

    private BookingsDAO bookingsDAO = new BookingsDAO();
    private RoomsDAO roomsDAO = new RoomsDAO();
    private ISystemInformationDAO systemInformationDAO = new SystemInformationDAO();

    public List<BookingsModel> getAllBookings() {
        return bookingsDAO.getBookingsList();
    }

    public BookingsModel getBookingById(Long id) {
        return bookingsDAO.getBookingsById(id);
    }

    public BookingsModel saveBooking(BookingsModel booking, HotelsModel hotel,
                                     RoomTypesModel roomType, GuestsModel guest) {
        if (booking.getDateFrom().compareTo(booking.getDateTo()) >= 0) {
            return null;
        } else {
            booking.setGuests_id(guest.getIdGuests());
            booking.setHotels_id(hotel.getIdHotels());
            booking.setStatus("booked");

            Date currentDate = systemInformationDAO.getCurrentDate();

            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put("hotels_id", hotel.getIdHotels());
            paramMap.put("roomType", roomType.getRoomType());
            paramMap.put("currentDate", currentDate);

            List<RoomsModel> freeRooms = roomsDAO.getFreeRoomsForHotel(paramMap);
            booking.setRooms_id(freeRooms.get(0).getIdRooms());

            if (persistBooking(booking)) {
                return booking;
            } else {
                return null;
            }
        }
    }

    public List<BookingsModel> getAllBookingsForUser(GuestsModel guest) {
        Map<String, Object> parametersMap = new HashMap<>();
        parametersMap.put("guests_id", guest.getIdGuests());
        return bookingsDAO.findByParameters(parametersMap);
    }

    public List<BookingsModel> getBookingsByParameters(BookingsModel booking, GuestsModel guest) {
        Map<String, Object> parametersMap = new HashMap<>();
        parametersMap.put("dateFrom", booking.getDateFrom());
        parametersMap.put("dateTo", booking.getDateTo());
        parametersMap.put("guest_id", guest.getIdGuests());
        return bookingsDAO.findByParameters(parametersMap);
    }

    private boolean persistBooking(BookingsModel booking) {
        return bookingsDAO.insertBookings(booking);
    }

}
