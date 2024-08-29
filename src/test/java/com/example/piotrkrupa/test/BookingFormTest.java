package com.example.piotrkrupa.test;

import com.example.piotrkrupa.booking.BookingDates;
import com.example.piotrkrupa.booking.BookingRequest;
import com.example.piotrkrupa.booking.BookingResponse;
import com.example.piotrkrupa.booking.BookingServices;
import io.restassured.RestAssured;
import io.restassured.config.ObjectMapperConfig;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BookingFormTest {

    @Test
    public void sendRoomForm() {

        BookingRequest newbookingRequest = BookingRequest.builder()
                .bookingdates(BookingDates.builder().checkin("2024-09-05").checkout("2024-09-06").build())
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
        BookingResponse tempBookingResponse = response.as(BookingResponse.class);


        Assertions.assertEquals(201, response.getStatusCode());
        Assertions.assertEquals("2024-09-05", tempBookingResponse.getBooking().getBookingdates().getCheckin());
        Assertions.assertEquals("2024-09-06", tempBookingResponse.getBooking().getBookingdates().getCheckout());
        Assertions.assertEquals("Jan", tempBookingResponse.getBooking().getFirstname());
        Assertions.assertEquals("Nowak", tempBookingResponse.getBooking().getLastname());
        System.out.println("Twoja rezerwacja została dodana");
    }

    @Test
    public void sendRoomFormWithSearchihDates() {

        BookingServices bookingServices = new BookingServices();

        System.out.println(bookingServices.getBookingDatedForRoom("1"));

        BookingRequest newbookingRequest = BookingRequest.builder()
                .bookingdates(BookingDates.builder().checkin("2024-09-05").checkout("2024-09-06").build())
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
        BookingResponse tempBookingResponse = response.as(BookingResponse.class);


        Assertions.assertEquals(201, response.getStatusCode());

        System.out.println("Twoja rezerwacja została dodana");
    }
}
