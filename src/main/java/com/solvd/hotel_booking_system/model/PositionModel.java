package com.solvd.hotel_booking_system.model;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PositionModel)) return false;
        PositionModel that = (PositionModel) o;
        return Objects.equals(getPosition(), that.getPosition()) &&
                Objects.equals(getDescription(), that.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPosition(), getDescription());
    }
}
