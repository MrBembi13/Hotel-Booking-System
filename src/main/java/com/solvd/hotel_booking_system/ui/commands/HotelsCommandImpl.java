package com.solvd.hotel_booking_system.ui.commands;

import com.solvd.hotel_booking_system.model.*;
import com.solvd.hotel_booking_system.service.HotelsService;
import com.solvd.hotel_booking_system.service.StaffService;
import com.solvd.hotel_booking_system.ui.ConsoleCommand;
import com.solvd.hotel_booking_system.ui.keys.HotelsKeys;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

public class HotelsCommandImpl {

    public static void doCommand(String[] keys, ConsoleCommand command) {

        Scanner scanner = new Scanner(System.in);

        AddressModel address = new AddressModel();
        HotelsModel hotel = null;
        HotelsModel selectedHotel = null;
        RoomTypesModel roomType = null;

        HotelsService hotelsService = new HotelsService();
        StaffService staffService = new StaffService();

        if (keys.length == 0) {
            System.out.println(hotelsService.getAllHotels());
        }
        if (isContainsKey("CITY", keys)) {
            System.out.println("Enter city:");
            address.setCity(scanner.nextLine());
        }
        if (isContainsKey("STREET", keys)) {
            System.out.println("Enter street:");
            address.setStreet(scanner.nextLine());
        }
        if (isContainsKey("NAME", keys)) {
            System.out.println("Enter name:");
            hotel = new HotelsModel();
            hotel.setNameHotel(scanner.nextLine());
        }
        if (isContainsKey("ROOM_TYPE", keys)) {
            System.out.println("Enter room type:");
            roomType = new RoomTypesModel();
            roomType.setRoomType(scanner.nextLine());
        }
        if (isContainsKey("SELECT", keys) && isContainsKey("STAFF", keys)) {
            System.out.println("Enter hotel number:");
            selectedHotel = hotelsService.findHotelById(scanner.nextLong());
            command.setHOTEL(selectedHotel);
            System.out.println(selectedHotel);
        }
        if (isContainsKey("STAFF", keys) && selectedHotel != null) {
            Map<StaffModel, PositionModel > staffModels = staffService.getAllHotelsStaff(selectedHotel);
            if (staffModels != null) {
                System.out.println(staffModels);
            } else {
                System.out.println("No staff in hotel.");
            }
        } else {
            System.out.println("No selected hotel. Try \"hotels -select\"");
        }
        System.out.println(hotelsService.findByParameters(address, roomType, hotel));
    }
    public static boolean isContainsKey(String keyName, String[] keys) {
        return Arrays.asList(keys).contains(HotelsKeys.valueOf(keyName).key);
    }
}
