package com.solvd.hotel_booking_system.ui.commands;

import com.solvd.hotel_booking_system.model.BookingsModel;
import com.solvd.hotel_booking_system.model.RoomTypesModel;
import com.solvd.hotel_booking_system.service.BookingService;
import com.solvd.hotel_booking_system.ui.ConsoleCommand;
import com.solvd.hotel_booking_system.ui.keys.BookingKeys;
import com.solvd.hotel_booking_system.ui.keys.HotelsKeys;

import java.sql.Date;
import java.util.Arrays;
import java.util.Scanner;

public class BookingsCommandImpl {

    public static void doCommand(String[] keys, ConsoleCommand command) {
        Scanner scanner = new Scanner(System.in);
        BookingService bookingService = new BookingService();

        BookingsModel booking = new BookingsModel();
        RoomTypesModel roomType = new RoomTypesModel();

        if (isContainsKey("NEW", keys)) {
            if (command.getHOTEL() == null) {
                System.out.println("No selected hotel.");
            } else {
                System.out.println("Enter date from:");
                try {
                    booking.setDateFrom(Date.valueOf(scanner.nextLine()));
                } catch (Exception e) {
                    System.out.println("Invaid date");
                    return;
                }
                System.out.println("Enter date to:");
                try {
                    booking.setDateFrom(Date.valueOf(scanner.nextLine()));
                } catch (Exception e) {
                    System.out.println("Invaid date");
                    return;
                }
                System.out.println("Enter room type:");
                roomType.setRoomType(scanner.nextLine());
                bookingService.saveBooking(booking, roomType);
                return;
            }
        }
        if (keys.length == 0) {
            bookingService.getAllBookingsForUser(command.getGUEST());
            return;
        }
        if (isContainsKey("DATE_TO", keys)) {
            System.out.println("Enter date to:");
            try {
                booking.setDateTo(Date.valueOf(scanner.nextLine()));
            } catch (Exception e) {
                System.out.println("Invalid date.");
                return;
            }
        }
        if (isContainsKey("DATE_FROM", keys)) {
            System.out.println("Enter date from:");
            try {
                booking.setDateFrom(Date.valueOf(scanner.nextLine()));
            } catch (Exception e) {
                System.out.println("Invalid date.");
                return;
            }
        }
        if (isContainsKey("STATUS", keys)) {
            System.out.println("Enter status:");
            booking.setStatus(scanner.nextLine());
        }
        bookingService.getBookingsByParameters(booking);
    }

    public static boolean isContainsKey(String keyName, String[] keys) {
        return Arrays.asList(keys).contains(BookingKeys.valueOf(keyName).key);
    }
}
