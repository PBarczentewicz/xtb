package com.example.piotrkrupa.test;

import ProjectData.WebData;
import com.example.piotrkrupa.base.BaseTest;
import com.example.piotrkrupa.service.GetService;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.json.Json;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

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
        WebData newPost = new WebData();
        newPost.setName("Przemyslaw");
        newPost.setEmail("jsjs@gmail.com");
        newPost.setPhone("92929283838374");
        newPost.setSubject("test subject");
        newPost.setMessage("message test");


        given().log().all().contentType(ContentType.JSON).body(newPost)
                .when().post("https://automationintesting.online")
                .then().log().all();
    }
}
