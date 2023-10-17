package com.eurotech.tests.day_06_07_xPath_locator;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class _6_RelativeXPath {
    public static void main(String[] args) throws InterruptedException {

        /**
         * task
         * navigate to https://demoqa.com/automation-practice-form
         * locate first name input box with xPath (parent-child relations)
         * send "Ayşegül" to the input box
         * locate sports checkbox with xPath (parent-child relations)
         * click to the checkbox
         * locate Student Registration Form element by xPath (parent-child relations)
         * get the text of web element and print it
         * close the driver
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().setPosition(new Point(-1000,0));
        driver.manage().window().maximize();

        driver.get("https://demoqa.com/automation-practice-form");
        Thread.sleep(2000);

        //locate first name input box with xPath (parent-child relations)
        WebElement firstNameInputBox = driver.findElement(By.
                xpath("(//h5[contains(.,'Student')]/following-sibling::form/descendant::input)[1]"));
        firstNameInputBox.sendKeys("Ayşegül");
        Thread.sleep(2000);

        //locate sports checkbox with xPath (parent-child relations)
        WebElement sportsCheckBox = driver.findElement(By.xpath("//h5[contains(.,'Student')]/..//input[@*='checkbox' and @*='1']/.."));
        sportsCheckBox.click();
        Thread.sleep(2000);

        //locate Student Registration Form element by xPath (parent-child relations)
        WebElement formHeadingElement= driver.findElement(By.
                xpath("//textarea/ancestor::form/preceding-sibling::h5"));
        String formHeadingElementText = formHeadingElement.getText();
        System.out.println("formHeadingElementText = " + formHeadingElementText);
        Thread.sleep(2000);

        driver.close();

    }
}
