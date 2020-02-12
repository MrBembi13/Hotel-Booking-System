package com.solvd.hotel_booking_system.ui;

import com.solvd.hotel_booking_system.model.GuestsModel;
import com.solvd.hotel_booking_system.model.HotelsModel;
import com.solvd.hotel_booking_system.ui.commands.*;
import com.solvd.hotel_booking_system.ui.keys.HotelsKeys;
import com.solvd.hotel_booking_system.util.LoggerUtil;

import java.util.Arrays;

public class ConsoleCommand {

    private static HotelsModel HOTEL;
    private static GuestsModel GUEST;

    private CommandsEnum command;
    private String[] keys;

    public ConsoleCommand() {
    }

    public HotelsModel getHOTEL() {
        return HOTEL;
    }

    public void setHOTEL(HotelsModel HOTEL) {
        ConsoleCommand.HOTEL = HOTEL;
    }

    public GuestsModel getGUEST() {
        return GUEST;
    }

    public void setGUEST(GuestsModel GUEST) {
        ConsoleCommand.GUEST = GUEST;
    }

    public CommandsEnum getCommand() {
        return command;
    }

    public void setCommand(CommandsEnum command) {
        this.command = command;
    }

    public String[] getKeys() {
        return keys;
    }

    public void setKeys(String[] keys) {
        this.keys = keys;
    }

    public void doCommand() {

        switch (command) {
            case EXIT: {
                System.out.println("Bye");
                System.exit(0);
                break;
            }
            case PAYMENTS: {
                if(isValidKeys()) {
                    PaymentsCommandImpl.doCommand(keys, this);
                } else {
                    System.out.println("Invalid payments command. Try help payments");
                }
                break;
            }
            case BOOKINGS: {
                if(isValidKeys()) {
                    BookingsCommandImpl.doCommand(keys, this);
                } else {
                    System.out.println("Invalid bookings command. Try help bookings");
                }
                break;
            }
            case ROOMS: {
                if(isValidKeys()) {
                    RoomsCommandImpl.doCommand(keys, this);
                } else {
                    System.out.println("Invalid rooms command. Try help rooms");
                }
                break;
            }
            case HOTELS: {
                if(isValidKeys()) {
                    HotelsCommandImpl.doCommand(keys, this);
                } else {
                    System.out.println("Invalid hotels command. Try help hotels");
                }
                break;
            }
            case HELP: {
                if (this.keys.length == 0) {
                    for(CommandsEnum commandsEnum: CommandsEnum.values()) {
                        System.out.println(commandsEnum.description);
                    }
                }
                if(this.keys.length > 1) {
                    System.out.println("Invalid keys. Try \"help [command]\"");
                } else {
                    try {
                        System.out.println(CommandsEnum
                                .valueOf(keys[0].toUpperCase()).description);
                    } catch (Exception e) {
                        LoggerUtil.LOGGER.error(e.getMessage());
                    }
                }
                break;
            }
        }
    }

    private boolean isValidKeys() {
        return true;
    }
}
