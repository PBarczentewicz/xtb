package com.example.piotrkrupa.base;

import com.example.piotrkrupa.drivermenager.DriverManager;
import com.example.piotrkrupa.drivermenager.DriverManagerFactory;
import com.example.piotrkrupa.drivermenager.DriverType;
import com.example.piotrkrupa.page.AuthorisationPage;
import com.example.piotrkrupa.page.CommonPage;
import com.example.piotrkrupa.page.HomePage;
import com.example.piotrkrupa.page.LoginPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class BaseTest {
    WebDriver driver;
    DriverManager driverManager;
    protected LoginPage loginPage;
    protected AuthorisationPage authorisationPage;
    protected CommonPage commonPage;
    protected HomePage homePage;

    @BeforeEach
    protected void setUp() {
        driverManager = DriverManagerFactory.getManager(DriverType.CHROME);
        driver = driverManager.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.nazwa.pl/zaloguj-sie");
        navigateToCommonPage();
    }

    @BeforeEach
    void acceptCookie() {
        commonPage.acceptCookie();
    }

    @AfterEach
    public void tearDown() {
        driverManager.quitDriver();
    }

    protected CommonPage navigateToCommonPage() {
        commonPage = PageFactory.initElements(driver, CommonPage.class);
        return commonPage;
    }

    protected AuthorisationPage navigateToAuthorisationPage() {
        authorisationPage = PageFactory.initElements(driver, AuthorisationPage.class);
        return authorisationPage;
    }

    protected LoginPage navigateToLoginPage() {
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        return loginPage;
    }

    protected HomePage navigateToHomePage() {
        homePage = PageFactory.initElements(driver, HomePage.class);
        return homePage;
    }
}
