package com.solvd.hotel_booking_system.dao;

import com.solvd.hotel_booking_system.model.AddressModel;

import java.util.List;

public interface IAddressDAO {
    AddressModel getAddressById(Long id);

    List<AddressModel> getAddressList();

    boolean insertAddress(AddressModel entity);

    boolean deleteAddress(AddressModel entity);

    boolean updateAddress(AddressModel entity);
}
