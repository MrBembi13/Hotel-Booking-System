package com.solvd.hotel_booking_system.ui.commands;

import com.solvd.hotel_booking_system.dao.daoClass.AddressDAO;
import com.solvd.hotel_booking_system.model.PaymentTypeModel;
import com.solvd.hotel_booking_system.model.PaymentsModel;
import com.solvd.hotel_booking_system.service.PaymentService;
import com.solvd.hotel_booking_system.ui.ConsoleCommand;
import com.solvd.hotel_booking_system.ui.keys.HotelsKeys;
import com.solvd.hotel_booking_system.ui.keys.PaymentsKeys;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Date;
import java.util.Arrays;
import java.util.Scanner;

public class PaymentsCommandImpl {

    private static final Logger LOGGER = LogManager.getLogger(PaymentsCommandImpl.class);

    public static void doCommand(String[] keys, ConsoleCommand command, Scanner scanner) {

        if (scanner == null) {
            scanner = new Scanner(System.in);
        }

        PaymentsModel payment = new PaymentsModel();
        PaymentTypeModel paymentType = new PaymentTypeModel();

        PaymentService paymentService = new PaymentService();

        if (isContainsKey("DATE", keys)) {
            LOGGER.info("Enter date(\"yyyy-mm-dd\")");
            try {
                payment.setDate(Date.valueOf(scanner.nextLine()));
            } catch (IllegalArgumentException e) {
                LOGGER.info("Invalid date.");
            }
        }
        if (isContainsKey("TYPE", keys)) {
            LOGGER.info("Enter type:");
            paymentType.setType(scanner.nextLine());
        }
        LOGGER.info(paymentService.findByParameters(paymentType, payment));
    }

    public static boolean isContainsKey(String keyName, String[] keys) {
        return Arrays.asList(keys).contains(PaymentsKeys.valueOf(keyName).key);
    }
}
