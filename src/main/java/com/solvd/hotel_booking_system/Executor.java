package com.solvd.hotel_booking_system;

import com.solvd.hotel_booking_system.dao.daoClass.*;
import com.solvd.hotel_booking_system.model.*;
import com.solvd.hotel_booking_system.util.InfoGenerator;
import com.solvd.hotel_booking_system.util.LoggerUtil;

public class Executor {

    public static void main(String[] args) {
        LoggerUtil.LOGGER.info("Starting application...");

        /*GuestsModel bookingsModel;
        GuestsDAO addressDAO = new GuestsDAO();
        for (int i = 0; i < 10; i++) {
            bookingsModel = InfoGenerator.generateGuest();
            addressDAO.insertGuests(bookingsModel);
        }*/
        /*PositionDAO positionDAO = new PositionDAO();
        HotelsDAO hotelsDAO = new HotelsDAO();
        StaffDAO staffDAO = new StaffDAO();
        PositionModel positionModel;
        HotelsModel hotelsModel;
        StaffModel staffModel;
        for (int i = 1; i < 11; i++) {
            positionModel = positionDAO.getPositionById((long) i);
            hotelsModel = hotelsDAO.getHotelsById((long) i);
            staffModel = InfoGenerator.generateStaff(hotelsModel, positionModel);
            staffDAO.insertStaff(staffModel);
        }*/
    }
}
