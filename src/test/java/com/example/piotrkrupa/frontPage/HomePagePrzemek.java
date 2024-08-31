package com.example.piotrkrupa.frontPage;

import com.example.piotrkrupa.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePagePrzemek extends BasePage {

    private final WebDriver driver;

    public HomePagePrzemek(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }


    public HomePagePrzemek setName(String name) {
        findById("name").sendKeys(name);
        return this;
    }

    public HomePagePrzemek setLastName(String lastname) {
        findById("lastname").sendKeys(lastname);
        return this;
    }

    public HomePagePrzemek setEmail(String email) {
        findById("email").sendKeys(email);
        return this;
    }

    public HomePagePrzemek setPhone(String phone) {
        findByXpath("//*[@id='phone']").sendKeys(phone);
        return this;
    }

    public HomePagePrzemek setSubject(String subject) {
        findById("subject").sendKeys(subject);
        return this;
    }

    public HomePagePrzemek setMessage(String message) {
        findById("description").sendKeys(message);
        return this;
    }

    public HomePagePrzemek clickSubmitButton() {
        findById("submitContact").click();
        return this;
    }

    public String verifySuccesText() {
        return findByXpath("//*[@id=\"root\"]/div[2]/div/div[5]/div[2]/div/h2").getText();
    }

    public HomePagePrzemek setUsername(String username) {
        findById("username").sendKeys(username);
        return this;
    }

    public HomePagePrzemek setPassword(String password) {
        findById("password").sendKeys(password);
        return this;
    }

    public HomePagePrzemek clickLoginButton() {
        findById("doLogin").click();
        return this;
    }

    public HomePagePrzemek setRoomNumber (String roomNumber) {
        findById("roomName").sendKeys(roomNumber);
        return this;
    }

    public HomePagePrzemek setRoomType (String roomType) {
        findById("type").sendKeys(roomType);
        return this;
    }

    public HomePagePrzemek setAccessible (String accessible) {
        findById("accessible").sendKeys(accessible);
        return this;
    }

    public HomePagePrzemek setPrice (String price) {
        findById("roomPrice").sendKeys(price);
        return this;
    }

    public HomePagePrzemek setRoomDetailsWiFi (String roomDetailsWiFi) {
        findById("wifiCheckbox").sendKeys(roomDetailsWiFi);
        return this;
    }

    public HomePagePrzemek clickCreate () {
        findById("createRoom").click();
        return this;
    }

    public boolean isRoomAddes (String roomNumber){
        findById("roomName"+roomNumber).sendKeys(roomNumber);
        return true;
    }

    public List<WebElement> getRoomRow (){
        return findElementsByXpath("//*[@data-testid='roomlisting']");
    }
}
