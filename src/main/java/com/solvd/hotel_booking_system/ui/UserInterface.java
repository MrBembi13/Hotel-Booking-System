package com.solvd.hotel_booking_system.ui;

import com.solvd.hotel_booking_system.ui.commands.CommandsEnum;
import com.solvd.hotel_booking_system.util.LoggerUtil;

import java.util.Scanner;

public class UserInterface {

    private UserInterface() {
    }

    public static void start(String[] args) {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Hotel-Booking-System>");
            String input = scanner.nextLine();
            if(input.equals("")) continue;
            ConsoleCommand command = parseLineToCommand(input);
            if(command.getCommand() != null) command.doCommand();
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
            LoggerUtil.LOGGER.error(e.getMessage());
            System.out.println("unknown command: " + "\"" + params[0] + "\"");
        }
        return command;
    }

    private static String[] parseKeys(String[] input) {
        String[] result = new String[input.length-1];
        System.arraycopy(input, 1, result, 0, result.length);
        return result;
    }
}
