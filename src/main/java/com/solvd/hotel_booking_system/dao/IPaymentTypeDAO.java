package com.solvd.hotel_booking_system.dao;

import com.solvd.hotel_booking_system.model.PaymentTypeModel;

import java.util.List;

public interface IPaymentTypeDAO {
    PaymentTypeModel getPaymentTypeById(Long id);

    List<PaymentTypeModel> getPaymentTypeList();

    boolean insertPaymentType(PaymentTypeModel entity);

    boolean deletePaymentType(PaymentTypeModel entity);

    boolean updatePaymentType(PaymentTypeModel entity);
}
