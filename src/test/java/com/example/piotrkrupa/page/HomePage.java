package com.example.piotrkrupa.page;

import com.example.piotrkrupa.base.BasePage;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private final WebDriver driver;

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public String getLoggedUser(){
        return findById("login_user_name").getAttribute("textContent");
    }

}