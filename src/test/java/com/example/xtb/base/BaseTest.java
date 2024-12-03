package com.example.xtb.base;

import com.example.xtb.drivermenager.DriverManager;
import com.example.xtb.drivermenager.DriverManagerFactory;
import com.example.xtb.drivermenager.DriverType;
import com.example.xtb.page.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;
    DriverManager driverManager;
    protected HomePage homePage;


    @BeforeEach
    protected void setUp() {
        driverManager = DriverManagerFactory.getManager(DriverType.CHROME);
        driver = driverManager.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://xstation5.xtb.com/?branch=pl#/_/login");
        navigateToHomePage();
    }

    @AfterEach
    public void tearDown() {
        driverManager.quitDriver();
    }

    protected HomePage navigateToHomePage() {
        homePage = PageFactory.initElements(driver, HomePage.class);
        return homePage;
    }
}
