package com.solvd.hotel_booking_system.dao;

import com.solvd.hotel_booking_system.model.PaymentsModel;

import java.util.List;

public interface IPaymentsDAO {
    PaymentsModel getPaymentsById(Long id);

    List<PaymentsModel> getPaymentsList();

    void insertPayments(PaymentsModel entity);

    void deletePayments(PaymentsModel entity);

    void updatePayments(PaymentsModel entity);
}
