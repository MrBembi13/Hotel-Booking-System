package com.solvd.hotel_booking_system.dao;

import com.solvd.hotel_booking_system.model.AddressModel;

import java.util.List;

public interface IAddressDAO {
    AddressModel getAddressById(Long id);

    List<AddressModel> getAddressList();

    void insertAddress(AddressModel entity);

    void deleteAddress(AddressModel entity);

    void updateAddress(AddressModel entity);
}
