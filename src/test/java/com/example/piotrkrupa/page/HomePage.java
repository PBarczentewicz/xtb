package com.example.piotrkrupa.page;

import com.example.piotrkrupa.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
}