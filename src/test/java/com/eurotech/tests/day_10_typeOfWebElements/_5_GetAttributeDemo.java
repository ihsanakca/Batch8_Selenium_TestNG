package com.eurotech.tests.day_10_typeOfWebElements;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class _5_GetAttributeDemo {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().setPosition(new Point(-1000, 0));
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }

    @Test
    public void getAttributeTest_1() {

        driver.get("https://demoqa.com/text-box");

        /**
         * navigate to https://demoqa.com/text-box
         * locate the form web element
         * use some of GET (getAttribute, getTagName, getLocation, getCssValue) methods with the element
         */

        WebElement form = driver.findElement(By.xpath("//form"));

        System.out.println("form.getAttribute(\"id\") = " + form.getAttribute("id"));
        System.out.println("-----------------------------");
        System.out.println("form.getAttribute(\"innerHTML\") = " + form.getAttribute("innerHTML"));
        System.out.println("-----------------------------");
        System.out.println("form.getAttribute(\"outerHTML\") = " + form.getAttribute("outerHTML"));
        System.out.println("-----------------------------");
        System.out.println("form.getText() = " + form.getText());
        System.out.println("-----------------------------");

        System.out.println("form.getTagName() = " + form.getTagName());
        System.out.println("form.getLocation() = " + form.getLocation());
        System.out.println("form.getCssValue(\"font\") = " + form.getCssValue("font"));
        System.out.println("form.getCssValue(\"font-size\") = " + form.getCssValue("font-size"));
    }

    @Test
    public void getAttributeTest_Task() {
        /**
         * navigate to https://demoqa.com/text-box
         * locate Full Name input box
         * use getAttribute method with the element
         * get type attribute value and print it
         * get autocomplete attribute value and print it
         * get name attribue value and print it (name attribute olmadığı için boş dönecektir. hata vermez..)
         * get innerHTML and print it (altında child veya grandchild element olmadığından boş döner..)
         * get outerHTML (sadece kendi tag bilgilerini döner..)
         * send Ahmet to the box and take the value (eğer bir text box'ına yazı gönderirsek.. bu gönderlen yazıyı
         * getAttribute("value") metodu ile alabiliriz..)
         * NOT: getAttribute metodu ile bir web elementin texti alınamaz.. onun için getText() metodu kullanılır..
         */

        driver.get("https://demoqa.com/text-box");

        WebElement fullName = driver.findElement(By.id("userName"));

        // istediğimiz attribute'a ait değeri almak için attribute name'i parametre olarak kullanırız..
        System.out.println("fullName.getAttribute(\"type\") = " + fullName.getAttribute("type"));
        System.out.println("fullName.getAttribute(\"autocomplete\") = " + fullName.getAttribute("autocomplete"));
        System.out.println("-----------------------------");
        //eğer elementte olmayan bir attribute'ün değerini almaya çalışırsak bize boş değer döndürür.
        //eğer elementte olan ama değeri olmayan bir attribute'ün değerini almaya çalışırsak bize true döndürür.
        System.out.println("fullName.getAttribute(\"name\") = " + fullName.getAttribute("name"));
        System.out.println("-----------------------------");

        // altında child ya da grnadchild'ı olmayan web elementler için "innerHTML" boş döner...
        System.out.println("fullName.getAttribute(\"innerHTML\") = " + fullName.getAttribute("innerHTML"));
        System.out.println("-----------------------------");

        // altında child ya da grnadchild'ı olmayan web elementler için "outerHTML" sadece kendi bilgilerini döner..
        System.out.println("fullName.getAttribute(\"outerHTML\") = " + fullName.getAttribute("outerHTML"));
        System.out.println("-----------------------------");

        fullName.sendKeys("Ahmet");
        //input box'a gönderdiğimiz text'i almak istersek "value" parametresini kullanırız...
        System.out.println("fullName.getAttribute(\"value\") = " + fullName.getAttribute("value"));

    }

}
