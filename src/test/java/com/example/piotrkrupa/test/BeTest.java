package com.example.piotrkrupa.test;

import ProjectData.MessageBody;
import ProjectData.MessageResponse;
import ProjectData.WebData;
import com.example.piotrkrupa.base.BaseTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class BeTest extends BaseTest {

    @Test
    public void addPostFromObject() {
        WebData newPost = WebData.builder()
                .name("Przemyslaw")
                .email("jsjs@gmail.com")
                .phone("92929283838374")
                .subject("test subject")
                .description("message testmessage testmessage testmessage testmessage test")
                .build();

        RestAssured.baseURI = "https://automationintesting.online/message/";
        RequestSpecification httpRequest = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(newPost);

        Response response = httpRequest.post();
        System.out.println("To jest cały response: " + response.getBody());

        MessageResponse responseBody = response.getBody().as(MessageResponse.class);
        System.out.println("teraz mam już id" + responseBody.messageid);

        Assertions.assertEquals("Przemyslaw", responseBody.name);
        Assertions.assertEquals("jsjs@gmail.com", responseBody.email);
        Assertions.assertEquals("92929283838374", responseBody.phone);
        Assertions.assertEquals("test subject", responseBody.subject);
        Assertions.assertEquals("message testmessage testmessage testmessage testmessage test", responseBody.description);

    }

    @Test
    public void messageListTest() {
        List<MessageBody> resposneBodyJason = new ArrayList<>();
        RestAssured.baseURI = "https://automationintesting.online/message/";
        MessageBody newMessage = when().get("id/name/subject/read").as(MessageBody.class);
        resposneBodyJason.add(newMessage);
        String firstList = String.valueOf(resposneBodyJason.size());

        MessageBody newPost = MessageBody.builder()
                .id("6")
                .name("Przemyslawtest")
                .subject("92929283838374")
                .read(true)
                .build();

        RestAssured.baseURI = "https://automationintesting.online/message/";
        RequestSpecification httpRequest = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(newPost);

        MessageBody newMessage2 = when().get("id/name/subject/read").as(MessageBody.class);
        resposneBodyJason.add(newMessage);
        String firstList2 = String.valueOf(resposneBodyJason.size());

        Assertions.assertEquals(firstList + 1, firstList2);

    }
}
