package com.example.piotrkrupa;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

public class MailService {

    public JSONObject getMail()  {
        RestAssured.baseURI = "https://restmail.net/mail";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("/tester890");
        String stringRespone = response.asString().substring(1);
        stringRespone = stringRespone.substring(0, stringRespone.length() - 1);

        JSONObject jsonObject = new JSONObject(stringRespone);
        System.out.println(jsonObject);
        return jsonObject;
    }

    public void clearMail()  {
        RestAssured.baseURI = "https://restmail.net/mail";
        RequestSpecification httpRequest = RestAssured.given();
        httpRequest.delete("/tester890");
    }
}
