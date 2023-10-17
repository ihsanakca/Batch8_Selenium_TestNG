package com.eurotech.tests.day_05_basic_locators;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.*;

public class _7_BasicLocatorsReview {
    public static void main(String[] args) throws InterruptedException {

        /**
         * Task
         * open a chrome browser driver and navigate to https://www.demoblaze.com/
         * locate Sign up link by using id and get text of web element then print the text
         * locate previous and next link at the bottom of the page by using name and get text of web element then print the text
         * locate Samsung Galaxy S6 by using tagname and get text of web element then print the text
         * locate Product Store at the left top of the page by using class name and get text of web element then print the text
         * locate Nokia Lumia 1520 by using link text and get text of web element then print the text
         * locate Nexus 6 by using partial link text and get text of web element then print the text
         * close the driver
         */


        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().setPosition(new Point(-1000, 0));
        driver.manage().window().maximize();

        driver.get("https://www.demoblaze.com/");
        Thread.sleep(2000);

        //id
        WebElement loginLink = driver.findElement(By.id("signin2"));
        System.out.println("loginLink.getText() = " + loginLink.getText());

        WebElement loginLink1 = driver.findElement(new By.ById("signin2"));
        System.out.println("loginLink1.getText() = " + loginLink1.getText());

        //name
        WebElement frmElement = driver.findElement(By.name("frm"));
        System.out.println("frmElement.getText() = " + frmElement.getText());

        //tagname
        WebElement samsungGalaxyS6 = driver.findElement(By.tagName("h4"));
        System.out.println("samsungGalaxyS6.getText() = " + samsungGalaxyS6.getText());

        //className
        WebElement productStore = driver.findElement(By.className("navbar-brand"));
        System.out.println("productStore.getText() = " + productStore.getText());

        //link text
        WebElement nokia = driver.findElement(By.linkText("Nokia lumia 1520"));
        System.out.println("nokia.getText() = " + nokia.getText());

        //partial link text
        WebElement nexus = driver.findElement(By.partialLinkText("Nexu"));
        System.out.println("nexus.getText() = " + nexus.getText());


        // çok gerekli olmayan diğer bazı web element metodları
        System.out.println("nexus.getTagName() = " + nexus.getTagName());
        System.out.println("nexus.getLocation() = " + nexus.getLocation());
        System.out.println("nexus.getSize() = " + nexus.getSize());
        System.out.println("nexus.getRect().getDimension() = " + nexus.getRect().getDimension());
        System.out.println("nexus.getCssValue(\"font-size\") = " + nexus.getCssValue("font-size"));

        driver.close();

    }
}
