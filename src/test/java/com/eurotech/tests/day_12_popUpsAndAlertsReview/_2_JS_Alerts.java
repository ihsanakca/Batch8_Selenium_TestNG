package com.eurotech.tests.day_12_popUpsAndAlertsReview;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class _2_JS_Alerts {
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
    public void jsAlert_Accept() throws InterruptedException {
        /**
         * navigate to https://the-internet.herokuapp.com/javascript_alerts
         * click on click For Js Alert button
         * create an alert object
         * take text on the alert button and print it
         * click on OK button by using alert object
         * verify that "You successfully clicked an alert" text is seen
         */
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        //tap on click For Js Alert button
        WebElement clickForJsAlert = driver.findElement(By.xpath("//button[.='Click for JS Alert']"));
        clickForJsAlert.click();

        Thread.sleep(2000);

        //create alert object
        Alert alert = driver.switchTo().alert();
        //take text on the alert button and print it
        System.out.println("alert.getText() = " + alert.getText());

        //tap OK button
        alert.accept();
        // ikinci yol
        // driver.switchTo().alert().accept();  ---> alert nesnesi oluşturmadan da direkt olarak kullanabiliriz..

        //verification
        String actual = driver.findElement(By.cssSelector("#result")).getText();
        String expected = "You successfully clicked an alert";
        Assert.assertEquals(actual,expected);

    }

    @Test
    public void jsAlert_Dismiss() throws InterruptedException {
        /**
         * navigate to https://the-internet.herokuapp.com/javascript_alerts
         * click on click For JS Confirm button
         * create an alert object
         * take text on the alert button and print it
         * click on CANCEL button by using alert object
         * verify that "You clicked: Cancel" text is seen
         */

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        //tap on click For JS Confirm button
        WebElement clickForJsConfirm = driver.findElement(By.xpath("//button[.='Click for JS Confirm']"));
        clickForJsConfirm.click();

        Thread.sleep(2000);

        //create an alert object
        Alert alert = driver.switchTo().alert();
        //take text on the alert button and print it
        System.out.println("alert.getText() = " + alert.getText());

        //tap on cancel button by dismiss()
        alert.dismiss();

        //verification
        String actual = driver.findElement(By.cssSelector("#result")).getText();
        String expected = "You clicked: Cancel";
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void jsAlert_SendKeys() throws InterruptedException {
        /**
         * navigate to https://the-internet.herokuapp.com/javascript_alerts
         * click on click  JS Prompt button
         * create an alert object
         * take text on the alert button and print it
         * send "Ahmet Ay" text to the bar which is on the alert
         * click on OK button by using alert object
         * verify that "You entered: Ahmet Ay" text is seen
         */

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        //tap on click for JS Prompt button
        WebElement clickForJsPrompt = driver.findElement(By.xpath("//button[.='Click for JS Prompt']"));
        clickForJsPrompt.click();

        Thread.sleep(2000);

        //create alert object
        Alert alert = driver.switchTo().alert();

        //take text on the alert button and print it
        System.out.println("alert.getText() = " + alert.getText());

        String text = "Ahmet Ay";
        alert.sendKeys(text);

        Thread.sleep(2000);

        //click on OK
        alert.accept();

        //make verification
        String actual = driver.findElement(By.cssSelector("#result")).getText();
        String expected = "You entered: " + text;
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void jsAlerts_Task() throws InterruptedException {
        /**
         * navigate to https://testpages.herokuapp.com/styled/alerts/alert-test.html
         * click alert box
         * then take message on the js popup and print it
         * accept alert
         *
         * click show confirm box
         * then take message on the js popup and print it
         * dismiss alert
         * verify that you clicked cancel button (Alınan mesajın Cancel içerdiğini doğrula)
         *
         * click show prompt box
         * then take message on the js popup and print it
         * send Ahmet to the popup box
         * accept alert
         * verify that Ahmet is sent to the box.
         *
         * NOT: tüm taskı tek test metodunda yapabilirsiniz..
         */

        driver.get("https://testpages.herokuapp.com/styled/alerts/alert-test.html");
        Thread.sleep(2000);

        WebElement firstBtn = driver.findElement(By.cssSelector("[value='Show alert box']"));
        firstBtn.click();
        Alert alert = driver.switchTo().alert();
        Thread.sleep(2000);

        System.out.println("alert.getText() = " + alert.getText());
        alert.accept();Thread.sleep(2000);

        WebElement secondBtn = driver.findElement(By.cssSelector("[value='Show confirm box']"));
        secondBtn.click();
        Thread.sleep(2000);
        System.out.println("alert.getText() = " + alert.getText());
        alert.dismiss();
        Thread.sleep(2000);
        WebElement cancelMessage=driver.findElement(By.id("confirmexplanation"));
        String actualMessage= cancelMessage.getText();
        Assert.assertTrue(actualMessage.contains("Cancel"));


        WebElement thirdBtn = driver.findElement(By.cssSelector("[value='Show prompt box']"));
        thirdBtn.click();
        Thread.sleep(2000);
        System.out.println("alert.getText() = " + alert.getText());
        alert.sendKeys("Ahmet");
        alert.accept();
        Thread.sleep(2000);

        String actualText = driver.findElement(By.cssSelector("#promptreturn")).getText();
        String expectedText = "Ahmet";

        Assert.assertEquals(actualText,expectedText);

    }
}
