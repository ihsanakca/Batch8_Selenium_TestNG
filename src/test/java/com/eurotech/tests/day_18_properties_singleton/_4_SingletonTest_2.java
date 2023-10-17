package com.eurotech.tests.day_18_properties_singleton;


import com.eurotech.utilities.Driver;
import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class _4_SingletonTest_2 {

    @Test
    public void test1(){
        WebDriver driver= WebDriverFactory.getDriver("chrome");
    //    WebDriver driver=  Driver.get();
        driver.manage().window().setPosition(new Point(-1000, 0));
        driver.get("https://www.amazon.com.tr");
    }

    @Test
    public void test2(){
        WebDriver driver= WebDriverFactory.getDriver("chrome");
      //  WebDriver driver= Driver.get();
        driver.manage().window().setPosition(new Point(-1000, 0));
        driver.get("https://www.google.com.tr");
    }


    ///diğer örnek

    @Test
    public void test3(){

        WebDriver driver=  Driver.get();
        driver.manage().window().setPosition(new Point(-1000, 0));
        driver.manage().window().maximize();
        driver.get("https://www.google.com.tr");
    }

    @Test
    public void test4(){

        WebDriver driver= Driver.get();
       // driver.manage().window().setPosition(new Point(-1000, 0));
        driver.findElement(By.name("q")).sendKeys("Selenium"+ Keys.ENTER);
    }
}
