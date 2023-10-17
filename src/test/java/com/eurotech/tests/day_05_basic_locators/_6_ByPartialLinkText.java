package com.eurotech.tests.day_05_basic_locators;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class _6_ByPartialLinkText {
    public static void main(String[] args) throws InterruptedException {

        /**
         * open chrome browser and navigate to http://www.eurotech.study/
         * accept cookies if any
         * locate Sign Up button web element by using partial link text locator
         * get the text of web element and print it
         * click to the web element
         * close driver.
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().setPosition(new Point(-1000,0));
        driver.manage().window().maximize();
        driver.get("http://www.eurotech.study/");

        Thread.sleep(2000);

        //accept cookies
        driver.findElement(By.id("rcc-confirm-button")).click();

        Thread.sleep(2000);

        //link text ile locate etme
        WebElement signUpLink = driver.findElement(By.partialLinkText("Up"));

        //locate ettiğimiz elementin textini alıp yazdıralım...
        String signUpText = signUpLink.getText();
        System.out.println("signUpText = " + signUpText);

        Thread.sleep(2000);
        //locate ettiğimiz elemente click yapalım...
        signUpLink.click();

        Thread.sleep(2000);
        driver.close();
    }
}
/**
 * 1- a tag'ı ve href attribute'u olan web elementlerde kullanılır...
 * 2- <a class="btn btn-light" href="https://www.uzunihsan.com/login">ABCDEF</a> --> web elementinde ABCDEF link text kısmıdır..
 * bu text'in unique (eşsiz) olan bir bölümü alınarak kulllanılır.. mesela DEF kısmı olabilir... yazının sırası bozulmamalıdır.
 * 3- text kısmının bir bçölümü alınmalıdır..
 */