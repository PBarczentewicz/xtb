package com.example.piotrkrupa.frontPage;

import com.example.piotrkrupa.base.BasePage;
import org.openqa.selenium.WebDriver;

public class HomePagePrzemek extends BasePage {

    private final WebDriver driver;

    public HomePagePrzemek(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }


    public HomePagePrzemek setName (String name){
        findById("name").sendKeys(name);
        return this;
    }

    public HomePagePrzemek setLastName (String lastname){
        findById("lastname").sendKeys(lastname);
        return this;
    }

    public HomePagePrzemek setEmail (String email){
        findById("email").sendKeys(email);
        return this;
    }

    public HomePagePrzemek setPhone (String phone){
        findByXpath("//*[@id='phone']").sendKeys(phone);
        return this;
    }

    public HomePagePrzemek setSubject (String subject){
        findById("subject").sendKeys(subject);
        return this;
    }

    public HomePagePrzemek setMessage (String message){
        findById("description").sendKeys(message);
        return this;
    }

    public HomePagePrzemek clickSubmitButton (){
        findById("submitContact").click();
        return this;
    }

    public String verifySuccesText(){
        return findByXpath("//*[@id=\"root\"]/div[2]/div/div[5]/div[2]/div/h2").getText();
    }
}
