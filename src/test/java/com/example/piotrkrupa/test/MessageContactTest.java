package com.example.piotrkrupa.test;

import ProjectData.MessageResponse;
import com.example.piotrkrupa.base.BaseTest;
import com.example.piotrkrupa.przemekTestData.MessageRequest;
import com.example.piotrkrupa.przemekTestData.MessageResponse2;
import dev.failsafe.internal.util.Assert;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.internal.common.assertion.Assertion;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MessageContactTest extends BaseTest {

    @Test
    public void SendMessage() {
        MessageRequest newRequest = MessageRequest.builder()
                .name("Przemyslaw")
                .email("jsjs@gmail.com")
                .phone("92929283838374")
                .subject("test subject")
                .description("message testmessage testmessage testmessage testmessage test")
                .build();

        RestAssured.baseURI = "https://automationintesting.online/message/";
        RequestSpecification newPost = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(newRequest);

        Response newResponse = newPost.post();
        MessageResponse2 newMessageResponse = newResponse.getBody().as(MessageResponse2.class);

        Assertions.assertEquals(newRequest.getName(), newMessageResponse.name);







    }
}
