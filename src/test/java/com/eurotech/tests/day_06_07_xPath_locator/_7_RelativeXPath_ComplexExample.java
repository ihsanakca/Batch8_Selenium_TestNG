package com.eurotech.tests.day_06_07_xPath_locator;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.*;

public class _7_RelativeXPath_ComplexExample {


    public static void main(String[] args) throws InterruptedException {
        /**
         * open a chrome browser
         * navigate to https://demowebshop.tricentis.com/
         * locate "Simple Computer Add to Cart Button" with the name of product
         * then click to the button
         * close driver
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().setPosition(new Point(-1000,0));
        driver.manage().window().maximize();

        driver.get("https://demowebshop.tricentis.com/");
        Thread.sleep(2000);

        Thread.sleep(2000);
        // locate the add to cart button but locator contains the product name
        WebElement laptop14InchAddToCartBtn = driver.findElement(By.
                xpath("//a[text()='Simple Computer']/ancestor::*[@class='details']//input"));
        laptop14InchAddToCartBtn.click();
        Thread.sleep(5000);

        driver.close();

    }


}
