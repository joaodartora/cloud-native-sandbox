package com.joaodartora.springboot.test;

import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class TollResourcesTest {

    private static final String URL_PREFIX_PAY = "http://localhost:8080/rest/toll/pay";
    private static final String URL_PREFIX_PRICES = "http://localhost:8080/rest/toll/prices";

    @Test
    public void carPaymentTest() {
        given().when().get(URL_PREFIX_PAY + "/car/20.00").then().statusCode(200);
    }

    @Test
    public void bikePaymentTest() {
        given().when().get(URL_PREFIX_PAY + "/bike/5.00").then().statusCode(200);
    }

    @Test
    public void busPaymentTest() {
        given().when().get(URL_PREFIX_PAY + "/bus/13.00").then().statusCode(200);
    }

    @Test
    public void motorcyclePaymentTest() {
        given().when().get(URL_PREFIX_PAY + "/motorcycle/90.00").then().statusCode(200);
    }

    @Test
    public void truckPaymentTest() {
        given().when().get(URL_PREFIX_PAY + "/truck/2/10.00").then().statusCode(200);
    }

    @Test
    public void priceListTest() {
        given().when().get(URL_PREFIX_PRICES).then().statusCode(200).contentType(ContentType.JSON);
    }

    @Test
    public void lessMoneyCarTest() {
        given().when().get(URL_PREFIX_PAY + "/car/1.00").then().statusCode(400);
    }

    @Test
    public void invalidParameterTest() {
        given().when().get(URL_PREFIX_PAY + "/car/kubernetes").then().statusCode(404);
    }

    @Test
    public void vehicleWithInvalidAxisTest() {
        given().when().get(URL_PREFIX_PAY + "/car/6/2").then().statusCode(404);
    }
}
