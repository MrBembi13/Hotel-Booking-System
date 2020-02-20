package com.solvd.hotel_booking_system.service;

import com.solvd.hotel_booking_system.dao.daoClass.BookingsDAO;
import com.solvd.hotel_booking_system.dao.daoClass.SystemInformationDAO;
import com.solvd.hotel_booking_system.model.BookingsModel;
import com.solvd.hotel_booking_system.model.GuestsModel;
import com.solvd.hotel_booking_system.model.HotelsModel;
import com.solvd.hotel_booking_system.model.RoomTypesModel;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookingServiceTest {

    private BookingService bookingService;
    private BookingsModel booking;
    private HotelsModel hotel;
    private RoomTypesModel roomType;
    private GuestsModel guest;
    private BookingsDAO bookingsDAO;
    private SystemInformationDAO systemInformationDAO;


    @BeforeMethod
    public void init() {
        systemInformationDAO = new SystemInformationDAO();
    }

    @Test
    public void testWrongBookingDateSaveTest() {
        booking = new BookingsModel();
        bookingService = new BookingService();
        hotel = new HotelsModel();
        roomType = new RoomTypesModel();
        guest = new GuestsModel();
        Date wrongDateTo = Date.valueOf("2020-12-20");
        Date wrongDateFrom = Date.valueOf("2020-12-25");
        booking.setDateTo(wrongDateTo);
        booking.setDateFrom(wrongDateFrom);
        Assert.assertNull(bookingService.saveBooking(booking, hotel, roomType, guest));
    }

    @Test(enabled = false)
    public void testSuccessfullyBookingSaveTest() {
        booking = new BookingsModel();
        bookingService = new BookingService();
        hotel = new HotelsModel();
        roomType = new RoomTypesModel();
        guest = new GuestsModel();

        Date dateTo = Date.valueOf("2021-01-25");
        Date dateFrom = Date.valueOf("2021-01-20");

        hotel.setIdHotels(3L);
        guest.setIdGuests(2L);
        roomType.setRoomType("room_type12");

        booking.setDateTo(dateTo);
        booking.setDateFrom(dateFrom);

        Assert.assertNotNull(bookingService.saveBooking(booking, hotel, roomType, guest));
    }

    @Test
    public void testSuccessfullyGetAllBookingsForUser() {
        guest = new GuestsModel();
        guest.setIdGuests(1L);
        bookingService = new BookingService();
        bookingsDAO = new BookingsDAO();

        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("guests_id", guest.getIdGuests());
        List<BookingsModel> actualBookings = bookingsDAO.findByParameters(paramMap);
        Assert.assertEquals(bookingService.getAllBookingsForUser(guest), actualBookings);
    }

    @Test
    public void testWrongGetAllBookingForUser() {
        bookingService = new BookingService();
        guest = new GuestsModel();
        bookingsDAO = new BookingsDAO();

        guest.setIdGuests(systemInformationDAO.getActualInsertId("Guests") + 1);

        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("guests_id", guest.getIdGuests());
        List<BookingsModel> actualBookings = bookingsDAO.findByParameters(paramMap);
        Assert.assertEquals(actualBookings, bookingService.getAllBookingsForUser(guest));
    }
}
