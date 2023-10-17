package com.eurotech.tests.day_03_webElement_intro;


import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.*;

public class _4_ClickSendKeysGetText_Practice {
    public static void main(String[] args) throws InterruptedException {
        /**
         * Open chore browser
         * navigate to https://www.amazon.com/
         * write "Java" to the search bar
         * click search button
         * get result for text
         * verify that the text contains "Java"
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        // driver.manage().window().setPosition(new Point(-1000,0));
        driver.manage().window().maximize();

        driver.get("https://www.amazon.com.tr/");

        //web elemeti kullanma yolları 1. yol
        // lazy way---> yani web elementi herhangi bir değişkene atamadan direkt kullanıyoruz burada
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java");
        Thread.sleep(2000);

        //web elemeti kullanma yolları 2. yol
        //burada web elementi bir değişkene atayarak kullanıyoruz... önce web elemnti tanımlayıp sonra click yapıyoruz..
        WebElement searchBtn = driver.findElement(By.id("nav-search-submit-button"));
/*

        JavascriptExecutor executor = (JavascriptExecutor) driver;
        Object elementAttributes = executor.executeScript("var items = {}; for (index = 0; index < arguments[0]" +
                ".attributes.length; ++index) { items[arguments[0].attributes[index].name] = arguments[0]" +
                ".attributes[index].value }; return items;", searchBtn);
              System.out.println(elementAttributes.toString());
*/

        searchBtn.click();
        Thread.sleep(2000);

        // burada bir web elementi locate etme (seleniuma gösterme, yerini belirleme) yöntemi olan xPath kullanıyoruz.
        WebElement resultTextElement = driver.findElement(By.xpath("//span[@class='a-color-state a-text-bold']"));
        String actualText = resultTextElement.getText();
        Thread.sleep(2000);

        //  System.out.println("driver.findElement(By.id(\"search\")).getText() = " + driver.findElement(By.id
        //  ("search")).getText());

        String expectedText = "Java";

        if (actualText.contains(expectedText)) {
            System.out.println("Pass");
        } else {
            System.out.println("Failed");
        }

        driver.close();

    }
}
/**
 * Toplam 8 adet web element locate etme yöntemi vardir.
 * 6 adedi basic yöntemler (basit-temel)
 * 1- By Id
 * 2- By Name
 * 3- By Tagname
 * 4- By Class name
 * 5- By linktext
 * 6- By partial link text
 * <p>
 * 2 adedi custom veya complex yöntemler (custom --> belirlenmiş kurallara göre )
 * 7- By xPath
 * 8- By Css sellector
 */