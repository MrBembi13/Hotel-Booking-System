package com.solvd.hotel_booking_system.service;

import com.solvd.hotel_booking_system.dao.daoClass.HotelsDAO;
import com.solvd.hotel_booking_system.model.AddressModel;
import com.solvd.hotel_booking_system.model.HotelsModel;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HotelServiceTest {

    @Test
    public void verifyFindHotelsByParameters() {
        HotelsService hotelsService = new HotelsService();
        AddressModel addressModel = new AddressModel();
        HotelsModel hotelsModel;
        HotelsDAO hotelsDAO = new HotelsDAO();
        hotelsModel = hotelsDAO.getHotelsById(1L);
        Map<String, Object> parametersMap = new HashMap<>();
        parametersMap.put("nameHotel", "hotel_name61");
        List<HotelsModel> actualList = hotelsDAO.findByParameters(parametersMap);
        Assert.assertEquals(hotelsService.findByParameters(addressModel, hotelsModel), actualList, "Method works");

    }
}
