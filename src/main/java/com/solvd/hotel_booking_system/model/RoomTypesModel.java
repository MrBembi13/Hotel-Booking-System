package com.solvd.hotel_booking_system.model;

import java.util.Objects;

public class RoomTypesModel {

    private Long idRoomTypes;
    private String roomType;
    private int priceForNight;

    public RoomTypesModel() {
    }

    public Long getIdRoomTypes() {
        return idRoomTypes;
    }

    public void setIdRoomTypes(Long idRoomTypes) {
        this.idRoomTypes = idRoomTypes;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public int getPriceForNight() {
        return priceForNight;
    }

    public void setPriceForNight(int priceForNight) {
        this.priceForNight = priceForNight;
    }

    @Override
    public String toString() {
        return "RoomTypesModel{" +
                "idRoomTypes=" + idRoomTypes +
                ", roomType='" + roomType + '\'' +
                ", priceForNight=" + priceForNight +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RoomTypesModel)) return false;
        RoomTypesModel that = (RoomTypesModel) o;
        return getPriceForNight() == that.getPriceForNight() &&
                getRoomType().equals(that.getRoomType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRoomType(), getPriceForNight());
    }
}
