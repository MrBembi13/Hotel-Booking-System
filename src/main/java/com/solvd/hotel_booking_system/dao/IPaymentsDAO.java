package com.solvd.hotel_booking_system.dao;

import com.solvd.hotel_booking_system.model.PaymentsModel;

import java.util.List;

public interface IPaymentsDAO {
    PaymentsModel getPaymentsById(Long id);

    List<PaymentsModel> getPaymentsList();

    boolean insertPayments(PaymentsModel entity);

    boolean deletePayments(PaymentsModel entity);

    boolean updatePayments(PaymentsModel entity);
}
