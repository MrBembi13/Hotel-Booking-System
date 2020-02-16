package com.solvd.hotel_booking_system.model;

import java.util.Objects;

public class HotelsModel {

    private Long idHotels;
    private String nameHotel;
    private String phoneNumber;
    private String emailAddress;
    private String websiteUrl;
    private Long address_id;

    public HotelsModel() {
    }

    public Long getIdHotels() {
        return idHotels;
    }

    public void setIdHotels(Long idHotels) {
        this.idHotels = idHotels;
    }

    public String getNameHotel() {
        return nameHotel;
    }

    public void setNameHotel(String nameHotel) {
        this.nameHotel = nameHotel;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }

    public Long getAddress_id() {
        return address_id;
    }

    public void setAddress_id(Long address_id) {
        this.address_id = address_id;
    }

    @Override
    public String toString() {
        return "HotelsModel{" +
                "idHotels=" + idHotels +
                ", nameHotel='" + nameHotel + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", emailAddress='" + emailAddress + '\'' +
                ", websiteUrl='" + websiteUrl + '\'' +
                ", address_id=" + address_id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HotelsModel)) return false;
        HotelsModel that = (HotelsModel) o;
        return getNameHotel().equals(that.getNameHotel()) &&
                getPhoneNumber().equals(that.getPhoneNumber()) &&
                getAddress_id().equals(that.getAddress_id());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNameHotel(), getPhoneNumber(), getAddress_id());
    }
}
