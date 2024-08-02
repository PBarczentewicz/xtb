package com.example.piotrkrupa.test;

import com.example.piotrkrupa.base.BaseTest;
import com.example.piotrkrupa.service.GetService;
import io.restassured.http.ContentType;
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
}