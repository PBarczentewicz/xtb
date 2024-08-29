package com.example.piotrkrupa.booking;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.ArrayList;

public class BookingServices {

    public ArrayList<Booking> getBookingDatedForRoom (String roomId){
        RestAssured.baseURI = "https://automationintesting.online/report/room/";

        RequestSpecification roomRequest = RestAssured.given()
                .contentType(ContentType.JSON)
                .queryParam("roomId", roomId);

        Response response = roomRequest.get();

        ArrayList <Booking> bookingArray = new ArrayList<>();


    }
}
