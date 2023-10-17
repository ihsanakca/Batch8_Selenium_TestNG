package com.eurotech.tests.day_05_basic_locators;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class _1_ById {
    public static void main(String[] args) throws InterruptedException {

        /**
         * open chrome browser and navigate to http://www.eurotech.study/
         * accept cookies if any
         * locate DevEx web element by using id locator
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

        //id ile locate etme
        WebElement devExElement = driver.findElement(By.id("landingpage-innercontainer-h1"));
        //locate ettiğimiz elementin textini alıp yazdıralım...
        String devExElementText = devExElement.getText();
        System.out.println("devExElementText = " + devExElementText);

        Thread.sleep(2000);

        driver.close();

        /**
         * https://the-internet.herokuapp.com/challenging_dom dynamic id örneği....
         */
    }
}
/**
 * 1.   id.ler çoğunlukla unique (eşsiz) olur ancak yinede de kontrol etmek gerekir.
 * 2.   id'nin unique (eşsiz) olup olmadığı dev tools arama (ctrl+f ile açılan yerde) bölümünde başına # işareti
 * konularak kontrol edilebilir.. javascript veya css kodları içinde id geçiyorsa bu durum birden fazla olduğunu göstermez.
 * bu id'ler unique (eşsiz) kabul edilir... By.id("id_value") ile kullanılırken başına # konulmaz..
 * 3.  Bir web elementin id'si varsa locate ederken onu kullanırız. bu nedenle ilk bakılan attribute id'dir..
 * 4.   id'ler nadiren de olsa dinamik yani değişken olabilir.. bu durumda locate etme işleminde kullanılmazlar.. Bir
 * id'nin dinamik yani değişken olup olmadığı sayfa refresh edilerek anlaşılır.. eğer refresh sonrası id değişiyorsa
 * dinamiktir ve locate işlemi için kullanılmamalıdır.. dinamik id.ler genellikle uzun harf ve rakam grubu içeren
 * anlamsız görünen bir string'den oluşur.
 */