package com.eurotech.tests.day_06_07_xPath_locator;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class _5_RelativeXPath {
    public static void main(String[] args) throws InterruptedException {

        /**
         * class task
         * open chrome browser and go to http://www.eurotech.study/
         * click I understand button and accept cookies (by xPath with contains (attribute))
         * locate sign up by xPath with contains (text)
         * click Sign Up
         * locate Name input box by xPath (starts with) and send to box "Ahmet"
         * locate email input box by xPath (more than one attribute) and send the box "aaa@aaa.com"
         * locate password input box by xPath (more than one attribute with "and") and type in "123456"
         * locate confirm password input box by xPath (more than one attribute with "or") and type in "123456"
         * locate Sign In link by xPath (with index) --- use only tag
         * click Sign In link
         * close browser.
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().setPosition(new Point(-1000,0));
        driver.manage().window().maximize();
        driver.get("http://www.eurotech.study/");

        Thread.sleep(2000);


        //locate cookies by xPath with contains (attribute)
        driver.findElement(By.xpath("//button[contains(@id,'rcc')]")).click();
        Thread.sleep(2000);

        //locate sign up by xPath with contains (text)
        WebElement signUpBtn = driver.findElement(By.xpath("//a[contains(text(),'Sign')]"));
        signUpBtn.click();
        Thread.sleep(2000);

        //locate Name input box by xPath (starts with)
        WebElement nameInputBox = driver.findElement(By.xpath("//input[starts-with(@placeholder,'Na')]"));
        nameInputBox.sendKeys("Ahmet");
        Thread.sleep(2000);

        //locate email input box by xPath (more than one attribute) 2,3,4...istediğimiz kadar attribute ekleyebiliriz.
        WebElement emailInputBox = driver.findElement(By.xpath("//input[@type='email'][@name='email']"));
        emailInputBox.sendKeys("aaa@aaa.com");
        Thread.sleep(2000);

        //locate password input box by xPath (more than one attribute with "and")
        WebElement passwordInputBox = driver.findElement(By.xpath("//input[@type='password' and @name='password']"));
        passwordInputBox.sendKeys("123456");
        Thread.sleep(2000);

        //locate confirm password input box by xPath (more than one attribute with "or")
        WebElement confirmPasswordInputBox = driver.findElement(By.xpath("//input[@placeholder='Confirm Password' or @name='password2']"));
        confirmPasswordInputBox.sendKeys("123456");
        Thread.sleep(2000);

        //locate Sign In link by xPath (with index)
        WebElement signInLink = driver.findElement(By.xpath("(//a)[5]"));
        signInLink.click();
        Thread.sleep(2000);

        driver.close();


    }
}
////h3[text()='Deohu']/ancestor::div[@class='ph-item-content grid']//button