package com.example.piotrkrupa.drivermenager;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxDriverManager extends DriverManager {

    @Override
    public void createDriver() {
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("test-type");
        driver = new FirefoxDriver();
    }
}