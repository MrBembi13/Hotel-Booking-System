package com.solvd.hotel_booking_system.model;

import java.sql.Date;

public class PaymentsModel {

    private Long idPayments;
    private Date date;
    private Long paymentType_id;
    private int paymentNumber;

    public PaymentsModel() {
    }

    public Long getIdPayments() {
        return idPayments;
    }

    public void setIdPayments(Long idPayments) {
        this.idPayments = idPayments;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getPaymentType_id() {
        return paymentType_id;
    }

    public void setPaymentType_id(Long paymentType_id) {
        this.paymentType_id = paymentType_id;
    }

    public int getPaymentNumber() {
        return paymentNumber;
    }

    public void setPaymentNumber(int paymentNumber) {
        this.paymentNumber = paymentNumber;
    }

    @Override
    public String toString() {
        return "PaymentsModel{" +
                "idPayments=" + idPayments +
                ", date=" + date +
                ", paymentType_id=" + paymentType_id +
                ", paymentNumber=" + paymentNumber +
                '}';
    }
}
