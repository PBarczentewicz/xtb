package com.example.piotrkrupa.base;

import com.example.piotrkrupa.drivermenager.DriverManager;
import com.example.piotrkrupa.drivermenager.DriverManagerFactory;
import com.example.piotrkrupa.drivermenager.DriverType;
import com.example.piotrkrupa.frontPage.HomePagePrzemek;
import com.example.piotrkrupa.page.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class BaseTest {
    WebDriver driver;
    DriverManager driverManager;
    protected CommonPage commonPage;
    protected HomePage homePage;
    protected HomePagePrzemek homePagePrzemek;


    @BeforeEach
    protected void setUp() {
        driverManager = DriverManagerFactory.getManager(DriverType.CHROME);
        driver = driverManager.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://automationintesting.online/");
        navigateToCommonPage();
    }


    @AfterEach
    public void tearDown() {
        driverManager.quitDriver();
    }

    protected CommonPage navigateToCommonPage() {
        commonPage = PageFactory.initElements(driver, CommonPage.class);
        return commonPage;
    }

    protected HomePage navigateToHomePage() {
        homePage = PageFactory.initElements(driver, HomePage.class);
        return homePage;
    }

    protected HomePagePrzemek navigateToHomePagePrzemek() {
        homePagePrzemek = PageFactory.initElements(driver, HomePagePrzemek.class);
        return homePagePrzemek;
    }
}
