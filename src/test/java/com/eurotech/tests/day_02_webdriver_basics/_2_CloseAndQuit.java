package com.eurotech.tests.day_02_webdriver_basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class _2_CloseAndQuit {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().setPosition(new Point(-1000,0));
        driver.manage().window().maximize();

        driver.navigate().to("http://www.eurotech.study/");

        Thread.sleep(3000);

        //close the driver with close() method
        //close the current tab
        driver.close();

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver1 = new FirefoxDriver();

        driver1.manage().window().setPosition(new Point(-1000,0));
        driver1.manage().window().maximize();
        driver1.get("https://www.amazon.com");

        Thread.sleep(3000);

        //close the driver with the quit() method
        //close all the tabs
        driver1.quit();

        //giving new browser tab
        driver=new ChromeDriver(); // if we don't will give -> invalid session ID Exception
        driver.manage().window().setPosition(new Point(-1000,0));
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
        Thread.sleep(2000);
        driver.close();

    }
}
