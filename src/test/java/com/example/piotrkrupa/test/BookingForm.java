package com.example.piotrkrupa.test;

import com.example.piotrkrupa.booking.BookingDates;
import com.example.piotrkrupa.booking.BookingRequest;
import com.example.piotrkrupa.booking.BookingResponse;
import com.example.piotrkrupa.przemekTestData.MessageRequest;
import io.restassured.RestAssured;
import io.restassured.config.ObjectMapperConfig;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BookingForm {

    @Test
    public void sendRoomForm (){

        BookingDates tempBookingDates = BookingDates.builder()
                .checkin("2024-08-01")
                .checkout("2024-08-02")
                .build();

        BookingRequest newbookingRequest = BookingRequest.builder()
                .bookingdates(tempBookingDates)
                .depositpaid(false)
                .email("jan@jan.pl")
                .firstname("Jan")
                .lastname("Nowak")
                .phone("987654567890976")
                .roomid("1")
                .build();

        RestAssured.baseURI = "https://automationintesting.online/booking/";

        RequestSpecification requestBooking = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(newbookingRequest).config(RestAssured.config()
                        .objectMapperConfig(new ObjectMapperConfig(ObjectMapperType.GSON)));

        Response response = requestBooking.post();

        //Assertions.assertEquals(200, response.getStatusCode());
        //System.out.println("Twoja rezerwacja została dodana");

        BookingResponse tempBookingResponse = response.as(BookingResponse.class);

        Assertions.assertNotNull(tempBookingResponse.getBookingid());
    }
}
