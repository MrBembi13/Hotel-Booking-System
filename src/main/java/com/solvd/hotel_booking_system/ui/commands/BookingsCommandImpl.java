package com.solvd.hotel_booking_system.ui.commands;

import com.solvd.hotel_booking_system.dao.daoClass.AddressDAO;
import com.solvd.hotel_booking_system.model.BookingsModel;
import com.solvd.hotel_booking_system.model.RoomTypesModel;
import com.solvd.hotel_booking_system.service.BookingService;
import com.solvd.hotel_booking_system.ui.ConsoleCommand;
import com.solvd.hotel_booking_system.ui.keys.BookingKeys;
import com.solvd.hotel_booking_system.ui.keys.HotelsKeys;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Date;
import java.util.Arrays;
import java.util.Scanner;

public class BookingsCommandImpl {

    private static final Logger LOGGER = LogManager.getLogger(BookingsCommandImpl.class);

    public static void doCommand(String[] keys, ConsoleCommand command) {

        Scanner scanner = new Scanner(System.in);
        BookingService bookingService = new BookingService();

        BookingsModel booking = new BookingsModel();
        RoomTypesModel roomType = new RoomTypesModel();

        if (isContainsKey("NEW", keys)) {
            if (command.getHOTEL() == null || command.getGUEST() == null) {
                LOGGER.info("No selected hotel or you're not logged.");
            } else {
                LOGGER.info("Enter date from:");
                try {
                    booking.setDateFrom(Date.valueOf(scanner.nextLine()));
                } catch (IllegalArgumentException e) {

                    LOGGER.info("Invaid date");
                    return;
                }
                LOGGER.info("Enter date to:");
                try {
                    booking.setDateTo(Date.valueOf(scanner.nextLine()));
                } catch (IllegalArgumentException e) {
                    LOGGER.info("Invaid date");
                    return;
                }
                LOGGER.info("Enter room type:");
                roomType.setRoomType(scanner.nextLine());
                BookingsModel persistedBooking = bookingService
                        .saveBooking(booking, command.getHOTEL(), roomType, command.getGUEST());
                if (persistedBooking == null) {
                    LOGGER.error("Booking wasn't saved.");
                } else {
                    LOGGER.info("Booking " + booking + "was successfully saved.");
                }
            }
            return;
        }
        if (keys.length == 0) {
            LOGGER.info(bookingService.getAllBookingsForUser(command.getGUEST()));
            return;
        }
        if (isContainsKey("DATE_TO", keys)) {
            LOGGER.info("Enter date to:");
            try {
                booking.setDateTo(Date.valueOf(scanner.nextLine()));
            } catch (IllegalArgumentException e) {
                LOGGER.info("Invalid date.");
                return;
            }
        }
        if (isContainsKey("DATE_FROM", keys)) {
            LOGGER.info("Enter date from:");
            try {
                booking.setDateFrom(Date.valueOf(scanner.nextLine()));
            } catch (IllegalArgumentException e) {
                LOGGER.info("Invalid date.");
                return;
            }
        }
        if (isContainsKey("STATUS", keys)) {
            LOGGER.info("Enter status:");
            booking.setStatus(scanner.nextLine());
        }
        LOGGER.info(bookingService.getBookingsByParameters(booking, command.getGUEST()));
    }

    public static boolean isContainsKey(String keyName, String[] keys) {
        return Arrays.asList(keys).contains(BookingKeys.valueOf(keyName).key);
    }
}
