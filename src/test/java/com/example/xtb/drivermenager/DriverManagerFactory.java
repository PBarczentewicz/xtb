package com.example.xtb.drivermenager;

public class DriverManagerFactory {

    public static DriverManager getManager(DriverType type)  {

        DriverManager driverManager;

        switch (type) {
            case FIREFOX:
                driverManager = new FirefoxDriverManager();
                break;
            case CHROME:
                driverManager = new ChromeDriverManager();
                break;
            default:
                driverManager = new ChromeDriverManager();
                break;
        }
        return driverManager;
    }
}