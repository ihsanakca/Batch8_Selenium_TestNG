package com.eurotech.tests.day_24_miscellaneous;


import com.eurotech.utilities.ConfigurationReader;
import com.eurotech.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;

public class _01_RobotClass {


    @Test
    public void robotClassBasicAuthentication() throws AWTException, InterruptedException {
        /**
         * navigate to https://the-internet.herokuapp.com/digest_auth
         * Type in username and password by using robot class
         * Click Sign in button
         *
         * Note: 1- use us Q keyboard
         *       2- username: admin and password:admin
         */



        WebDriver driver = Driver.get();
        driver.manage().window().setPosition(new Point(-1000, 0));
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/digest_auth");

        Robot robot = new Robot();
//        robot.keyPress(KeyEvent.VK_SHIFT);
//        robot.keyPress(KeyEvent.VK_A);    --- buyuk a yazmak icin
//        robot.keyRelease(KeyEvent.VK_SHIFT);

        robot.keyPress(KeyEvent.VK_A);
        robot.keyPress(KeyEvent.VK_D);
        robot.keyPress(KeyEvent.VK_M);
        robot.keyPress(KeyEvent.VK_I);
        robot.keyPress(KeyEvent.VK_N);

        robot.keyPress(KeyEvent.VK_TAB);

        robot.keyPress(KeyEvent.VK_A);
        robot.keyPress(KeyEvent.VK_D);
        robot.keyPress(KeyEvent.VK_M);
        robot.keyPress(KeyEvent.VK_I);
        robot.keyPress(KeyEvent.VK_N);

        Thread.sleep(1000);

        robot.keyPress(KeyEvent.VK_TAB);
        Thread.sleep(2000);
        robot.keyPress(KeyEvent.VK_ENTER);
        Thread.sleep(2000);
        robot.keyPress(KeyEvent.VK_ENTER);
        Thread.sleep(2000);

        WebElement element = driver.findElement(By.tagName("p"));

        String actualText = element.getText();
        String expectedText = "Congratulations! You must have the proper credentials.";

        Assert.assertEquals(actualText, expectedText);

        Thread.sleep(3000);
        driver.quit();

    }

    @Test
    public void basicAuthentication() throws InterruptedException {

        /**
         * navigate to https://the-internet.herokuapp.com/digest_auth
         * use short way to sign in for basic authentication
         */

        WebDriver driver = Driver.get();
        driver.manage().window().setPosition(new Point(-1000, 0));
        driver.manage().window().maximize();

        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");

        WebElement element = driver.findElement(By.tagName("p"));

        String actualText = element.getText();
        String expectedText = "Congratulations! You must have the proper credentials.";

        Assert.assertEquals(actualText, expectedText);

        Thread.sleep(3000);
        driver.quit();

    }

    @Test
    public void test3() throws AWTException, InterruptedException {
        /**
         * navigate to kraft login page
         * Press tab with robot class
         * Type in user email and password by using robot class (email: Aadmın, password:admın)
         * Click Create an account link
         * Verify that create an account page is displayed

         */

        WebDriver driver = Driver.get();
        driver.manage().window().setPosition(new Point(-1000, 0));
        driver.manage().window().maximize();
        driver.get(ConfigurationReader.get("url"));

        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_TAB);


        robot.keyPress(KeyEvent.VK_SHIFT);
        robot.keyPress(KeyEvent.VK_A);    //--- buyuk a yazmak icin
        robot.keyRelease(KeyEvent.VK_SHIFT);

        robot.keyPress(KeyEvent.VK_A);
        robot.keyPress(KeyEvent.VK_D);
        robot.keyPress(KeyEvent.VK_M);
        robot.keyPress(KeyEvent.VK_I);
        robot.keyPress(KeyEvent.VK_N);

        robot.keyPress(KeyEvent.VK_TAB);

        robot.keyPress(KeyEvent.VK_A);
        robot.keyPress(KeyEvent.VK_D);
        robot.keyPress(KeyEvent.VK_M);
        robot.keyPress(KeyEvent.VK_I);
        robot.keyPress(KeyEvent.VK_N);


        Thread.sleep(1000);
        robot.keyPress(KeyEvent.VK_TAB);
        Thread.sleep(1000);
        robot.keyPress(KeyEvent.VK_TAB);
        Thread.sleep(1000);
        robot.keyPress(KeyEvent.VK_TAB);
        Thread.sleep(2000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyPress(KeyEvent.VK_ENTER);

        WebElement element = driver.findElement(By.tagName("h5"));

        String actualText = element.getText();
        String expectedText = "Create an Account";

        Assert.assertEquals(actualText, expectedText);

    }
}
