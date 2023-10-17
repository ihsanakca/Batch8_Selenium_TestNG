package com.eurotech.tests.day_06_07_xPath_locator;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class _1_AbsoluteXPath {
    public static void main(String[] args) throws InterruptedException {

        /**
         * open a chrome browser and navigate to "https://demoqa.com/automation-practice-form"
         * locate current address input area with absolute xPath
         * send "Manheim/Kolonya" to the address box area
         * then take the value of address box area
         * verify that both addresses are same
         * close driver
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().setPosition(new Point(-1000,0));
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/automation-practice-form");

       Thread.sleep(2000);

        WebElement currentAdress = driver.findElement(By.
                xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/form/div[9]/div[2]/textarea"));

        currentAdress.sendKeys("Manheim/Kolonya");

        String actualAddress = currentAdress.getAttribute("value");
        String expectedAddress="Auberhausen/Kolonya";

        if (actualAddress.equals(expectedAddress)){
            System.out.println("Pass");
        }else{
            System.out.println("Failed");
        }
        Thread.sleep(2000);
        driver.close();
    }
}
/**
 * absolute xPath HTML kodunun en başından (root) başlayarak adım adım hedeflenen web elemente gidilerek
 * istenilen web elementin locate edilmesini sağlar.
 * Bütün HTML'yi adım adım izleyerek gittiği için değişimlere karşı çok hassastır. ve en ufak bir kod değişikliğinde
 * zincir şeklindeki path (yol) bozulacağından KESİNLİKLE tercih edilmemelidir.
 * Dev Tool'da elementin üstüne sağ click-copy-copy full xPath ile kısa yoldan elede edilebilir.
 */