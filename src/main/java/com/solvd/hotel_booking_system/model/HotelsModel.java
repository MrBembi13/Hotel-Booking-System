package com.solvd.hotel_booking_system.model;

public class HotelsModel {

    private Long idHotels;
    private String nameHotel;
    private int phoneNumber;
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

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
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
}
