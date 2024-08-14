package com.example.piotrkrupa.test;

import ProjectData.Messages;
import ProjectData.MessageResponse;
import ProjectData.WebData;
import com.example.piotrkrupa.base.BaseTest;
import groovy.json.StringEscapeUtils;
import io.restassured.RestAssured;
import io.restassured.config.ObjectMapperConfig;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

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

    private String removeQuotesAndUnescape(String uncleanJson) {
        String noQuotes = uncleanJson.replaceAll("^\"|\"$", "");

        return StringEscapeUtils.unescapeJava(noQuotes);
    }

    @Test
    public void messageListTest() {
        RestAssured.baseURI = "https://automationintesting.online/message/";

        RequestSpecification httpRequest = RestAssured.given().config(RestAssured.config()
                .objectMapperConfig(new ObjectMapperConfig(ObjectMapperType.GSON)));
        Response response = httpRequest.get();
        Messages messages = response.as(Messages.class);

        System.out.println("Ilość elementów" + messages.getMessages().size());
        System.out.println("Imie pierwszego elementu" + messages.getMessages().get(0).name);
    }
}
