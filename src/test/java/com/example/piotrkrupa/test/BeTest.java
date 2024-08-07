package com.example.piotrkrupa.test;

import ProjectData.MessageResponse;
import ProjectData.WebData;
import com.example.piotrkrupa.base.BaseTest;
import com.google.gson.Gson;
import dev.failsafe.internal.util.Assert;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

public class BeTest extends BaseTest {

    @Test
    public void addPostFromObject(){
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

        Assertions.assertEquals("Piotrek", responseBody.name);
        //dodać assercje

        //Assertions.assertEquals(listta1.count()+1, responseList.count);

    }

}
