package com.solvd.hotel_booking_system.ui;

import com.solvd.hotel_booking_system.ui.commands.CommandsEnum;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class UserInterface {

    private static final Logger LOGGER = LogManager.getLogger(UserInterface.class);

    private UserInterface() {
    }

    public static void start(String[] args) {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Hotel-Booking-System>");
            String input = scanner.nextLine();
            if(input.equals("")) continue;
            ConsoleCommand command = parseLineToCommand(input);
            if(command.getCommand() != null) command.doCommand(scanner);
        } while (true);
    }

    private static ConsoleCommand parseLineToCommand(String line) {
        String[] params = line.split(" ");
        String commandString = params[0];
        ConsoleCommand command = new ConsoleCommand();
        command.setKeys(parseKeys(params));
        try {
            command.setCommand(CommandsEnum.valueOf(commandString.toUpperCase()));
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            LOGGER.info("unknown command: " + "\"" + params[0] + "\"");
        }
        return command;
    }

    private static String[] parseKeys(String[] input) {
        String[] result = new String[input.length-1];
        System.arraycopy(input, 1, result, 0, result.length);
        return result;
    }
}
