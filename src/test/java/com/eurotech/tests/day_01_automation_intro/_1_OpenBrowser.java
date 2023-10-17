package com.eurotech.tests.day_01_automation_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class _1_OpenBrowser {
    public static void main(String[] args) {
        //make selenium ready to talk with Chrome
        WebDriverManager.chromedriver().setup();

        //create a driver object
        //driver --> represent a empty browser
        ChromeDriver driver = new ChromeDriver();

        //navigate (go) to eurotechstudy web page
        driver.get("https://www.eurotechstudy.com/en");
        //driver.get("www.eurotechstudy.com/en");  //----> throws an exception and breaks the code
        //driver.get("https://eurotechstudy.com/en");  // ---> is working

        //how to get page title
        System.out.println("driver.getTitle() = " + driver.getTitle());

        String expectedTitle = "euroTech Study GmbH – Germany – Digital Career Programs und Training Courses";
        String actualTitle = driver.getTitle();

        //check if the actual and expected values match or not

        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Pass");
        } else {
            System.out.println("Failed");
        }

    }
}
