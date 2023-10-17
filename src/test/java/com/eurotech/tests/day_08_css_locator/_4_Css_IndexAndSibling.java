package com.eurotech.tests.day_08_css_locator;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class _4_Css_IndexAndSibling {
    public static void main(String[] args) throws InterruptedException {

        /**
         * navigate to https://demoqa.com/automation-practice-form
         * send "hasan@hasan.com" to email box with css index
         * send "Bağcılar/İstanbul" to current address box with css sibling
         * close driver
         * --------------
         * cssSyntax--->tagName :nth-of-type(indexNumber)
         * cssSyntax--->tagName :nth-child(indexNumber)
         * NOTE: sadece aynı parent altındaki web elementlerde kullanılır..
         *
         * cssSyntax:tagName[]~tagName[]
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().setPosition(new Point(-1000,0));
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/automation-practice-form");

        Thread.sleep(2000);

        WebElement emailBox = driver.findElement(By.cssSelector("form>div:nth-of-type(2) input"));
       // WebElement emailBox = driver.findElement(By.cssSelector("form>div:nth-child(2) input"));  ---> üstteki ile aynı
        emailBox.sendKeys("hasan@hasan.com");
        Thread.sleep(2000);

        WebElement subjectBox=driver.findElement(By.cssSelector("form>div.mt-2.row~div[id^='cur'] textarea"));
        subjectBox.sendKeys("Bağcılar/İstanbul");
        Thread.sleep(2000);

        driver.close();

    }
}
