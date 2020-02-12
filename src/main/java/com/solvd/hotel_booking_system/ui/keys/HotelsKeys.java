package com.solvd.hotel_booking_system.ui.keys;

public enum HotelsKeys {
    CITY("-city"),
    STAFF("-staff"),
    STREET("-street"),
    NAME("-name"),
    SELECT("-select"),
    ROOM_TYPE("-roomtype");

    public String key;

    HotelsKeys(String key){
        this.key = key;
    }
}
