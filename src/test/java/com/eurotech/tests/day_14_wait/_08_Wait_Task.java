package com.eurotech.tests.day_14_wait;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class _08_Wait_Task {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().setPosition(new Point(-1000, 0));
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }

    @Test
    public void waitTask(){
        /**
         * Wait Task
         * navigate to https://testpages.herokuapp.com/styled/dynamic-buttons-disabled.html
         * locate all buttons to a web element list (start, one, two, three) (findElements)
         * Let's click the buttons respectively
         * after the click to  the last button : "All Buttons Clicked" message should be seen at the page.
         * Note: Do not use Thread.sleep(), just use dynamic waits
         *
         *  https://testpages.herokuapp.com/styled/dynamic-buttons-disabled.html sayfasına gidelim
         *  bütün butonları bir list'e alalım (start, one, two, three) (findElements)
         *  butonlara sırasıyla tıklayalım
         *  son butona tıklandıktan sonra "All Buttons Clicked" mesajının ekrana geldiğini text ile doğrulayalım.
         *  Not: Thread.sleep() metodunu kullanmayalım sadece dinamik yani akıllı wait kullanalım...
         */

        driver.get("https://testpages.herokuapp.com/styled/dynamic-buttons-disabled.html");

        WebDriverWait wait = new WebDriverWait(driver, 10);

        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//button"), 4));

        List<WebElement> buttons = driver.findElements(By.xpath("//button"));

        for (WebElement button : buttons) {
            wait.until(ExpectedConditions.elementToBeClickable(button)).click();
        }

        String actualMessage = driver.findElement(By.id("buttonmessage")).getText();
        String expectedMessage = "All Buttons Clicked";
        Assert.assertEquals(actualMessage, expectedMessage);
    }
}
