package com.solvd.hotel_booking_system.ui.commands;

import com.solvd.hotel_booking_system.dao.daoClass.AddressDAO;
import com.solvd.hotel_booking_system.ui.ConsoleCommand;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogoutCommandImpl {

    private static final Logger LOGGER = LogManager.getLogger(LogoutCommandImpl.class);

    public static void doCommand(String[] keys, ConsoleCommand command) {
        if (keys.length != 0) {
            LOGGER.info("No keys for login command.");
        } else {
            command.setGUEST(null);
            command.setHOTEL(null);
        }
    }
}
