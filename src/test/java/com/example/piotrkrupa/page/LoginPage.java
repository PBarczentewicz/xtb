package com.example.piotrkrupa.page;

import com.example.piotrkrupa.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage {

    private final WebDriver driver;

    public String captchaErrorXpath = "//*[@id='loginFormContainer']//*[contains(@class, 'message-text')]";
    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public LoginPage fillLoginPassword(String login, String password) {
        findById("clientLogin").sendKeys(login);
        findById("clientPass").sendKeys(password);

        return this;
    }

    public LoginPage submitLogin() {
        findByXpath("//*[@value= 'Zaloguj się' and @type='submit']").click();

        return this;
    }

    public LoginPage resolveCaptcha(){
        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions
                .frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[starts-with(@name, 'a-') and starts-with(@src, 'https://www.google.com/recaptcha')]")));
        findByXpath("//*[@id='recaptcha-anchor']").click();
        driver.switchTo().defaultContent();

        return this;
    }

    public WebElement getLoginAlert() {

        return findByXpath("//*[@id='loginFormContainer']//*[contains(@class, 'message-text')]");
    }

    public String getAlertRequiredText(String id) {

        return findById(id).getText();
    }
}