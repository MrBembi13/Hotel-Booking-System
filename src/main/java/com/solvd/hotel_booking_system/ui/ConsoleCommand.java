package com.solvd.hotel_booking_system.ui;

import com.solvd.hotel_booking_system.model.GuestsModel;
import com.solvd.hotel_booking_system.model.HotelsModel;
import com.solvd.hotel_booking_system.ui.commands.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class ConsoleCommand {

    private static final Logger LOGGER = LogManager.getLogger(ConsoleCommand.class);

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

    public void doCommand(Scanner scanner) {

        switch (command) {
            case EXIT: {
                LOGGER.info("Bye");
                System.exit(0);
                break;
            }
            case LOGIN: {
                if(isValidKeys()) {
                    LoginCommandImpl.doCommand(keys, this, scanner);
                } else {
                    LOGGER.info("Invalid login command. Try help login");
                }
                break;
            }
            case LOGOUT: {
                if(isValidKeys()) {
                    LogoutCommandImpl.doCommand(keys, this);
                } else {
                    LOGGER.info("Invalid logout command. Try help logout");
                }
                break;
            }
            case BOOKINGS: {
                if(isValidKeys()) {
                    BookingsCommandImpl.doCommand(keys, this, scanner);
                } else {
                    LOGGER.info("Invalid bookings command. Try help bookings");
                }
                break;
            }
            case ROOMS: {
                if(isValidKeys()) {
                    RoomsCommandImpl.doCommand(keys, this, scanner);
                } else {
                    LOGGER.info("Invalid rooms command. Try help rooms");
                }
                break;
            }
            case HOTELS: {
                if(isValidKeys()) {
                    HotelsCommandImpl.doCommand(keys, this, scanner);
                } else {
                    LOGGER.info("Invalid hotels command. Try help hotels");
                }
                break;
            }
            case HELP: {
                if (this.keys.length == 0) {
                    for(CommandsEnum commandsEnum: CommandsEnum.values()) {
                        LOGGER.info(commandsEnum.description);
                    }
                }
                if(this.keys.length > 1) {
                    LOGGER.info("Invalid keys. Try \"help [command]\"");
                } else {
                    try {
                        LOGGER.info(CommandsEnum
                                .valueOf(keys[0].toUpperCase()).description);
                    } catch (Exception e) {
                        LOGGER.error(e.getMessage());
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
