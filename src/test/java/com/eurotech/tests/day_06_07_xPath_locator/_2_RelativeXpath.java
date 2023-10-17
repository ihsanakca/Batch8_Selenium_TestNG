package com.eurotech.tests.day_06_07_xPath_locator;


import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.*;

public class _2_RelativeXpath {

    public static void main(String[] args) throws InterruptedException {
        /**
         * open chrome
         * navigate to https://www.amazon.com.tr/
         * accept cookies if any (use xPath formula with known attribute value)
         * locate search bar with xPath formula with known attribute value
         * send "Selenium" word to the serach bar
         * locate seacrh button with xPath formula with known attribute value
         * click search button
         * Get the search result by the formula of the text feature of Xpath (two ways)
         * get the text of web element and print it.
         * close driver.
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().setPosition(new Point(-1000,0));
        driver.manage().window().maximize();

        driver.get("https://www.amazon.com.tr/");
        Thread.sleep(2000);

        //locate web element with known attribute value
        WebElement acceptCookies = driver.findElement(By.xpath("//input[@id='sp-cc-accept']"));
        acceptCookies.click();

        Thread.sleep(2000);

        //locate web element with known attribute value
        WebElement searchBar = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        String expectedItem="Selenium";
        searchBar.sendKeys(expectedItem);

        // alttaki kod send keys yapar ve ardından enter tuşuna basar...mutlaka manual test edilip sonra uygulanmalıdır..
       // searchBar.sendKeys(expectedItem+ Keys.ENTER);

        //locate web element with known attribute value
        WebElement searchButton = driver.findElement(By.xpath("//input[@value='Git']"));
        searchButton.click();
        Thread.sleep(2000);

        //locate the web element with text feature of Xpath (1. yol)
        WebElement resultElement = driver.findElement(By.xpath("//span[text()='\"Selenium\"']"));
        String actualResult = resultElement.getText();

        //locate the web element with text feature of Xpath (2.yol)
        WebElement resultElement1 = driver.findElement(By.xpath("//span[.='\"Selenium\"']"));
        String actualResult1 = resultElement1.getText();

        System.out.println("actualResult1 = " + actualResult1);
        System.out.println("actualResult = " + actualResult);

        Thread.sleep(2000);

        driver.close();


       /* if (actualResult.contains(expectedItem) && actualResult1.contains(expectedItem)){
            System.out.println("Pass");
        }else {
            System.out.println("Failed");
        }

*/



    }

}
