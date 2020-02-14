package com.solvd.hotel_booking_system.service;

import com.solvd.hotel_booking_system.dao.daoClass.BookingsDAO;
import com.solvd.hotel_booking_system.dao.daoClass.GuestsDAO;
import com.solvd.hotel_booking_system.dao.daoClass.PaymentsDAO;
import com.solvd.hotel_booking_system.dao.daoClass.RoomsDAO;
import com.solvd.hotel_booking_system.model.*;
import com.solvd.hotel_booking_system.util.LoggerUtil;

import java.util.*;

public class BookingService {

    private Queue<BookingsModel> bookingsModelDeque = new LinkedList<>();

    private BookingsDAO bookingsDAO = new BookingsDAO();
    private RoomsDAO roomsDAO = new RoomsDAO();

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
            List<RoomsModel> freeRooms = roomsDAO.getFreeRoomsForHotel(hotel, roomType);
            booking.setRooms_id(freeRooms.get(0).getIdRooms());
            if (addBookingToDeque(booking)) {
                return booking;
            } else {
                return null;
            }
        }
    }

    public List<BookingsModel> getAllBookingsForUser(GuestsModel guest) {
        return bookingsDAO.findByParameters(guest);
    }

    public List<BookingsModel> getBookingsByParameters(BookingsModel booking, GuestsModel guest) {
        return bookingsDAO.findByParameters(booking.getDateFrom(), booking.getDateTo(), guest);
    }

    private boolean addBookingToDeque(BookingsModel booking) {
        boolean status = bookingsModelDeque.offer(booking);
        Iterator<BookingsModel> iterator = bookingsModelDeque.iterator();
        try {
            while (iterator.hasNext()) {
                bookingsDAO.insertBookings(iterator.next());
                iterator.remove();
            }
        } catch (NoSuchElementException e) {
            LoggerUtil.LOGGER.error(e.getMessage());
        }
        return status;
    }

}
