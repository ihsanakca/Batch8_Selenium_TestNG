package com.eurotech.tests.day_06_07_xPath_locator;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class _9_RelativeXPath_ComplexExample_Task {


    public static void main(String[] args) throws InterruptedException {
        /**
         * open a chrome browser
         * navigate to http://opencart.abstracta.us/index.php?route=common/home
         * locate "iPhone Add to Cart Button" with the name of product iPhone
         * then click to the add to cart button
         * take the text of success message which appears after the click
         * verify that the message contains "Success"
         * close driver
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().setPosition(new Point(-1000,0));
        driver.manage().window().maximize();

        driver.get("http://opencart.abstracta.us/index.php?route=common/home");
        Thread.sleep(2000);

        // locate the add to cart button but locator contains the product name
        WebElement iPhone = driver.findElement(By.
                xpath("//a[text()='iPhone']/ancestor::div[@class='product-thumb transition']//button[@onclick=\"cart.add('40');\"]"));
        iPhone.click();
        Thread.sleep(3000);
        WebElement successMessage = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
        String successMessageText = successMessage.getText();

        if (successMessageText.contains("Success")){
            System.out.println("Pass");
        }else{
            System.out.println("Failed");
        }

        driver.close();
    }

}
