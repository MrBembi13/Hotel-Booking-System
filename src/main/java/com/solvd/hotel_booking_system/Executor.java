package com.solvd.hotel_booking_system;

import com.solvd.hotel_booking_system.ui.UserInterface;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Executor {

    private static final Logger LOGGER = LogManager.getLogger(Executor.class);

    public static void main(String[] args) {
        LOGGER.info("Starting application...");
        UserInterface.start(args);
    }
}
