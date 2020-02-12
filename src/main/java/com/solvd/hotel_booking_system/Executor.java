package com.solvd.hotel_booking_system;

import com.solvd.hotel_booking_system.dao.daoClass.*;
import com.solvd.hotel_booking_system.model.*;
import com.solvd.hotel_booking_system.util.InfoGenerator;
import com.solvd.hotel_booking_system.util.JSONUtil;
import com.solvd.hotel_booking_system.util.LoggerUtil;

import java.io.IOException;
import java.util.List;

public class Executor {

    public static void main(String[] args) throws IOException {
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

        //parse to json by id
        /*JSONUtil<AddressModel> jsonUtil = new JSONUtil<>();
        AddressModel addressModel = new AddressDAO().getAddressById((long)2);
        jsonUtil.toJson(addressModel, "src\\main\\resources\\json\\address.json");*/

        //parse to json list
        /*JSONUtil<AddressModel> jsonUtil = new JSONUtil<>();
        List<AddressModel> addressModelList = new AddressDAO().getAddressList();
        jsonUtil.toJson(addressModelList, "src\\main\\resources\\json\\address.json");*/

        //parse from json
        JSONUtil<RoomTypesModel> jsonUtil = new JSONUtil<>();
        RoomTypesModel roomTypesModel = new RoomTypesModel();
        jsonUtil.fromJson(roomTypesModel,"src\\main\\resources\\json\\roomTypes.json");


       /* PojoToJson<PersonModel> pojoToJson1 = new PojoToJson<>();
        PersonModel customerModel = pojoToJson1.fromJson("src\\main\\resources\\json\\person.json");
        System.out.println(customerModel);
        PersonDAO customerDAO = new PersonDAO();
        customerDAO.insertPerson(customerModel);*/
    }
}
