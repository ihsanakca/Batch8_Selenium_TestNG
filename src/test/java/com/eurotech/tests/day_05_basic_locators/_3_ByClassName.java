package com.eurotech.tests.day_05_basic_locators;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class _3_ByClassName {
    public static void main(String[] args) throws InterruptedException {
        /**
         * open chrome browser and navigate to http://www.eurotech.study/
         * accept cookies if any
         * locate main paragraph web element by using class name locator
         * get the text of web element and print it
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

        //By class name (class name ile locate etme)
        WebElement mainParagraph = driver.findElement(By.className("lead"));
        ////locate ettiğimiz elementin textini alıp yazdıralım...
        String mainParagraphText = mainParagraph.getText();
        System.out.println("mainParagraphText = " + mainParagraphText);

        Thread.sleep(2000);

        driver.close();
    }
    /**
     * 1. dinamik olmazlar..
     * 2. çoğunlukla birden fazla web elementin class name attribute değeri aynı olabilir.
     * 3. unique (eşsiz) olup olmadığı dev tools arama (ctrl+f ile açılan yerde) bölümünde başına "." işareti
     *  konularak kontrol edilebilir. By.className("clasname") içine yazılırken "." işareti olmadan kullanılır..
     *  4. class name değeri genellikle space yani boşluk içerir.. bu durumda By.className("clas name") ile kullanılazlar.
     *  bu durumda cssSelector ile uygun işlem yapıldıktan sonra kullanılabilirler...(Css konusu)
     */
}
