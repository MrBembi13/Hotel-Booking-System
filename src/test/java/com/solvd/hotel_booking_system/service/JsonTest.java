package com.solvd.hotel_booking_system.service;

import com.solvd.hotel_booking_system.model.PaymentTypeModel;
import com.solvd.hotel_booking_system.util.JSONUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JsonTest {

    @Test
    public void verifyParseFromJson() {
        JSONUtil<PaymentTypeModel> paymentTypeModelJSONUtil = new JSONUtil<>();
        PaymentTypeModel paymentTypeModel = paymentTypeModelJSONUtil.fromJson(PaymentTypeModel.class, "json\\PaymentType.json");
        Assert.assertEquals("type1", paymentTypeModel.getType(), "correct parse");
        Assert.assertEquals("description1", paymentTypeModel.getDescription(), "correct parse");
    }

    @Test
    public void verifyParseToJson() {
        JSONUtil<PaymentTypeModel> paymentTypeModelJSONUtil = new JSONUtil<>();
        PaymentTypeModel paymentTypeModel = new PaymentTypeModel();
        PaymentTypeModel paymentTypeModel2;
        paymentTypeModel.setType("type2");
        paymentTypeModel.setDescription("description2");
        paymentTypeModelJSONUtil.toJson(paymentTypeModel,"json\\PaymentType.json");
        paymentTypeModel2 = paymentTypeModelJSONUtil.fromJson(PaymentTypeModel.class, "json\\PaymentType.json");
        Assert.assertEquals(paymentTypeModel.getType(), paymentTypeModel2.getType(), "correct parse");
        Assert.assertEquals(paymentTypeModel.getDescription(), paymentTypeModel2.getDescription(), "correct parse");
    }
}
