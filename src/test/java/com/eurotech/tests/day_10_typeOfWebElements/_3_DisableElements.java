package com.eurotech.tests.day_10_typeOfWebElements;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class _3_DisableElements {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().setPosition(new Point(-1000, 0));
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }

    @Test
    public void disableElements() throws InterruptedException {
        /**
         * go to https://the-internet.herokuapp.com/dynamic_controls
         * locate disable text bar
         * verify that the element is disabled
         * locate and click the Enable button
         * send "The element is now enabled!!" keys to the bar
         * verify that the element is enabled.
         */
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        Thread.sleep(2000);

        WebElement disabledElement = driver.findElement(By.cssSelector("#input-example>input"));
        Assert.assertFalse(disabledElement.isEnabled(), "Verify that element is NOT enable or element is disable");

        //if we click the enable button it will be interactive
        WebElement enableBtn = driver.findElement(By.cssSelector("#input-example>button"));
        enableBtn.click();
        Thread.sleep(4000);
        disabledElement.sendKeys("The element is now enabled!!");

        Assert.assertTrue(disabledElement.isEnabled());

    }

    @Test
    public void disableElement_Task() {
        /**
         * navigate to http://www.webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html
         * locate pumpkin element
         * verify that the element is enabled
         * verify that the element is selected
         * verify that the element is displayed
         * locate cabbage element
         * verify that the element is NOT enabled
         * verify that the element is NOT selected
         * verify that the element is displayed
         */
        driver.get("http://www.webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");
        //locate pumpkin element
        WebElement pumpkin = driver.findElement(By.cssSelector("[value='pumpkin']"));

        // verify that the element is enabled
        // verify that the element is selected
        // verify that the element is displayed
        Assert.assertTrue(pumpkin.isEnabled());
        Assert.assertTrue(pumpkin.isSelected());
        Assert.assertTrue(pumpkin.isDisplayed());

        //locate cabbage element
        WebElement cabbage = driver.findElement(By.cssSelector("[value='cabbage']"));

        // verify that the element is NOT enabled
        // verify that the element is NOT selected
        // verify that the element is displayed
        Assert.assertFalse(cabbage.isEnabled());
        Assert.assertFalse(cabbage.isSelected());
        Assert.assertTrue(cabbage.isDisplayed());

    }
}
