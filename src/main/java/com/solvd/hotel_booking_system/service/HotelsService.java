package com.solvd.hotel_booking_system.service;

import com.solvd.hotel_booking_system.dao.IAddressDAO;
import com.solvd.hotel_booking_system.dao.IHotelsDAO;
import com.solvd.hotel_booking_system.dao.IRoomTypesDAO;
import com.solvd.hotel_booking_system.dao.daoClass.AddressDAO;
import com.solvd.hotel_booking_system.dao.daoClass.HotelsDAO;
import com.solvd.hotel_booking_system.dao.daoClass.RoomTypesDAO;
import com.solvd.hotel_booking_system.model.*;

import java.util.List;
import java.util.Map;

public class HotelsService {

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

    public List<HotelsModel> findByParameters(AddressModel address,
                                              RoomTypesModel roomType, HotelsModel hotel) {//IF STATEMENT IN MAPPERS
        if(address == null) {
            //return hotelsDAO.getByParameters(String city...)
             /*return hotelsDAO.find() {
            select hotels
            join roomType on Room_types.room_type = #{roomType}
            <if address != null>

            </if>
            join address on address.city = #{address.city}
            where hotels.name = #{hotel.name}}*/
        } else {
            //return hotelsDAO.getByParameters(Address address...)
        }
        return null;
    }
}
