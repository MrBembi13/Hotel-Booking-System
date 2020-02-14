package com.solvd.hotel_booking_system.ui.commands;

import com.solvd.hotel_booking_system.dao.daoClass.AddressDAO;
import com.solvd.hotel_booking_system.model.GuestsModel;
import com.solvd.hotel_booking_system.service.GuestService;
import com.solvd.hotel_booking_system.ui.ConsoleCommand;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class LoginCommandImpl {

    private static final Logger LOGGER = LogManager.getLogger(LoginCommandImpl.class);

    public static void doCommand(String[] keys, ConsoleCommand command) {

        Scanner scanner = new Scanner(System.in);
        if (keys.length != 0) {
            LOGGER.info("No keys for login command.");
        } else {
            GuestService guestService = new GuestService();
            LOGGER.info("Enter phone number:");
            String phone = scanner.nextLine();
            GuestsModel guest = guestService.findByPhoneNumber(phone);
            if (guest == null) {
                LOGGER.info("No guest with phone number: " + phone);
            } else {
                command.setGUEST(guest);
            }
        }
    }
}
