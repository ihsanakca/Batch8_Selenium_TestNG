package com.eurotech.tests.day_05_basic_locators;

import com.eurotech.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class _8_BasicLocatorTask {
    public static void main(String[] args) throws InterruptedException {
        /** Class Task
         * go to the url - "https://www.browserstack.com/users/sign_up"
         * maximize the window
         * accept cookies if any ,
         * fill in the blanks with the faker class
         * click "Term of service" checkbox
         * and close the window
         *
         * hint: u can use any locator you want
         *
         */

        String browser = "chrome" ;
        WebDriver driver = WebDriverFactory.getDriver(browser);
        driver.manage().window().maximize();
        driver.get("https://www.browserstack.com/users/sign_up");

        WebElement cookiesBtn = driver.findElement(By.id("accept-cookie-notification"));
        cookiesBtn.click();

        Faker faker = new Faker ();
        String fullName= faker.name().fullName();
        String email = faker.internet().emailAddress();
        String password = faker.internet().password();

        WebElement signUpBtn = driver.findElement(By.id("user_full_name"));
        signUpBtn.sendKeys(fullName);

        WebElement emailBtn = driver.findElement(By.id("user_email_login"));
        emailBtn.sendKeys(email);

        WebElement passwordBtn = driver.findElement(By.id("user_password"));
        passwordBtn.sendKeys(password);
        Thread.sleep(1000);

        WebElement checkBox = driver.findElement(By.id("tnc_checkbox"));
        checkBox.click();
        Thread.sleep(2000);

        driver.close();
    }
}
