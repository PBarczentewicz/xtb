package com.example.xtb.page;

import com.example.xtb.base.BasePage;
import com.example.xtb.service.Utylities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HomePage extends BasePage {

    private final WebDriver driver;

    @FindBy(xpath = "//input[@name='xslogin']")
    private WebElement setEmail;
    @FindBy(xpath = "//input[@name='xspass']")
    private WebElement setPassword;
    @FindBy(xpath = "//input[@value='Login']")
    private WebElement clickLoginButton;

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public HomePage setEmail(String email) {
        setEmail.sendKeys(email);
        return this;
    }

    public HomePage setPassword(String password) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.attributeToBeNotEmpty(setEmail, "value"));
        setPassword.sendKeys(password);
        return this;
    }

    public HomePage clickLoginButton() {
        clickLoginButton.click();
        return this;
    }

    public void waitForCompleteWebsite() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.urlContains(new Utylities().getExpectedUrl()));
    }

    public void waitForAllert() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@ng-bind-html='loginErrorMsg']")));
    }

    public void assertLoggin() {
        String curentUrl = driver.getCurrentUrl();
        assertEquals((new Utylities().getExpectedUrl()), curentUrl);
    }

    public void assertSuccesLogin() {
        waitForCompleteWebsite();
        String curentUrl = driver.getCurrentUrl();
        assertEquals((new Utylities().getExpectedUrl()), curentUrl);
    }

    public void assertWrongFillingLoginForm() {
        String wrongEmail = findByXpath("//div[@ng-bind-html='loginErrorMsg']").getText();

        if (wrongEmail.equals("Nieprawidłowe dane logowania. W adresie e-mail i haśle rozróżniana jest wielkość liter.")) {
            assertEquals("Nieprawidłowe dane logowania. W adresie e-mail i haśle rozróżniana jest wielkość liter.", wrongEmail);
        } else if (wrongEmail.equals("Incorrect login credentials. Email and password are case sensitive.")) {
            assertEquals("Incorrect login credentials. Email and password are case sensitive.", wrongEmail);
        }
    }

    public void assertParametrizedTest(String confirmation) {
        switch (confirmation) {
            case "success":
                assertSuccesLogin();
                break;
            case "wrongEmail":
                waitForAllert();
                assertWrongFillingLoginForm();
                break;
            case "wrongEmailWrongPassword":
                waitForAllert();
                assertWrongFillingLoginForm();
                break;
            case "wrongPassword":
                waitForAllert();
                assertWrongFillingLoginForm();
                break;
        }
    }
}