package com.example.piotrkrupa.page;

import com.example.piotrkrupa.base.BasePage;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AuthorisationPage extends BasePage {

    private final WebDriver driver;

    public AuthorisationPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public String getVerificationCode(JSONObject mailJson) {
        String verificationCode = null;
        Pattern pattern = Pattern.compile("(?<!\\d)\\d{6}(?!\\d)");
        Matcher matcher = pattern.matcher(mailJson.get("text").toString());
        while (matcher.find()) {
            verificationCode = matcher.toMatchResult().group();
        }

        return verificationCode;
    }

    public AuthorisationPage fillAuthCode(String authCode) {
        findByXpath("//input[@class='authenticationCode']").sendKeys(authCode);

        return this;
    }

    public AuthorisationPage submitAuthCode() {
        findByXpath("//input[@type='submit']").click();

        return this;
    }

    public AuthorisationPage cancelAuth() {
        findByXpath("//*[@class='buttonCancel']").click();

        return this;
    }

    public String getErrorText() {
        return findByXpath("//*[@class='veryficationStatus error']").getText();
    }

    public AuthorisationPage resendEmail() {
        findByXpath("//*[@class='resend resendEmail']").click();
        return this;
    }

    public String getResendText() {
        return findByXpath("//*[@class='veryficationStatus success']").getText();
    }
}