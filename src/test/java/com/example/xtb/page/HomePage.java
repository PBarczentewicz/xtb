package com.example.xtb.page;

import com.example.xtb.base.BasePage;
import com.example.xtb.service.Utylities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HomePage extends BasePage {

    private final WebDriver driver;

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public HomePage setEmail(String email) {
        findByXpath("//input[@name='xslogin']").sendKeys(email);
        return this;
    }

    public HomePage setPassword(String password) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.attributeToBeNotEmpty(findByXpath("//input[@name='xslogin']"), "value"));

        findByXpath("//input[@name='xspass']").sendKeys(password);
        return this;
    }

    public HomePage clickLoginButton() {
        findByXpath("//input[@value='Login']").click();
        return this;
    }

    public void assertLoggin() {
        String curentUrl = driver.getCurrentUrl();
        assertEquals((new Utylities().getExpectedUrl()), curentUrl);
    }

    public void waitForCompleteWebsite() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.urlContains(new Utylities().getExpectedUrl()));
    }
}