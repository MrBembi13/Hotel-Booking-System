package com.solvd.hotel_booking_system.ui.commands;

import com.solvd.hotel_booking_system.model.RoomTypesModel;
import com.solvd.hotel_booking_system.service.RoomService;
import com.solvd.hotel_booking_system.ui.ConsoleCommand;
import com.solvd.hotel_booking_system.ui.keys.HotelsKeys;
import com.solvd.hotel_booking_system.ui.keys.RoomKeys;
import com.solvd.hotel_booking_system.util.LoggerUtil;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class RoomsCommandImpl {

    public static void doCommand(String[] keys, ConsoleCommand command) {

        Scanner scanner = new Scanner(System.in);
        RoomService roomService = new RoomService();

        RoomTypesModel roomType = new RoomTypesModel();

        if(command.getHOTEL() == null) {
            System.out.println("Hotel not selected. Please select hotel.");
            return;
        }

        if (isContainsKey("TYPE", keys)) {
            System.out.println("Enter room type:");
            roomType.setRoomType(scanner.nextLine());
        }
        if (isContainsKey("PRICE", keys)) {
            System.out.println("Enter price:");
            try {
                roomType.setPriceForNight(scanner.nextInt());
            } catch (Exception e) {
                LoggerUtil.LOGGER.error(e.getMessage());
                System.out.println("Incorrect price.");
            }
        }
        System.out.println(roomService.getRoomsByParameters(roomType, command.getHOTEL()));
    }

    public static boolean isContainsKey(String keyName, String[] keys) {
        return Arrays.asList(keys).contains(RoomKeys.valueOf(keyName).key);
    }
}
