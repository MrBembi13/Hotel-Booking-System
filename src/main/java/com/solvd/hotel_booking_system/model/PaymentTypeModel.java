package com.solvd.hotel_booking_system.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class PaymentTypeModel {

    private Long idPaymentType;
    private String type;
    private String description;

    public PaymentTypeModel() {
    }

    @JsonIgnore
    public Long getIdPaymentType() {
        return idPaymentType;
    }

    @JsonProperty
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PaymentTypeModel)) return false;
        PaymentTypeModel that = (PaymentTypeModel) o;
        return getType().equals(that.getType()) &&
                getDescription().equals(that.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getType(), getDescription());
    }
}
