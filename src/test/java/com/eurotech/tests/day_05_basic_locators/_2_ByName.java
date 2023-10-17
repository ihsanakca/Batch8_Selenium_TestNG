package com.eurotech.tests.day_05_basic_locators;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class _2_ByName {
    public static void main(String[] args) throws InterruptedException {
        /**
         * open chrome browser and navigate to https://testpages.herokuapp.com/styled/basic-html-form-test.html
         * locate username input box by using name locator
         * send a random name to the box
         * clear the box
         * send another name to the box
         * get the second name which sent to the box and assign it to a string variable
         * print the second name
         * close driver.
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().setPosition(new Point(-1000,0));
        driver.manage().window().maximize();
        driver.get("https://testpages.herokuapp.com/styled/basic-html-form-test.html");

        Thread.sleep(2000);

        //By name
        //send a name to the box by lazy way
        driver.findElement(By.name("username")).sendKeys("Mark Ruffalo");

        Thread.sleep(2000);

        //second way
        WebElement usernameBox = driver.findElement(By.name("username"));
        //daha önce gönderdiğimiz ismi silelim
        usernameBox.clear();
        Thread.sleep(2000);
        //başka bir isim gönderelim
        usernameBox.sendKeys("Tracy McGrady");
        // ikinci gönderilen isimi bir stringe alalım ve konsola yazdıralım.
        String secondName = usernameBox.getAttribute("value");
        System.out.println("secondName = " + secondName);

        Thread.sleep(2000);

        driver.close();
    }
}
/**
 * 1. id.ler gibi dinamik olmazlar..
 * 2. ancak birden fazla web elementin name attribute değeri aynı olabilir. Bu durumda locate işleminde kullanılmaları halinde
 * selenium her zaman ilkine gider ve o web element ile işlem yapar..
 *
 */