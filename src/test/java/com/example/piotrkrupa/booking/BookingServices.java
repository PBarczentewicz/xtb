package com.example.piotrkrupa.booking;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.ArrayList;

public class BookingServices {

    public Report getBookingDatedForRoom (String roomId){
        RestAssured.baseURI = "https://automationintesting.online/report/room/" + roomId;

        RequestSpecification roomRequest = RestAssured.given()
                .contentType(ContentType.JSON);

        Response response = roomRequest.get();
        Report report = response.as(Report.class);

        return report;
    }
}
