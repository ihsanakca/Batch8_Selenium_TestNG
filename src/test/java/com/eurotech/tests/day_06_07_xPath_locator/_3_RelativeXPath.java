package com.eurotech.tests.day_06_07_xPath_locator;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class _3_RelativeXPath {
    public static void main(String[] args) throws InterruptedException {

        /**
         * Task
         * open chrome browser
         * go to http://www.eurotech.study/
         * click I understand button and accept cookies (use xPath)
         * locate login button (use xPath)
         * click login button
         * locate email address input box (use xPath)
         * send "abc" into email address input box
         * locate second login button (use xPath)
         * click Login button
         * get the message which appears on the email input box and print the message
         * close browser.
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().setPosition(new Point(-1000,0));
        driver.manage().window().maximize();
        driver.get("http://www.eurotech.study/");

        Thread.sleep(2000);

        //accept cookies //lazy way  //elementi xPath ile locate edelim (* kullanımı)
        // ilk yıldız herhangi bir tag name altında ikinci yıldız herhangi bit attriburte değeri (value) rcc-confirm-button
        //olan web element
        driver.findElement(By.xpath("//*[@*='rcc-confirm-button']")).click();
        Thread.sleep(2000);

        //locate Sign in element with xPath then click on element
        WebElement loginBtn = driver.findElement(By.xpath("//*[@class='btn btn-light']"));
        loginBtn.click();
        Thread.sleep(2000);

        //locate email address box with xPath then send keys to the element
        WebElement emailInputBox = driver.findElement(By.xpath("//input[@*='email']"));
        emailInputBox.sendKeys("abc");

        //locate Login Btn with xPath and click on it
        WebElement secondLoginBtn = driver.findElement(By.xpath("//*[@value='Login']"));
        secondLoginBtn.click();
        Thread.sleep(2000);

        //take the message that appears on the email input box and print it
        String validationMessage = emailInputBox.getAttribute("validationMessage");
        System.out.println("validationMessage = " + validationMessage);

        Thread.sleep(2000);

        driver.close();


    }
}
