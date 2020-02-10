package com.solvd.hotel_booking_system.model;

public class PaymentTypeModel {

    private Long idPaymentType;
    private String type;
    private String description;

    public PaymentTypeModel() {
    }

    public Long getIdPaymentType() {
        return idPaymentType;
    }

    public void setIdPaymentType(Long idPaymentType) {
        this.idPaymentType = idPaymentType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "PaymentTypeModel{" +
                "idPaymentType=" + idPaymentType +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
