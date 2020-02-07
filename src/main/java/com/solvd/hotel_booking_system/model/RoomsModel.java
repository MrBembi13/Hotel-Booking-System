package com.solvd.hotel_booking_system.model;

public class RoomsModel {

    private Long idRooms;
    private Long hotels_id;
    private int floor;
    private int roomNumber;
    private Long roomTypes_id;
    private String description;
    private boolean roomStatus;

    public RoomsModel() {
    }

    public Long getIdRooms() {
        return idRooms;
    }

    public void setIdRooms(Long idRooms) {
        this.idRooms = idRooms;
    }

    public Long getHotels_id() {
        return hotels_id;
    }

    public void setHotels_id(Long hotels_id) {
        this.hotels_id = hotels_id;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Long getRoomTypes_id() {
        return roomTypes_id;
    }

    public void setRoomTypes_id(Long roomTypes_id) {
        this.roomTypes_id = roomTypes_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(boolean roomStatus) {
        this.roomStatus = roomStatus;
    }

    @Override
    public String toString() {
        return "RoomsModel{" +
                "idRooms=" + idRooms +
                ", hotels_id=" + hotels_id +
                ", floor=" + floor +
                ", roomNumber=" + roomNumber +
                ", roomTypes_id=" + roomTypes_id +
                ", description='" + description + '\'' +
                ", roomStatus=" + roomStatus +
                '}';
    }
}
