package com.solvd.hotel_booking_system.ui.commands;

import com.solvd.hotel_booking_system.model.GuestsModel;
import com.solvd.hotel_booking_system.service.GuestService;
import com.solvd.hotel_booking_system.ui.ConsoleCommand;

import java.util.Scanner;

public class LoginCommandImpl {

    public static void doCommand(String[] keys, ConsoleCommand command) {

        Scanner scanner = new Scanner(System.in);
        if (keys.length != 0) {
            System.out.println("No keys for login command.");
        } else {
            GuestService guestService = new GuestService();
            String phone = scanner.nextLine();
            GuestsModel guest = guestService.findByPhoneNumber(phone);
            if (guest == null) {
                System.out.println("No guest with phone number: " + phone);
            } else {
                command.setGUEST(guest);
            }
        }
    }
}
