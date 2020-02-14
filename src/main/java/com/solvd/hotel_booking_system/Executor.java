package com.solvd.hotel_booking_system;

import com.solvd.hotel_booking_system.ui.UserInterface;
import com.solvd.hotel_booking_system.util.LoggerUtil;

public class Executor {

    public static void main(String[] args) {
        LoggerUtil.LOGGER.info("Starting application...");
        UserInterface.start(args);
    }
}
