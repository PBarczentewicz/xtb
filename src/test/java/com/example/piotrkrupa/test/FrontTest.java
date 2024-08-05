package com.example.piotrkrupa.test;

import com.example.piotrkrupa.base.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FrontTest extends BaseTest {

    @Test
    @DisplayName("Wysyłka formularza kontaktowego")
    public void SendContactForm() throws InterruptedException {

        String name = "Piotr";

        //given:
        navigateToHomePage();

        //when:
        homePage.setNameForm(name)
                .setEmailForm("jakis@mail.pl")
                .setPhoneForm("987987654654321")
                .setSubjectForm("something")
                .setMessageForm("message 1 message 1 message 1 message 1message 1 message 1")
                .clickSubmit();

        String excp = "Thanks for getting in touch " + name+ "!";
        //then:
        assertEquals(excp, homePage.getSuccesText(), "Imie nie jest poprawne");
    }
}