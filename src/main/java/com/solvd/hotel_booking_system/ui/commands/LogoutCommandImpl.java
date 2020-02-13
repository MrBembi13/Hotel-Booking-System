package com.solvd.hotel_booking_system.ui.commands;

import com.solvd.hotel_booking_system.ui.ConsoleCommand;

public class LogoutCommandImpl {

    public static void doCommand(String[] keys, ConsoleCommand command) {
        if (keys.length != 0) {
            System.out.println("No keys for login command.");
        } else {
            command.setGUEST(null);
        }
    }
}
