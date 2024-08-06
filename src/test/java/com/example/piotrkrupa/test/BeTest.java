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
    @DisplayName("TestBE")
    public void Send() throws InterruptedException {
        File newPost = new File("src/test/java/com.example.piotrkrupa/test/PostTest.json");

        given().log().all().contentType(ContentType.JSON).body(newPost)
                .when().post("https://automationintesting.online")
                .then().log().all();
    }

    @Test
    @DisplayName("TestBE")
    public void Send2() throws InterruptedException {
        String newPost = "{\n" +
                "  \"Name\": \"Przemek\",\n" +
                "  \"Email\": \"Jakis\",\n" +
                "  \"Phone\": \"321654987\",\n" +
                "  \"Subject\": \"story about\",\n" +
                "  \"Message\": \"message about\"\n" +
                "}";

        given().log().all().contentType(ContentType.JSON).body(newPost)
                .when().post("https://automationintesting.online")
                .then().log().all();
    }


//    @Test
//    public void addPostFromMap() {
//        Map<String, Object> newPost = new HashMap<>();
//        newPost.put("Name", "Tomas");
//        newPost.put("Email", "TOmasowy");
//        newPost.put("Phone", "987654321");
//        newPost.put("Subject", "Subject Test");
//        newPost.put("Message", "Message test");
//
//        given().log().all().contentType(ContentType.JSON).body(newPost)
//                .when().post("104.21.25.4")
//                .then().log().all();
//    }


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
        // to jest już działanie na obiektach
        System.out.println("teraz mam już id" + responseBody.messageid);
        System.out.println("teraz mam już id" + responseBody.messageid);
        System.out.println("mam też telefo" + responseBody.phone);
        // itd ... a jak to już mamy to mozemy zrobić assercje

        Assertions.assertEquals("Oczekiwane imie", responseBody.name);

        //spróbuj sam teraz pobrać metodą get wszystkie zapisane wiadomości z usługi https://automationintesting.online/message/

    }
}
