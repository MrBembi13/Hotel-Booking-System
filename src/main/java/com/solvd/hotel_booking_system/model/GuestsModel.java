package com.solvd.hotel_booking_system.model;

public class GuestsModel {

    private Long idGuests;
    private String firstName;
    private String lastName;
    private Long phoneNumber;
    private String email;
    private String gender;

    public GuestsModel() {
    }

    public GuestsModel(Long idGuests, String firstName, String lastName, String gender) {
        this.idGuests = idGuests;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
    }

    public Long getIdGuests() {
        return idGuests;
    }

    public void setIdGuests(Long idGuests) {
        this.idGuests = idGuests;
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

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "GuestsModel{" +
                "idGuests=" + idGuests +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
