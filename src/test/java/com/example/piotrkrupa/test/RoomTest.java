package com.example.piotrkrupa.test;

import ProjectData.Messages;
import com.example.piotrkrupa.booking.Features;
import com.example.piotrkrupa.booking.Rooms;
import com.example.piotrkrupa.booking.WebLogin;
import io.restassured.RestAssured;
import io.restassured.config.ObjectMapperConfig;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class RoomTest {

    @Test
    public void addNewRoom() {

        WebLogin login = WebLogin.builder()
                .password("password")
                .username("admin")
                .build();

        RestAssured.baseURI = "https://automationintesting.online/#/admin";

        RequestSpecification get1 = RestAssured.given().config(RestAssured.config()
                .objectMapperConfig(new ObjectMapperConfig(ObjectMapperType.GSON)));

        RequestSpecification newLog = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(login);

        Rooms rooms = Rooms.builder()
                .roomid("5")
                .roomName("110")
                .type("Twin")
                .accessible(false)
                .image("https://www.mwtestconsultancy.co.uk/img/room1.jpg")
                .description("Please enter a description for this room")
                .features(Features.builder().tv("tv").views("views").radio("radio").safe("safe").refreshment("refreshement").build())
                .build();

        int listSize = 0;

        RequestSpecification get = RestAssured.given().config(RestAssured.config()
                .objectMapperConfig(new ObjectMapperConfig(ObjectMapperType.GSON)));

        listSize = getMessagesSize(get);

        System.out.println(listSize);

        RequestSpecification newRoom = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(rooms);

        Response response = newRoom.post();
        Rooms rooms1 = response.as(Rooms.class);

        Assertions.assertEquals(listSize, getMessagesSize(get));
    }

    private int getMessagesSize(RequestSpecification get) {
        Response responseGet = get.get();
        Messages deserializeObject = responseGet.as(Messages.class);
        return deserializeObject.getMessages().size();
    }

    @Test
    public void addNewRoomCheck() {

        RestAssured.baseURI = "https://automationintesting.online/";

        RequestSpecification request = RestAssured.given();

        Response response = request.get("/room/");

        ArrayList<Rooms> roomList = new ArrayList<>();
        Rooms rooms = response.as(Rooms.class);

        roomList.add(rooms);

        System.out.println(roomList);


    }
}
