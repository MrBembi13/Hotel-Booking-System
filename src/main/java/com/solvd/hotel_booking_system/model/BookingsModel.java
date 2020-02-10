package com.solvd.hotel_booking_system.model;

import java.sql.Date;

public class BookingsModel {

    private Long idBookings;
    private Long guests_id;
    private Long hotels_id;
    private Date dateFrom;
    private Date dateTo;
    private Long rooms_id;
    private Long payments_id;
    private String status;

    public BookingsModel() {
    }

    public Long getIdBookings() {
        return idBookings;
    }

    public void setIdBookings(Long idBookings) {
        this.idBookings = idBookings;
    }

    public Long getGuests_id() {
        return guests_id;
    }

    public void setGuests_id(Long guests_id) {
        this.guests_id = guests_id;
    }

    public Long getHotels_id() {
        return hotels_id;
    }

    public void setHotels_id(Long hotels_id) {
        this.hotels_id = hotels_id;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    public Long getRooms_id() {
        return rooms_id;
    }

    public void setRooms_id(Long rooms_id) {
        this.rooms_id = rooms_id;
    }

    public Long getPayments_id() {
        return payments_id;
    }

    public void setPayments_id(Long payments_id) {
        this.payments_id = payments_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "BookingsModel{" +
                "idBookings=" + idBookings +
                ", guests_id=" + guests_id +
                ", hotels_id=" + hotels_id +
                ", dateFrom=" + dateFrom +
                ", dateTo=" + dateTo +
                ", rooms_id=" + rooms_id +
                ", payments_id=" + payments_id +
                ", status='" + status + '\'' +
                '}';
    }
}
