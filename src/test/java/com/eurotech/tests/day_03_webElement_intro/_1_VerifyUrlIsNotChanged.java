package com.eurotech.tests.day_03_webElement_intro;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class _1_VerifyUrlIsNotChanged {
    public static void main(String[] args) throws InterruptedException {
        /**
         * Task
         * open chrome browser
         * go to https://demoqa.com/login
         * click on login button
         * VERIFY that url is not changed
         */

        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().setPosition(new Point(-1000, 0));
        driver.manage().window().maximize();

        //navigate to web page
        driver.navigate().to("https://demoqa.com/login");

        Thread.sleep(3000);

        String expectedUrl=driver.getCurrentUrl();

        //get the login button and put it in a web element bucket
        WebElement loginButton=driver.findElement(By.id("login"));
        //click on login button through click() method
        loginButton.click();
        Thread.sleep(3000);

        String actualUrl=driver.getCurrentUrl();

        if (actualUrl.equals(expectedUrl)){
            System.out.println("Pass");
        }else {
            System.out.println("Failed");
        }

        driver.close();




    }
}
