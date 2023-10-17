package com.eurotech.tests.day_20_pom_2;

import com.eurotech.utilities.ConfigurationReader;
import com.eurotech.utilities.Driver;
import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class _4_StaleElement {

    @Test
    public void staleElement() {

        /**
         * go to kraft login page
         * enter your email and pass
         * refresh page
         * enter email and pass again
         * click login
         * enter the web page
         *
         * how to handle stale element problem...
         * stale element hatasını nasıl çözeriz..
         */



        WebDriver  driver = Driver.get();
        driver.manage().window().setPosition(new Point(-1000, 0));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfigurationReader.get("url"));

        WebElement emailBox = driver.findElement(By.id("email"));
        WebElement passwordBox = driver.findElement(By.id("yourPassword"));
        WebElement loginButton = driver.findElement(By.xpath("//*[text()='Login']"));

        emailBox.sendKeys(ConfigurationReader.get("userEmail"));
        passwordBox.sendKeys(ConfigurationReader.get("password"));

        driver.navigate().refresh();

        try {
            emailBox.sendKeys(ConfigurationReader.get("userEmail"));
            passwordBox.sendKeys(ConfigurationReader.get("password"));
            loginButton.click();
        }catch(StaleElementReferenceException e) {
            emailBox = driver.findElement(By.id("email"));
            passwordBox = driver.findElement(By.id("yourPassword"));
            loginButton = driver.findElement(By.xpath("//*[text()='Login']"));

            emailBox.sendKeys(ConfigurationReader.get("userEmail"));
            passwordBox.sendKeys(ConfigurationReader.get("password"));
            loginButton.click();

            e.printStackTrace();
        }
        driver.quit();


    }
}
