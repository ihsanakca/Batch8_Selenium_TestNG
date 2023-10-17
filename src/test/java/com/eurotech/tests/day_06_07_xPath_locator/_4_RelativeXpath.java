package com.eurotech.tests.day_06_07_xPath_locator;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class _4_RelativeXpath {
    public static void main(String[] args) throws InterruptedException {

        /**
         * open chrome browser and go to http://www.eurotech.study/
         * click I understand button and accept cookies (use xPath with text feature)
         * locate Developers link (use xPath with text feature)
         * click the Developers link
         * locate Filter By element (use xPath with text feature)
         * get the text of element and print it
         * close browser.
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().setPosition(new Point(-1000,0));
        driver.manage().window().maximize();
        driver.get("http://www.eurotech.study/");

        Thread.sleep(2000);


        //locate cookies xPath with text
        driver.findElement(By.xpath("//button[text()='I understand']")).click();
        Thread.sleep(2000);

        //locate developers link by xPath with text and click on it
        WebElement developersLink = driver.findElement(By.xpath("//a[text()='Developers']"));
        developersLink.click();
        Thread.sleep(2000);

        //locate Filter By element --> by xPath with text and get the text of element and print it
        WebElement filterByElement = driver.findElement(By.xpath("//*[.='Filter By']"));
        String filterByElementText = filterByElement.getText();
        System.out.println("filterByElementText = " + filterByElementText);

        Thread.sleep(2000);

        driver.close();
    }
}
