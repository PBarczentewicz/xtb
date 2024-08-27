package com.example.piotrkrupa.test;

import ProjectData.Messages;
import com.example.piotrkrupa.base.BaseTest;
import com.example.piotrkrupa.przemekTestData.MessageRequest;
import dev.failsafe.internal.util.Assert;
import io.restassured.RestAssured;
import io.restassured.config.ObjectMapperConfig;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

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

    @Test
    public void emptyForm() {
        MessageRequest newRequest = MessageRequest.builder()
                .name("")
                .email("")
                .phone("")
                .subject("")
                .description("")
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

        ArrayList<String> expectedResposne = new ArrayList<>();
        expectedResposne.add("Message may not be blank");
        expectedResposne.add("Email may not be blank");
        expectedResposne.add("Phone must be between 11 and 21 characters.");
        expectedResposne.add("Phone may not be blank");
        expectedResposne.add("Message must be between 20 and 2000 characters.");
        expectedResposne.add("Subject may not be blank");
        expectedResposne.add("Name may not be blank");
        expectedResposne.add("Subject must be between 5 and 100 characters.");

        Assertions.assertEquals(listSize, getMessagesSize(get));
        System.out.println("errro response to: " + errorResponse.fieldErrors);

        for (int i = 0; i < expectedResposne.size(); i++) {
            Assertions.assertEquals(expectedResposne.get(i), errorResponse.getFieldErrors().get(i), "bład wpisu na pozycji" + " " + i);
        }
    }


    @Test
    public void secondEmptyForm() {
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
        Assertions.assertEquals("400", errorResponse.errorCode);
        Assertions.assertEquals("BAD_REQUEST", errorResponse.error);
    }


    private int getMessagesSize(RequestSpecification get) {
        Response responseGet = get.get();
        Messages deserializeObject = responseGet.as(Messages.class);
        return deserializeObject.getMessages().size();
    }
}
