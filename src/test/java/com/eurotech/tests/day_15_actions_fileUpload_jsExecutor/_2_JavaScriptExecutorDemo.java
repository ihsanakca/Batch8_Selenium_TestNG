package com.eurotech.tests.day_15_actions_fileUpload_jsExecutor;


import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class _2_JavaScriptExecutorDemo {
    WebDriver driver;

    @BeforeMethod
    public void setUp() throws InterruptedException {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().setPosition(new Point(-1000, 0));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void clickWithJS() throws InterruptedException {
        /**
         * navigate to https://www.amazon.com.tr/
         * accept cookies if any
         * click Almanya link with js executor
         * accept cookies if any
         * verify that the url contains amazon.de
         *
         * note : ask google how to click with js executor
         */
        driver.get("https://www.amazon.com.tr/");

      //  driver.findElement(By.id("sp-cc-accept")).click();

        WebElement germany = driver.findElement(By.linkText("Almanya"));

       // germany.click();
        //ask google--> how to click with jsexecutor
       JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].click();", germany);
        Thread.sleep(2000);
        driver.findElement(By.id("sp-cc-accept")).click();

        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("amazon.de"));

    }

    @Test
    public void typeWithJS() throws InterruptedException {
        /**
         * go to https://the-internet.herokuapp.com/dynamic_controls
         * send "Hello World!" to the disabled box with js executor
         *
         * note : ask google--> how to sendKeys using JSExecutor
         */
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        WebElement inputBox = driver.findElement(By.cssSelector("#input-example>input"));

        String text="Hello World!";
        //ask google--> how to sendKeys using JSExecutor
        Thread.sleep(2000);
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].setAttribute('value', '" + text +"')", inputBox);


    }

    @Test
    public void scrollDownAndUp() throws InterruptedException {
        /**
         * go to https://www.amazon.com.tr/"
         *  accept cookies if any
         * make scroll down and up
         */
        driver.get("https://www.amazon.com.tr/");
        driver.findElement(By.id("sp-cc-accept")).click();

        //ask google to--> how to scroll down in selenium javascript
        JavascriptExecutor jse = (JavascriptExecutor)driver;
       // jse.executeScript("window.scrollBy(0,500)");

        for (int i = 0; i <10 ; i++) {
            Thread.sleep(1000);
            jse.executeScript("window.scrollBy(0,500)");
        }
        for (int i = 0; i <10 ; i++) {
            Thread.sleep(1000);
            jse.executeScript("window.scrollBy(0,-500)");
        }
    }

    @Test
    public void scrollToElement() throws InterruptedException {
        /**
         * navigate to https://www.amazon.com.tr/
         * accept cookies if any
         * scroll to the Almanya and click it
         */
        driver.get("https://www.amazon.com.tr/");
        driver.findElement(By.id("sp-cc-accept")).click();
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        WebElement germany = driver.findElement(By.linkText("Almanya"));
        Thread.sleep(2000);
        //ask google to--> how to scroll into view with js executor
        jse.executeScript("arguments[0].scrollIntoView(true);", germany);
        jse.executeScript("arguments[0].click();", germany);

        jse.executeScript("arguments[0].scrollIntoView(true);"
                + "arguments[0].click()",germany);

    }

    @Test
    public void jsExecutor_Task() throws InterruptedException {
        /**
         * navigate to https://www.krafttechexlab.com/forms/elements
         * scroll 1000 px down
         * change the Range position (actions ile)
         * change the Disabled Range position
         * scroll to the Number label
         * change the color from blue to red
         * select the Disabled Radio 3 button
         * scroll to the submit button
         * scroll again to the number label
         * scroll to the submit button and click on it
         * take the new page title and url
         * verify that the page title contains "Kraft"
         *
         * not: all steps should be done with js executor except step 3 and last one.
         */
        driver.get("https://www.krafttechexlab.com/forms/elements");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Actions actions = new Actions(driver);

        //scroll 1000 px down
        js.executeScript("window.scrollBy(0,1000)");
        Thread.sleep(3000);

        //change the Range position
        WebElement customRange = driver.findElement(By.id("customRange1"));
        actions.dragAndDropBy(customRange, 500, 0).build().perform();
        Thread.sleep(3000);

        //change the Disabled Range position
        WebElement disabledRange = driver.findElement(By.id("disabledRange"));
        js.executeScript("arguments[0].setAttribute('min', '-25')", disabledRange);
        Thread.sleep(3000);

        //scroll to the Number label
        WebElement number = driver.findElement(By.xpath("//label[text()='Number']"));
        js.executeScript("arguments[0].scrollIntoView();", number);
        Thread.sleep(3000);

        //change the color from blue to red
        WebElement exampleColorInput = driver.findElement(By.id("exampleColorInput"));
        js.executeScript("arguments[0].setAttribute('value', '#FF0000')", exampleColorInput);
        Thread.sleep(3000);

        //select the Disabled Radio 3 button
        WebElement disableRadioBox = driver.findElement(By.id("gridRadios"));
        js.executeScript("arguments[0].setAttribute('checked','true')", disableRadioBox);
        Thread.sleep(3000);

        //scroll to the submit button
        WebElement submit = driver.findElement(By.xpath("//button[@name='submit']"));
        Thread.sleep(3000);
        js.executeScript("arguments[0].scrollIntoView();", submit);
        Thread.sleep(3000);

        //scroll again to the number label
        js.executeScript("arguments[0].scrollIntoView();", number);
        Thread.sleep(3000);

        //scroll to the submit button and click on it
        js.executeScript("arguments[0].scrollIntoView(true);" + "arguments[0].click()", submit);

        Thread.sleep(3000);

       String actualTitle=js.executeScript("return document.title;").toString();
       String currentURL=js.executeScript("return document.URL;").toString();

       Assert.assertTrue(actualTitle.contains("Kraft"));

    }


}
