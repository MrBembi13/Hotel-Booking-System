package com.solvd.hotel_booking_system.service;

import com.solvd.hotel_booking_system.model.PaymentTypeModel;
import com.solvd.hotel_booking_system.util.JSONUtil;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class JsonTest {

    private JSONUtil<PaymentTypeModel> paymentTypeModelJSONUtil;
    private PaymentTypeModel paymentTypeModel;
    private PaymentTypeModel paymentTypeModel2;

    @BeforeMethod
    public void init() {
        paymentTypeModelJSONUtil = new JSONUtil<>();
        paymentTypeModel = new PaymentTypeModel();
        paymentTypeModel2 = new PaymentTypeModel();
    }

    @Test
    public void successfullyParseFromJsonById() {
        paymentTypeModel = paymentTypeModelJSONUtil.fromJson(PaymentTypeModel.class, "json\\PaymentType.json");
        Assert.assertEquals("type1", paymentTypeModel.getType());
        Assert.assertEquals("description1", paymentTypeModel.getDescription());
    }

    @Test
    public void successfullyParseToJsonById() {
        paymentTypeModel.setType("type2");
        paymentTypeModel.setDescription("description2");
        paymentTypeModelJSONUtil.toJson(paymentTypeModel,"json\\PaymentType.json");
        paymentTypeModel2 = paymentTypeModelJSONUtil.fromJson(PaymentTypeModel.class, "json\\PaymentType.json");
        Assert.assertEquals(paymentTypeModel.getType(), paymentTypeModel2.getType());
        Assert.assertEquals(paymentTypeModel.getDescription(), paymentTypeModel2.getDescription());
    }
}
