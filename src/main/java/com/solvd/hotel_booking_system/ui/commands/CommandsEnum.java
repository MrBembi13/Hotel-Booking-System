package com.solvd.hotel_booking_system.ui.commands;

public enum CommandsEnum {

    EXIT("close application"),
    HELP("help [command_name]: you can use this command to get information about [command_name]"),
    HOTELS("show information about hotels"),
    ROOMS("show information about rooms"),
    PAYMENTS("show information about payments"),
    BOOKINGS("show information about bookings"),
    LOGIN(""),
    LOGOUT("");

    public String description;

    CommandsEnum(String description) {
        this.description = description;
    }
}
