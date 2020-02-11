package com.solvd.hotel_booking_system.model;

public class AddressModel {

    private Long idAddress;
    private String country;
    private String state;
    private String city;
    private String street;
    private String building;
    private String zipCode;

    public AddressModel() {
    }

    public AddressModel(Long idAddress, String country, String state, String city) {
        this.idAddress = idAddress;
        this.country = country;
        this.state = state;
        this.city = city;
    }

    public Long getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(Long idAddress) {
        this.idAddress = idAddress;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return "AddressModel{" +
                "idAddress=" + idAddress +
                ", country='" + country + '\'' +
                ", state='" + state + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", building='" + building + '\'' +
                ", zip code='" + zipCode + '\'' +
                '}';
    }
}
