package com.example.piotrkrupa.test;

import com.example.piotrkrupa.base.BaseTest;
import com.example.piotrkrupa.frontPage.HomePagePrzemek;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FrontTestPrzemek extends BaseTest {

    @Test
    public void sendCotanctForm (){

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


}
