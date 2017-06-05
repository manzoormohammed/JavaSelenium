package com.manzoor.javaselenium;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    public static WebDriver Instance;

    public static void initialize() {

        System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\Selenium\\geckodriver.exe"); // needed by new selenium webdriver
        Instance = new FirefoxDriver();
        Instance.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    public static void close() {

        Instance.close();

    }

}
