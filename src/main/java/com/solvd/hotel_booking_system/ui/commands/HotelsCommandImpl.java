package com.solvd.hotel_booking_system.ui.commands;

import com.solvd.hotel_booking_system.dao.daoClass.AddressDAO;
import com.solvd.hotel_booking_system.model.AddressModel;
import com.solvd.hotel_booking_system.model.HotelsModel;
import com.solvd.hotel_booking_system.model.PositionModel;
import com.solvd.hotel_booking_system.model.StaffModel;
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

    public static void doCommand(String[] keys, ConsoleCommand command, Scanner scanner) {

        if (scanner == null) {
            scanner = new Scanner(System.in);
        }

        AddressModel address = new AddressModel();
        HotelsModel hotel = null;
        HotelsModel selectedHotel;

        HotelsService hotelsService = new HotelsService();
        StaffService staffService = new StaffService();

        if (keys.length == 0) {
            LOGGER.info(hotelsService.getAllHotels());
            return;
        }

        if (isContainsKey("SELECT", keys)) {
            if (keys.length > 1)
                LOGGER.info(HotelsKeys.valueOf("SELECT") + " is a single key. Other keys will be ignored.");
            LOGGER.info("Enter hotel number:");
            selectedHotel = hotelsService.findHotelById(scanner.nextLong());
            if (selectedHotel == null) {
                LOGGER.error("No hotel with introduced number.");
            } else {
                command.setHOTEL(selectedHotel);
                LOGGER.info("Selected hotel: " + command.getHOTEL());
            }
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

        if (isContainsKey("STAFF", keys) && command.getHOTEL() != null) {

            Map<StaffModel, PositionModel> staffModels = staffService.getAllHotelsStaff(command.getHOTEL());
            if (staffModels != null) {
                LOGGER.info(staffModels);
            } else {
                LOGGER.info("No staff in hotel.");
            }

        } else if (isContainsKey("STAFF", keys) && command.getHOTEL() == null) {
            LOGGER.info("No selected hotel. Try \"hotels -select\"");
        }

        if (hotel != null) LOGGER.info(hotelsService.findByParameters(address, hotel));
    }
    public static boolean isContainsKey(String keyName, String[] keys) {
        return Arrays.asList(keys).contains(HotelsKeys.valueOf(keyName).key);
    }
}
