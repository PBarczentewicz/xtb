package com.example.piotrkrupa.test;

import ProjectData.BookingForm;
import ProjectData.WebData;
import com.example.piotrkrupa.base.BaseTest;
import com.example.piotrkrupa.page.HomePage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

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

        String excp = "Thanks for getting in touch " + name + "!";
        //then:
        assertEquals(excp, homePage.getSuccesText(), "Imie nie jest poprawne");
    }

    @Test
    public void setRoomForm() {
        navigateToHomePage();

        homePage.setFirstName("Jan")
                .setLastName("Testowy")
                .setEmailForm("jan@testowy.pl")
                .setPhoneForm("123456789987")
                .setCheckIn("2024-08-01")
                .setCheckOut("2024-08-03")
                .clickBookButton();

        String exceptionFromWeb = String.valueOf(homePage.findByXpath("/html/body/div[4]/div/div/div[1]/div[2]/h3"));
        String expectText = "Booking Successful!";

        assertEquals(expectText, exceptionFromWeb);
    }
}