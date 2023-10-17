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

public class _2_RadioButtons {

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
    public void radioButtonTest() throws InterruptedException {
        /**
         * navigate to http://www.webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html
         * locate yellow element
         * verify that the element is NOT selected
         * click the element
         * verify that the element is selected
         *
         * locate blue element
         * verify that the element is displayed
         * click the element
         * verify that the blue element is selected
         * verify that the yellow element is NOT selected
         */

        driver.get("http://www.webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");

        //locate yellow element
        WebElement yellowRadioBtn = driver.findElement(By.cssSelector("[value='yellow']"));
        //verify that the element is NOT selected
        Assert.assertFalse(yellowRadioBtn.isSelected());
        //click the element
        yellowRadioBtn.click();
        Thread.sleep(2000);
        //verify that the element is selected
        Assert.assertTrue(yellowRadioBtn.isSelected());

        //locate blue element
        WebElement blueRadioBtn = driver.findElement(By.cssSelector("[value='blue']"));
        //verify that the element is displayed
        Assert.assertTrue(blueRadioBtn.isDisplayed());
        //click the element
        blueRadioBtn.click();
        Thread.sleep(2000);

        //verify that the element is selected
        System.out.println("blueRadioBtn.isSelected() = " + blueRadioBtn.isSelected());
        Assert.assertTrue(blueRadioBtn.isSelected());
        Assert.assertFalse(yellowRadioBtn.isSelected());
    }

    @Test
    public void radioButton_Task() throws InterruptedException {
        /**
         * https://demoqa.com/automation-practice-form
         * locate female gender element
         * verify that the element is NOT selected
         * verify that the element is displayed
         * click the element
         * verify that the element is selected
         * ipucu: eğer elementten istediğiniz sonucu alamıyorsanız.. aynı yeri gösteren diğer elementleri deneyin....!!!!
         */

        driver.get("https://demoqa.com/automation-practice-form");
        //locate female gender element
        WebElement femaleRadioBtn= driver.findElement(By.cssSelector("[for='gender-radio-2']"));
        WebElement femaleRadioBtn_1= driver.findElement(By.xpath("//input[@value='Female']"));
        //verify that the element is NOT selected
        Assert.assertFalse(femaleRadioBtn_1.isSelected());
        //verify that the element is displayed
        Assert.assertTrue(femaleRadioBtn.isDisplayed());
        femaleRadioBtn.click();
        Thread.sleep(2000);
        Assert.assertTrue(femaleRadioBtn_1.isSelected());

    }
}
