package com.example.piotrkrupa.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {
    WebDriver driver;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement findById(String id) {
        return  driver.findElement(By.id(id));
    }

    public WebElement findByXpath(String xpath) {
        return  driver.findElement(By.xpath(xpath));
    }

    public Boolean isElementExist(String xpath){
        return  !driver.findElements(By.xpath(xpath)).isEmpty();
    }
}