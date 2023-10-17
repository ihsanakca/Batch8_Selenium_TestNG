package com.eurotech.tests.day_01_automation_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class _2_WindowMethods {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.get("http://www.eurotech.study/");

        driver.manage().window().maximize();
        driver.manage().window().fullscreen();

        //how to get position of window (chrome driver)
        Point position = driver.manage().window().getPosition();
        System.out.println("position = " + position);

        //let's set our driver position
        driver.manage().window().setPosition(new Point(200,200));

        //how to get size of window (chrome driver)
        Dimension size = driver.manage().window().getSize();
        System.out.println("size = " + size);

        driver.manage().window().setSize(new Dimension(500,1000));

        //let's take our window to the second screen
        // if your second screen is located to the left of the main screen---> setPosition(new Point (-1000,0))
        // if your second screen is located to the right of the main screen---> setPosition(new Point (1000,0))
        // if your second screen is located to the above of the main screen---> setPosition(new Point (0,-1000))
        // if your second screen is located to the below of the main screen---> setPosition(new Point (0,1000))

        driver.manage().window().setPosition(new Point(-1000,0));

        driver.manage().window().maximize();

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver1=new FirefoxDriver();

        driver1.get("https://www.google.com");
        driver1.manage().window().maximize();


    }
}
