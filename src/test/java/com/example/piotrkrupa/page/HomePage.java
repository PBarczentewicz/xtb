package com.example.piotrkrupa.page;

import com.example.piotrkrupa.base.BasePage;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HomePage extends BasePage {

    private final WebDriver driver;

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public HomePage setNameForm(String name) {
        findById("name").sendKeys(name);
        return this;
    }

    public HomePage setEmailForm(String emailForm) {
        findById("email").sendKeys(emailForm);
        return this;
    }

    public String getSuccesText() {
        return findByXpath("//*[@id=\"root\"]/div[2]/div/div[5]/div[2]/div/h2").getText();
    }

    public void assertSuccesText(String name){
        String excp = "Thanks for getting in touch " + name+ "!\n";
        //then:
        assertEquals(excp, findByXpath("//*[@id=\"root\"]/div[2]/div/div[5]/div[2]/div/h2").getText() , "Imie nie jest poprawne");
    }

    public HomePage setPhoneForm(String phoneForm) {
        findById("phone").sendKeys(phoneForm);
        return this;
    }

    public HomePage setSubjectForm(String subjectForm) {
        findById("subject").sendKeys(subjectForm);
        return this;
    }

    public HomePage setMessageForm(String messageForm) {
        findById("description").sendKeys(messageForm);
        return this;
    }

    public HomePage clickSubmit(){
        findByXpath("//*[@id=\"submitContact\"]").click();
        return  this;
    }

    public HomePage setCheckIn(String checkIn) {
        findById("checkin").sendKeys(checkIn);
        return this;
    }

    public HomePage setCheckOut(String checkOut) {
        findById("checkout").sendKeys(checkOut);
        return this;
    }

    public HomePage setLastName(String lastName) {
        findById("lastname").sendKeys(lastName);
        return this;
    }
    public HomePage setFirstName(String firstName) {
        findById("firstname").sendKeys(firstName);
        return this;
    }

    public HomePage clickBookButton(){
        findByXpath("/html/body/div/div/div/div[4]/div/div[2]/div[3]/button[2]").click();
        return  this;
    }

    public String getSuccesBookText() {
        return findByXpath("/html/body/div[4]/div/div/div[1]/div[2]/p[1]").getText();
    }
}