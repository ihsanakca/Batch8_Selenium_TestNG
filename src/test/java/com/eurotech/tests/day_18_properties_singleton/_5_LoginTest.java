package com.eurotech.tests.day_18_properties_singleton;

import com.eurotech.tests.TestBase;
import com.eurotech.utilities.ConfigurationReader;
import com.eurotech.utilities.Driver;
import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class _5_LoginTest extends TestBase {
//    WebDriver driver;
//
//    @BeforeMethod
//    public void setUp() {
//        driver = Driver.get();
//        driver.manage().window().setPosition(new Point(-1000, 0));
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//
//    }

    @Test
    public void LoginTest() {
        driver.get(ConfigurationReader.get("url"));
        driver.findElement(By.id("email")).sendKeys(ConfigurationReader.get("userEmail"));
        driver.findElement(By.id("yourPassword")).sendKeys(ConfigurationReader.get("password") + Keys.ENTER);

    }
//    @AfterMethod
//    public void tearDown() {
//        Driver.closeDriver();
//    }
}
/**
 * go to kraft login page
 * login with your credentials
 * validate that you are on the dashboard with url
 */