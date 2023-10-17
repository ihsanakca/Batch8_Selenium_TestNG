package com.eurotech.tests.day_03_webElement_intro;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class _5_GetAttribute_Practice {
    public static void main(String[] args) throws InterruptedException {

        /**
         * Task
         * open chrome browser
         * go to http://www.eurotech.study/
         * click I understand button and accept cookies
         * take the value of the attributes (class and href) of the login button and print the values.
         * click login button
         * send "sdfsdsd" into email address input box
         * click Login button
         * get the message which appears on the email input box
         * VERIFY that the message contains "Please include an '@' in the email address."
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().setPosition(new Point(-1000, 0));
        driver.manage().window().maximize();

        driver.get("http://www.eurotech.study/");

        //lazy way to click a web element
        driver.findElement(By.id("rcc-confirm-button")).click();

        WebElement loginBtn = driver.findElement(By.xpath("//a[@class='btn btn-light']"));
        //to get value of an attribute and print it.
        System.out.println("loginBtn.getAttribute(\"class\") = " + loginBtn.getAttribute("class"));
        System.out.println("loginBtn.getAttribute(\"href\") = " + loginBtn.getAttribute("href"));
        loginBtn.click();


        WebElement emailInputBox = driver.findElement(By.id("loginpage-input-email"));
        emailInputBox.sendKeys("sdfsdsd");

        //lazy way
        driver.findElement(By.id("loginpage-form-btn")).click();

        String actualMessage = emailInputBox.getAttribute("validationMessage");
        System.out.println("actualMessage = " + actualMessage);
        Thread.sleep(3000);
        String expectedMessage = "Please include an '@' in the email address.";

        if (actualMessage.contains(expectedMessage)) {
            System.out.println("Pass");
        } else {
            System.out.println("Failed");
        }

        Thread.sleep(3000);
        driver.close();
    }
}
