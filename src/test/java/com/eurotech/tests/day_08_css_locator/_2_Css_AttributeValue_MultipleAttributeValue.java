package com.eurotech.tests.day_08_css_locator;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class _2_Css_AttributeValue_MultipleAttributeValue {
    public static void main(String[] args) throws InterruptedException {
        /**
         * navigate to http://www.eurotech.study/
         * click cookies button with one css attribute value
         * take DevEx text with css multiple attribute value (and)
         * take main text with css multiple attribute value (or)
         * close driver
         * --------------------
         * [attribute='value']
         * tagName[attribute='value']
         * ----------------------
         * birden çok attribute ile css'de locate etme:
         * [attribute1='value1'][attribute2='value2'] (and)
         * tagName[attribute1='value1'][attribute2='value2'] (and)
         *
         * [attribute1='value1'],[attribute2='value2'] (or)
         * tagName[attribute1='value1'],[attribute2='value2'] (or)
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().setPosition(new Point(-1000,0));
        driver.manage().window().maximize();
        driver.get("http://www.eurotech.study/");

        Thread.sleep(2000);

        //click cookies button css with attribute value
        driver.findElement(By.cssSelector("button[aria-label='Accept cookies']")).click();
        Thread.sleep(2000);

        //take DevEx text with css multiple attribute value (and)
        WebElement devExElement = driver.findElement(By.cssSelector("[id='landingpage-innercontainer-h1'][class='x-large']"));
        System.out.println("devExElement.getText() = " + devExElement.getText());
        Thread.sleep(2000);

        //take main text with css multiple attribute value (or)
        WebElement mainText = driver.findElement(By.cssSelector("[id='landingpage-innercontainer-p'],[class='lead']"));
        System.out.println("mainText.getText() = " + mainText.getText());
        Thread.sleep(2000);

        driver.close();
    }
}
