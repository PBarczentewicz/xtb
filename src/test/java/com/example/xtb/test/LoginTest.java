package com.example.xtb.test;

import com.example.xtb.service.Utylities;
import com.example.xtb.base.BaseTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LoginTest extends BaseTest {
    @Test
    public void login() {
        navigateToHomePage();
        Utylities utylities = new Utylities();

        homePage.setEmail(utylities.getEmail())
                .setPassword(utylities.getPassword())
                .clickLoginButton();

        homePage.waitForCompleteWebsite();
        homePage.assertLoggin();
    }
    @ParameterizedTest
    @CsvSource({
            "p.barczentewicz@gmail.com, HasloTestowe1@, success",
            "testowy@mail.pl,HasloTestowe1@, wrongEmail",
            "testowy@mail.pl, WrongPassword, wrongEmailWrongPassword",
            "p.barczentewicz@gmail.com, WrongPassword, wrongPassword",
    })
    public void loginWithParametrized(String email, String password, String confirmation) {
        navigateToHomePage();
        homePage.setEmail(email)
                .setPassword(password)
                .clickLoginButton();

        homePage.assertParametrizedTest(confirmation);
    }
}
