package com.eurotech.tests.day_06_07_xPath_locator;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;

public class _8_RelativeXPath_ComplexExample_WithMethod {
    /**
     * chrome browser açalım
     * https://demowebshop.tricentis.com/ web sayfasına gidelim
     * addToCart isimli bir metotoluşturalım.
     * bu metot ürün ismini parametre olarak alsın ve girilen ürün ismine göre add to cart butonuna click yapsın
     * daha sonra test kısmında (main metot) aşağıdaki üç üründen oluşan bir dizi yapalım
     * 1-$25 Virtual Gift Card
     * 2-Build your own expensive computer
     * 3-Simple Computer
     * bir döngü ile listedeki ürünleri oluşturduğumuz metota parametre olarak gönderelim.
     * gerekli diğer eklemeleri (geri ileri gitme, kodu durdurma) yapalım.
     * driver'ı kapatalım..
     */
    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().setPosition(new Point(-1000,0));
        driver.manage().window().maximize();

        driver.get("https://demowebshop.tricentis.com/");
        Thread.sleep(2000);

        String [] products={"$25 Virtual Gift Card","Build your own expensive computer","Simple Computer"};

        for (int i = 0; i < products.length; i++) {
            addToCart(products[i]);

        }

        Thread.sleep(2000);

        driver.close();

    }

    public static void addToCart(String productName) throws InterruptedException {
        driver.findElement(By.xpath("//a[text()='"+productName+"']/ancestor::*[@class='details']//input")).click();
        Thread.sleep(4000);
        driver.navigate().back();
    }
}
