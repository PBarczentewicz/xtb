package com.example.piotrkrupa.test;

import com.example.piotrkrupa.base.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FrontTest extends BaseTest {

    @Test
    @DisplayName("Wysyłka formularza kontaktowego")
    public void SendContactForm() throws InterruptedException {

        navigateToHomePage();
        homePage.setNameForm("Piotr")
                .setEmailForm("jakis@mail.pl");



    }
}