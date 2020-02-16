package com.solvd.hotel_booking_system.model;

import java.sql.Date;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PaymentsModel)) return false;
        PaymentsModel that = (PaymentsModel) o;
        return getPaymentNumber() == that.getPaymentNumber() &&
                getDate().equals(that.getDate()) &&
                getPaymentType_id().equals(that.getPaymentType_id());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDate(), getPaymentType_id(), getPaymentNumber());
    }
}
