package com.eurotech.tests.day_18_properties_singleton;

import com.eurotech.utilities.ConfigurationReader;
import com.eurotech.utilities.Driver;
import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class _1_PropertiesTest {

    @Test
    public void test1() {
        String browserName = ConfigurationReader.get("browser");
        System.out.println("browserName = " + browserName);
    }

    @Test
    public void openBrowserUsingConfigurationReader() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver(ConfigurationReader.get("browser"));
        driver.manage().window().setPosition(new Point(-1000, 0));
        driver.get(ConfigurationReader.get("url"));
        driver.findElement(By.id("email")).sendKeys(ConfigurationReader.get("userEmail"));
        driver.findElement(By.id("yourPassword")).sendKeys(ConfigurationReader.get("password") + Keys.ENTER);
        //  driver.findElement(By.id("yourPassword")).sendKeys(ConfigurationReader.get("password")+ Keys.TAB+Keys.TAB+Keys.TAB+Keys.ENTER);
        Thread.sleep(3000);
        driver.close();
    }
}
