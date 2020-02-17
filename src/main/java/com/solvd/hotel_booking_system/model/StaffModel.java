package com.solvd.hotel_booking_system.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class StaffModel {

    private Long idStaff;
    private String firstName;
    private String lastName;
    private Long hotels_id;
    private String gender;
    private Long position_id;

    public StaffModel() {
    }

    public StaffModel(Long idStaff, String firstName, String lastName, String gender) {
        this.idStaff = idStaff;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
    }

    @JsonIgnore
    public Long getIdStaff() {
        return idStaff;
    }

    @JsonProperty
    public void setIdStaff(Long idStaff) {
        this.idStaff = idStaff;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getHotels_id() {
        return hotels_id;
    }

    public void setHotels_id(Long hotels_id) {
        this.hotels_id = hotels_id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Long getPosition_id() {
        return position_id;
    }

    public void setPosition_id(Long position_id) {
        this.position_id = position_id;
    }

    @Override
    public String toString() {
        return "StaffModel{" +
                "idStaff=" + idStaff +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", hotels_id=" + hotels_id +
                ", gender='" + gender + '\'' +
                ", position_id=" + position_id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StaffModel)) return false;
        StaffModel that = (StaffModel) o;
        return getFirstName().equals(that.getFirstName()) &&
                getLastName().equals(that.getLastName()) &&
                getHotels_id().equals(that.getHotels_id()) &&
                getGender().equals(that.getGender()) &&
                getPosition_id().equals(that.getPosition_id());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getLastName(), getHotels_id(), getGender(), getPosition_id());
    }
}
