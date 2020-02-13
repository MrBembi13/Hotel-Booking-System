package com.solvd.hotel_booking_system;

import com.solvd.hotel_booking_system.dao.daoClass.*;
import com.solvd.hotel_booking_system.model.*;
import com.solvd.hotel_booking_system.util.InfoGenerator;
import com.solvd.hotel_booking_system.util.JSONUtil;
import com.solvd.hotel_booking_system.util.LoggerUtil;

import java.util.*;

public class Executor {

    public static void main(String[] args) {
        LoggerUtil.LOGGER.info("Starting application...");

        //parse to json by id
        /*JSONUtil<AddressModel> jsonUtil = new JSONUtil<>();
        AddressModel addressModel = new AddressDAO().getAddressById((long)2);
        jsonUtil.toJson(addressModel, "src\\main\\resources\\json\\address.json");*/

        //parse to json list
        /*JSONUtil<AddressModel> jsonUtil = new JSONUtil<>();
        List<AddressModel> addressModelList = new AddressDAO().getAddressList();
        jsonUtil.toJson(addressModelList, "src\\main\\resources\\json\\address.json");*/

        //parse from json
        /*JSONUtil<RoomTypesModel> jsonUtil = new JSONUtil<>();
        RoomTypesModel roomTypesModel = jsonUtil.fromJson(RoomTypesModel.class, "src\\main\\resources\\json\\roomTypes.json");
        RoomTypesDAO roomTypesDAO = new RoomTypesDAO();
        roomTypesDAO.insertRoomTypes(roomTypesModel);*/

        //parse from json list
        /*JSONUtil<PaymentTypeModel> jsonUtil = new JSONUtil<>();
        List<PaymentTypeModel> paymentTypeModelList = jsonUtil.fromJsonFile(PaymentTypeModel[].class, "src\\main\\resources\\json\\PaymentType.json");
        PaymentTypeDAO paymentTypeDAO = new PaymentTypeDAO();
        for (PaymentTypeModel e: paymentTypeModelList) {
            paymentTypeDAO.insertPaymentType(e);
        }*/

        //HotelAddressModel hotelAddressModel = new HotelAddressModel();
        Map<String, Object> map = new HashMap<>();
        map.put("nameHotel", "hotel_name97");
        map.put("city", "city55");
        HotelsDAO hotelsDAO = new HotelsDAO();
        List<HotelsModel> hotelAddressModel = hotelsDAO.findByParameter(map);
        System.out.println(hotelAddressModel);
    }
}
