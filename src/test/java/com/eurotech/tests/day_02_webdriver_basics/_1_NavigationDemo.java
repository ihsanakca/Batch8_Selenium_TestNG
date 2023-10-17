package com.eurotech.tests.day_02_webdriver_basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class _1_NavigationDemo {
    public static void main(String[] args) throws InterruptedException {
        /**
         * set up a firefox(chrome) driver
         * navigate to https://www.facebook.com/
         * then navigate to https://testrelic.com/
         * then navigate back
         * then navigate forward
         * then refresh page
         * then close driver
         */

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver=new FirefoxDriver();

        driver.manage().window().setPosition(new Point(-1000,0));
        driver.manage().window().maximize();

        driver.get("https://www.facebook.com/");
        Thread.sleep(2000);

        //navigate to another web page
        driver.navigate().to("https://testrelic.com/");
        Thread.sleep(2000);

        //navigate back
        driver.navigate().back();
        Thread.sleep(2000);

        //navigate forward
        driver.navigate().forward();
        Thread.sleep(2000);

        //refresh page
        driver.navigate().refresh();


    }
}
