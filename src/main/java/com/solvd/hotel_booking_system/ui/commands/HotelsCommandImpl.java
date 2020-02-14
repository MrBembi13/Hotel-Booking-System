package com.solvd.hotel_booking_system.ui.commands;

import com.solvd.hotel_booking_system.dao.daoClass.AddressDAO;
import com.solvd.hotel_booking_system.model.*;
import com.solvd.hotel_booking_system.service.HotelsService;
import com.solvd.hotel_booking_system.service.StaffService;
import com.solvd.hotel_booking_system.ui.ConsoleCommand;
import com.solvd.hotel_booking_system.ui.keys.HotelsKeys;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

public class HotelsCommandImpl {

    private static final Logger LOGGER = LogManager.getLogger(AddressDAO.class);

    public static void doCommand(String[] keys, ConsoleCommand command) {

        Scanner scanner = new Scanner(System.in);

        AddressModel address = new AddressModel();
        HotelsModel hotel = null;
        HotelsModel selectedHotel = null;
        RoomTypesModel roomType = null;

        HotelsService hotelsService = new HotelsService();
        StaffService staffService = new StaffService();

        if (keys.length == 0) {
            LOGGER.info(hotelsService.getAllHotels());
            return;
        }
        if (isContainsKey("CITY", keys)) {
            LOGGER.info("Enter city:");
            address.setCity(scanner.nextLine());
        }
        if (isContainsKey("STREET", keys)) {
            LOGGER.info("Enter street:");
            address.setStreet(scanner.nextLine());
        }
        if (isContainsKey("NAME", keys)) {
            LOGGER.info("Enter name:");
            hotel = new HotelsModel();
            hotel.setNameHotel(scanner.nextLine());
        }
        if (isContainsKey("SELECT", keys)) {
            LOGGER.info("Enter hotel number:");
            selectedHotel = hotelsService.findHotelById(scanner.nextLong());
            command.setHOTEL(selectedHotel);
            LOGGER.info(selectedHotel);
        }
        if (isContainsKey("STAFF", keys) && selectedHotel != null) {
            Map<StaffModel, PositionModel > staffModels = staffService.getAllHotelsStaff(selectedHotel);
            if (staffModels != null) {
                LOGGER.info(staffModels);
            } else {
                LOGGER.info("No staff in hotel.");
            }
        } else if (!isContainsKey("STAFF", keys)) {
            LOGGER.info("No selected hotel. Try \"hotels -select\"");
        }
        LOGGER.info(hotelsService.findByParameters(address, hotel));
    }
    public static boolean isContainsKey(String keyName, String[] keys) {
        return Arrays.asList(keys).contains(HotelsKeys.valueOf(keyName).key);
    }
}
