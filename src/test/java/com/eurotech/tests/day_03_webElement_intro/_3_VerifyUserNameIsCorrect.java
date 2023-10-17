package com.eurotech.tests.day_03_webElement_intro;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class _3_VerifyUserNameIsCorrect {
    public static void main(String[] args) throws InterruptedException {
        /**
         * Task
         * open chrome browser
         * go to "https://demoqa.com/login"
         * enter "test" into the username box
         * VERIFY that "test" is displayed in the username box
         * enter "Test.!123" into the password box
         * click on login button
         * VERIFY that username is "test"
         */
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().setPosition(new Point(-1000, 0));
        driver.manage().window().maximize();

        driver.get("https://demoqa.com/login");

        Thread.sleep(2000);

        String expectedUserName="test";

        WebElement inputUserName=driver.findElement(By.id("userName"));
        inputUserName.sendKeys(expectedUserName);
        Thread.sleep(2000);

        //how to get attribute value
        String actualUserName = inputUserName.getAttribute("value");
        System.out.println("actualUserName = " + actualUserName);

        if(actualUserName.equals(expectedUserName)){
            System.out.println("Pass");
        }else{
            System.out.println("Failed");
        }

        WebElement inputPassword=driver.findElement(By.id("password"));
        inputPassword.sendKeys("Test.!123");
        Thread.sleep(2000);

        WebElement loginButton=driver.findElement(By.id("login"));
        loginButton.click();
        Thread.sleep(2000);

        WebElement userName=driver.findElement(By.id("userName-value"));

        //get the string of web element
        String actualUserNameText = userName.getText();

        if(actualUserNameText.equals(expectedUserName)){
            System.out.println("Pass");
        }else{
            System.out.println("Failed");
        }

        driver.close();
    }
}
