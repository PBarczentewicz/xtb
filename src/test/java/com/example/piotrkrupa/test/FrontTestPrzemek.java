package com.example.piotrkrupa.test;

import com.example.piotrkrupa.base.BaseTest;
import com.example.piotrkrupa.frontPage.HomePagePrzemek;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class FrontTestPrzemek extends BaseTest {

    @Test
    public void sendContactForm() {

        navigateToHomePagePrzemek();

        String name = "Przemek";

        homePagePrzemek
                .setName(name)
                .setEmail("Test@tes.pl")
                .setPhone("987654567889098")
                .setSubject("sjhsshshshshshshshshs")
                .setMessage("dssssssssssssssssssssssssssssssssssssssssssssssss")
                .clickSubmitButton();

        Assertions.assertEquals("Thanks for getting in touch " + name + "!", homePagePrzemek.verifySuccesText());
    }

    @Test
    public void addNewRoom() {

        navigateToHomePagePrzemek();

        homePagePrzemek
                .setUsername("admin")
                .setPassword("password")
                .clickLoginButton();

        int list = 0;
        list = homePagePrzemek.getRoomRow().size();

        String roomNumber = "107";

        homePagePrzemek
                .setRoomNumber(roomNumber)
                .setRoomType("Single")
                .setAccessible("false")
                .setPrice("120")
                .clickCreate();

        Assertions.assertEquals(list, homePagePrzemek.getRoomRow().size() - 1);
    }
}
