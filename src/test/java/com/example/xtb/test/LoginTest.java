package com.example.xtb.test;

import com.example.xtb.service.Utylities;
import com.example.xtb.base.BaseTest;
import org.junit.jupiter.api.Test;

public class LoginTest extends BaseTest {

    @Test
    public void login(){
        navigateToHomePage();
        Utylities utylities = new Utylities();

        homePage.setEmail(utylities.getEmail())
                .setPassword(utylities.getPassword())
                .clickLoginButton();

        homePage.waitForCompleteWebsite();
        homePage.assertLoggin();
    }
}
