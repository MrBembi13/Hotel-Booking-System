package com.solvd.hotel_booking_system.dao;

import com.solvd.hotel_booking_system.model.PaymentTypeModel;

import java.util.List;

public interface IPaymentTypeDAO {
    PaymentTypeModel getPaymentTypeById(Long id);

    List<PaymentTypeModel> getPaymentTypeList();

    void insertPaymentType(PaymentTypeModel entity);

    void deletePaymentType(PaymentTypeModel entity);

    void updatePaymentType(PaymentTypeModel entity);
}
