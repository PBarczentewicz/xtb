package com.example.piotrkrupa.page;

import com.example.piotrkrupa.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

    private final WebDriver driver;

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public HomePage setNameForm(String name){
        findById("name").sendKeys(name);
        return this;
    }

    public HomePage setEmailForm(String emailForm){
        findById("name").sendKeys(emailForm);
        return this;
    }


}