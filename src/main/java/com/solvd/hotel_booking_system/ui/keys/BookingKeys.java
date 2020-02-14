package com.solvd.hotel_booking_system.ui.keys;

public enum BookingKeys {

    NEW("-new"),
    DATE_TO("-date_to"),
    DATE_FROM("-date_from"),
    STATUS("-status");

    public String key;

    BookingKeys(String key) {
        this.key = key;
    }
}
