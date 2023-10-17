package com.eurotech.tests.day_12_popUpsAndAlertsReview;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class _1_HTML_PopUps {
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
    public void htmlPopUp() throws InterruptedException {

        /**
         * navigate to https://testpages.herokuapp.com/styled/alerts/fake-alert-test.html
         * click show alert box
         * verify that ok button can be seen on the popup
         * take the text on popup and print it (I am a fake alert box!)
         * then click on ok at the popup
         * verify that ok button cannot be seen
         */

        driver.get("https://testpages.herokuapp.com/styled/alerts/fake-alert-test.html");
        Thread.sleep(2000);

        WebElement htmlPopUp = driver.findElement(By.cssSelector("[value='Show alert box']"));
        htmlPopUp.click();
        Thread.sleep(2000);

        WebElement okBtn = driver.findElement(By.cssSelector("#dialog-ok"));
        Assert.assertTrue(okBtn.isDisplayed());
        okBtn.click();
        Thread.sleep(2000);
        Assert.assertFalse(okBtn.isDisplayed());
    }

    @Test
    public void htmlPopUp_Task() throws InterruptedException {
        /**
         * go to http://primefaces.org/showcase/ui/overlay/confirmDialog.xhtml?jfwid=73437
         * click on confirm button
         * click on yes at the popup window
         * make verification with confirmed popup
         */

        driver.get("http://primefaces.org/showcase/ui/overlay/confirmDialog.xhtml?jfwid=73437");
        Thread.sleep(2000);


        WebElement confirmButton = driver.findElement(By.xpath("(//span[text()='Confirm'])[1]"));
        confirmButton.click();

        Thread.sleep(2000);

        WebElement yesButton = driver.findElement(By.xpath("//span[.='Yes']"));
        yesButton.click();

        Thread.sleep(2000);

        WebElement confirmationPopUp = driver.findElement(By.xpath("//p[.='You have accepted']"));

        //make verification
        String actual = confirmationPopUp.getText();
        String expected = "You have accepted";
        Assert.assertEquals(actual,expected);

    }

}
