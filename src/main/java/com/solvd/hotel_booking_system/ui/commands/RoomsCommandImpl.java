package com.solvd.hotel_booking_system.ui.commands;

import com.solvd.hotel_booking_system.model.RoomTypesModel;
import com.solvd.hotel_booking_system.service.RoomService;
import com.solvd.hotel_booking_system.ui.ConsoleCommand;
import com.solvd.hotel_booking_system.ui.keys.RoomKeys;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.Scanner;

public class RoomsCommandImpl {

    private static final Logger LOGGER = LogManager.getLogger(RoomsCommandImpl.class);

    public static void doCommand(String[] keys, ConsoleCommand command) {

        Scanner scanner = new Scanner(System.in);
        RoomService roomService = new RoomService();

        RoomTypesModel roomType = new RoomTypesModel();

        if(command.getHOTEL() == null) {
            LOGGER.info("Hotel not selected. Please select hotel.");
            return;
        }

        if (isContainsKey("TYPE", keys)) {
            LOGGER.info("Enter room type:");
            roomType.setRoomType(scanner.nextLine());
        } else if (isContainsKey("PRICE", keys)) {
            LOGGER.info("Enter price:");
            try {
                roomType.setPriceForNight(scanner.nextInt());
            } catch (IllegalArgumentException e) {
                LOGGER.error(e.getMessage());
                LOGGER.info("Incorrect price.");
            }
        }
        LOGGER.info(roomService.getRoomsByParameters(roomType, command.getHOTEL()));
    }

    public static boolean isContainsKey(String keyName, String[] keys) {
        return Arrays.asList(keys).contains(RoomKeys.valueOf(keyName).key);
    }
}
