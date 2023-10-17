package com.eurotech.tests.day_03_webElement_intro;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class _2_VerifyUrlIsChanged {
    public static void main(String[] args) throws InterruptedException {
        /**
         * Task
         * open chrome browser
         * go to "https://demoqa.com/login"
         * enter "test" into the username box
         * enter "Test.!123" into the password box
         * click on login button
         * VERIFY that url is changed as "https://demoqa.com/profile"
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().setPosition(new Point(-1000, 0));
        driver.manage().window().maximize();

        driver.get("https://demoqa.com/login");

        Thread.sleep(2000);

        //get the username and put it in a web element bucket
        WebElement inputUserName=driver.findElement(By.id("userName"));
        //enter data by using sendKeys() method
        inputUserName.sendKeys("test");
        Thread.sleep(2000);

        WebElement inputPassword=driver.findElement(By.id("password"));
        inputPassword.sendKeys("Test.!123");
        Thread.sleep(2000);

        WebElement loginButton=driver.findElement(By.id("login"));
        loginButton.click();
        Thread.sleep(2000);

        String actualUrl=driver.getCurrentUrl();
        String expectedUrl="https://demoqa.com/profile";

        if (actualUrl.equals(expectedUrl)){
            System.out.println("Pass");
        }else {
            System.out.println("Failed");
        }

       driver.close();

    }

}
