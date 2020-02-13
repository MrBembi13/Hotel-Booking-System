package com.solvd.hotel_booking_system.ui.commands;

import com.solvd.hotel_booking_system.model.PaymentTypeModel;
import com.solvd.hotel_booking_system.model.PaymentsModel;
import com.solvd.hotel_booking_system.service.PaymentService;
import com.solvd.hotel_booking_system.ui.ConsoleCommand;
import com.solvd.hotel_booking_system.ui.keys.HotelsKeys;
import com.solvd.hotel_booking_system.ui.keys.PaymentsKeys;

import java.sql.Date;
import java.util.Arrays;
import java.util.Scanner;

public class PaymentsCommandImpl {

    public static void doCommand(String[] keys, ConsoleCommand command) {

        Scanner scanner = new Scanner(System.in);

        PaymentsModel payment = new PaymentsModel();
        PaymentTypeModel paymentType = new PaymentTypeModel();

        PaymentService paymentService = new PaymentService();

        if (isContainsKey("DATE", keys)) {
            System.out.println("Enter date(\"yyyy-mm-dd\")");
            try {
                payment.setDate(Date.valueOf(scanner.nextLine()));
            } catch (Exception e) {
                System.out.println("Invalid date.");
            }
        }
        if (isContainsKey("TYPE", keys)) {
            System.out.println("Enter type:");
            paymentType.setType(scanner.nextLine());
        }
        System.out.println(paymentService.findByParameters(paymentType, payment));
    }

    public static boolean isContainsKey(String keyName, String[] keys) {
        return Arrays.asList(keys).contains(PaymentsKeys.valueOf(keyName).key);
    }
}
