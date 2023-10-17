package com.eurotech.tests.day_08_css_locator;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class _3_Css_Contains_StartsWith_EndsWith_ParentToChild {
    public static void main(String[] args) throws InterruptedException {

        /**
         * class task
         * navigate to http://www.eurotech.study/
         * click cookies button css contains (*)
         * click login button with css starts-with (^)
         * send your email to email box with css ends-with ($)
         * send your password to password box with css parent to child (>)
         * click login btn with css parent to grandson (space)
         * -----------------------------
         * [attribute*='value'] (contains)
         * tagName[attribute*='value'] (contains)
         *
         * [attribute^='firstPartOfValue'] (starts with)
         * tagName[attribute^='firstPartOfValue'] (starts with)
         *
         * [attribute$='lastPartOfValue'] (ends-with)
         * tagName[attribute$='lastPartOfValue'] (ends-with)
         *
         * xpath '/'  --> parent to child
         * css   '>'  --> parent to child
         * xpath '//' --> parent to grandson
         * css   ' '  --> parent to grandson  (space-boşluk)
         *   */


        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().setPosition(new Point(-1000, 0));
        driver.manage().window().maximize();
        driver.get("http://www.eurotech.study/");

        Thread.sleep(2000);

        //click cookies button css contains (*)
        driver.findElement(By.cssSelector("button[aria-label*='Accept']")).click();
        Thread.sleep(2000);

        //click login button with css starts-with (^)
        WebElement loginBtn = driver.findElement(By.cssSelector("a[class^='btn btn-l']"));
        loginBtn.click();
        Thread.sleep(2000);

        //send your email to email box with css ends-with ($)
        WebElement emailBtn = driver.findElement(By.cssSelector("input[type$='ail']"));
        emailBtn.sendKeys("sgezer56@gmail.com");
        Thread.sleep(2000);

        //send your password to password box with css parent to child (>)
        WebElement passwordInput=driver.findElement(By.cssSelector("div>input[type='password']"));
        passwordInput.sendKeys("Sg12345678");
        Thread.sleep(2000);

        //click login btn with css parent to grandson (space)
        WebElement secondLoginBtn=driver.findElement(By.cssSelector("section input[value='Login']"));
        secondLoginBtn.click();
        Thread.sleep(4000);


        driver.close();
    }
}
