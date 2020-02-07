package com.solvd.hotel_booking_system.model;

public class PositionModel {

    private Long idPosition;
    private String position;
    private String description;

    public PositionModel() {
    }

    public PositionModel(Long idPosition, String position) {
        this.idPosition = idPosition;
        this.position = position;
    }

    public Long getIdPosition() {
        return idPosition;
    }

    public void setIdPosition(Long idPosition) {
        this.idPosition = idPosition;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "PositionModel{" +
                "idPosition=" + idPosition +
                ", position='" + position + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
