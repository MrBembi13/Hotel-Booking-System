package com.solvd.hotel_booking_system;

import com.solvd.hotel_booking_system.ui.UserInterface;
import com.solvd.hotel_booking_system.util.LoggerUtil;

import java.io.IOException;

public class Executor {

    public static void main(String[] args) throws IOException {
        LoggerUtil.LOGGER.info("Starting application...");
        UserInterface.start(args);
    }
}
