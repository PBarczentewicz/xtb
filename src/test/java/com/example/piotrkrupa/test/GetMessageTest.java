package com.example.piotrkrupa.test;

import ProjectData.Messages;
import com.example.piotrkrupa.base.BaseTest;
import com.example.piotrkrupa.przemekTestData.MessageRequest;
import io.restassured.RestAssured;
import io.restassured.config.ObjectMapperConfig;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GetMessageTest extends BaseTest {

    @Test
    public void getMessage() {
        MessageRequest newRequest = MessageRequest.builder()
                .name("Przemyslaw")
                .email("jsjs@gmail.com")
                .phone("92929283838374")
                .subject("test subject")
                .description("message testmessage testmessage testmessage testmessage test")
                .build();
        RestAssured.baseURI = "https://automationintesting.online/message/";


        int listSize = 0;
        RequestSpecification get = RestAssured.given().config(RestAssured.config()
                .objectMapperConfig(new ObjectMapperConfig(ObjectMapperType.GSON)));
        listSize = getMessagesSize(get);


        System.out.println(listSize);

        RequestSpecification newPost = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(newRequest);

        newPost.post();

        Assertions.assertEquals(listSize + 1, getMessagesSize(get));

    }

    @Test
    public void wrongEmail() {
        MessageRequest newRequest = MessageRequest.builder()
                .name("Przemyslaw")
                .email("jsjsgmail.com")
                .phone("92929283838374")
                .subject("test subject")
                .description("message testmessage testmessage testmessage testmessage test")
                .build();
        RestAssured.baseURI = "https://automationintesting.online/message/";


        int listSize = 0;
        RequestSpecification get = RestAssured.given().config(RestAssured.config()
                .objectMapperConfig(new ObjectMapperConfig(ObjectMapperType.GSON)));
        listSize = getMessagesSize(get);


        System.out.println(listSize);

        RequestSpecification newPost = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(newRequest).config(RestAssured.config()
                        .objectMapperConfig(new ObjectMapperConfig(ObjectMapperType.GSON)));


        Response response = newPost.post();
        ErrorResponse errorResponse = response.as(ErrorResponse.class);


        Assertions.assertEquals(listSize, getMessagesSize(get));
        Assertions.assertEquals("must be a well-formed email address", errorResponse.fieldErrors.get(0));


    }


    private int getMessagesSize(RequestSpecification get) {
        Response responseGet = get.get();
        Messages deserializeObject = responseGet.as(Messages.class);
        return deserializeObject.getMessages().size();

    }

}
