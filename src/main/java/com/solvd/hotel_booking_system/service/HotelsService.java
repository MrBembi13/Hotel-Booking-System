package com.solvd.hotel_booking_system.service;

import com.solvd.hotel_booking_system.dao.IAddressDAO;
import com.solvd.hotel_booking_system.dao.IHotelsDAO;
import com.solvd.hotel_booking_system.dao.IRoomTypesDAO;
import com.solvd.hotel_booking_system.dao.daoClass.AddressDAO;
import com.solvd.hotel_booking_system.dao.daoClass.HotelsDAO;
import com.solvd.hotel_booking_system.dao.daoClass.RoomTypesDAO;
import com.solvd.hotel_booking_system.model.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HotelsService {

    private static final Logger LOGGER = LogManager.getLogger(HotelsService.class);

    private IAddressDAO addressDAO = new AddressDAO();
    private IHotelsDAO hotelsDAO = new HotelsDAO();
    private IRoomTypesDAO roomTypesDAO = new RoomTypesDAO();

    public HotelsModel findHotelById(Long id) {
        return hotelsDAO.getHotelsById(id);
    }

    public List<HotelsModel> getAllHotels() {
        return hotelsDAO.getHotelsList();
    }

    public List<HotelsModel> getByParameters(Map<String, String> keys) {
        return null;
    }

    public boolean insertHotel(HotelsModel hotel, AddressModel address) { //AddressModel = SELECT LAST_INSERT_ID();
        return false;
    }

    public List<HotelsModel> findByParameters(AddressModel address, HotelsModel hotel) {
        Map<String, Object> map = new HashMap<>();
        map.put("street", address.getStreet());
        map.put("city", address.getCity());
        map.put("nameHotel", hotel.getNameHotel());
        return hotelsDAO.findByParameters(map);
    }
}
