package com.solvd.hotel_booking_system.util;

import com.solvd.hotel_booking_system.model.*;

import java.sql.Date;
import java.util.Random;

public class InfoGenerator {

    private static final int SEED = 100;
    private static Random random = new Random();

    public static Date generateRandomDate() {
        StringBuilder dateString = new StringBuilder();
        int day = random.nextInt(30);
        int month = new Random().nextInt(11);
        int year = new Random().nextInt(1018);
        dateString.append(year+1000);
        dateString.append("-");
        dateString.append(month+1);
        dateString.append("-");
        dateString.append(day+1);
        System.out.println(dateString.toString());
        return Date.valueOf(dateString.toString());
    }

    public static AddressModel generateAddress() {
        AddressModel addressModel = new AddressModel();
        addressModel.setIdAddress(random.nextLong());
        addressModel.setBuilding("building" + random.nextInt(SEED));
        addressModel.setCity("city" + random.nextInt(SEED));
        addressModel.setZipcode("zip" + random.nextInt(SEED));
        addressModel.setCountry("country" + random.nextInt(SEED));
        addressModel.setState("state" + random.nextInt(SEED));
        addressModel.setStreet("street" + random.nextInt(SEED));
        return addressModel;
    }

    public static PositionModel generatePosition() {
        PositionModel positionModel = new PositionModel();
        positionModel.setIdPosition(random.nextLong());
        positionModel.setDescription("pos_decr" + random.nextInt(SEED));
        positionModel.setPosition("position" + random.nextInt(SEED));
        return positionModel;
    }

    public static HotelsModel generateHotel(AddressModel address) {
        HotelsModel hotelsModel = new HotelsModel();
        hotelsModel.setAddress_id(address.getIdAddress());
        hotelsModel.setIdHotels(random.nextLong());
        hotelsModel.setEmailAddress("email" + random.nextInt(SEED));
        hotelsModel.setNameHotel("hotel_name" + random.nextInt(SEED));
        hotelsModel.setPhoneNumber(random.nextInt(999999999));
        hotelsModel.setWebsiteUrl("website" + random.nextInt(SEED));
        return hotelsModel;
    }

    public static GuestsModel generateGuest() {
        GuestsModel guestsModel = new GuestsModel();
        guestsModel.setIdGuests(random.nextLong());
        guestsModel.setEmail("email" + random.nextInt(SEED));
        guestsModel.setFirstName("first_name" + random.nextInt(SEED));
        guestsModel.setGender("gender" + random.nextInt(1));
        guestsModel.setLastName("last_name" + random.nextInt(SEED));
        guestsModel.setPhoneNumber(random.nextInt(999999999));
        return guestsModel;
    }

    public static StaffModel generateStaff(HotelsModel hotel, PositionModel position) {
        StaffModel staffModel = new StaffModel();
        staffModel.setHotels_id(hotel.getIdHotels());
        staffModel.setFirstName("first_name" + random.nextInt(SEED));
        staffModel.setGender("gender" + random.nextInt(1));
        staffModel.setIdStaff(random.nextLong());
        staffModel.setLastName("last_name" + random.nextInt(SEED));
        staffModel.setPosition_id(position.getIdPosition());
        return staffModel;
    }

    public static RoomTypesModel generateRoomType() {
        RoomTypesModel roomTypesModel = new RoomTypesModel();
        roomTypesModel.setIdRoomTypes(random.nextLong());
        roomTypesModel.setPriceForNight(random.nextInt());
        roomTypesModel.setRoomType("room_type" + random.nextInt(SEED));
        return roomTypesModel;
    }

    public static PaymentTypeModel generatePaymentType() {
        PaymentTypeModel paymentTypeModel = new PaymentTypeModel();
        paymentTypeModel.setIdPaymentType(random.nextLong());
        paymentTypeModel.setDescription("pay_type_descr" + random.nextInt(SEED));
        paymentTypeModel.setType("pay_type" + random.nextInt(SEED));
        return paymentTypeModel;
    }

    public static PaymentsModel generatePayment(PaymentTypeModel paymentType) {
        PaymentsModel paymentsModel = new PaymentsModel();
        paymentsModel.setDate(generateRandomDate());
        paymentsModel.setIdPayments(random.nextLong());
        paymentsModel.setPaymentNumber(random.nextInt());
        paymentsModel.setPaymentType_id(paymentType.getIdPaymentType());
        return paymentsModel;
    }

    public static RoomsModel generateRoom(HotelsModel hotel, RoomTypesModel roomType) {
        RoomsModel roomsModel = new RoomsModel();
        roomsModel.setIdRooms(random.nextLong());
        roomsModel.setDescription("room_descr" + random.nextInt(SEED));
        roomsModel.setFloor(random.nextInt(SEED));
        roomsModel.setRoomNumber(random.nextInt(SEED));
        roomsModel.setRoomStatus(random.nextBoolean());
        roomsModel.setHotels_id(hotel.getIdHotels());
        roomsModel.setRoomTypes_id(roomType.getIdRoomTypes());
        return roomsModel;
    }

    public static BookingsModel generateBooking(GuestsModel guest, HotelsModel hotel,
                                                RoomsModel room, PaymentsModel payment) {
        BookingsModel bookingsModel = new BookingsModel();
        bookingsModel.setDateFrom(generateRandomDate());
        bookingsModel.setDateTo(generateRandomDate());
        bookingsModel.setStatus("booking_status" + random.nextInt(SEED));
        bookingsModel.setGuests_id(guest.getIdGuests());
        bookingsModel.setHotels_id(hotel.getIdHotels());
        bookingsModel.setRooms_id(room.getIdRooms());
        bookingsModel.setPayments_id(payment.getIdPayments());
        return bookingsModel;
    }
}