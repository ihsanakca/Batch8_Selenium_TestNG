package com.eurotech.tests.day_11_listOfElements_dropDowns;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;

public class _1_ListOfElements_FindElements {
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
    public void findElementsWithCorrectFormula() {

        /**
         * https://demoqa.com/elements adresine git
         * soldaki ana başlıkları tek bir locator ile locate et ve bunları bir liste kaydet
         * listin size'ını al.
         * size'ın 6 olduğunu doğrula.
         * listedeki başlık elementlerinin textlerini yazdır. (For each)
         */
        driver.get("https://demoqa.com/elements");

        // locator'ın şartını sağlayan bütün elementleri bir liste kaydet.
        List<WebElement> headers = driver.findElements(By.cssSelector(".header-text"));

        // element sayısının (size) 6 olduğunu verify et
        int expectedSize = 6;
        System.out.println("headers.size() = " + headers.size());
        Assert.assertEquals(headers.size(), expectedSize, "verify that size is 6");

        //menü listesindeki başlıkları yazdır
        for (WebElement header : headers) {
            System.out.println("header.getText() = " + header.getText());
        }

        //bütün başlıklar görünüyor mu?
        for (WebElement header : headers) {
            Assert.assertTrue(header.isDisplayed());
        }

    }

    @Test
    public void findElementsWithIncorrectFormula() {
        /**
         * eğer findElements() metodu ile locate ettiğimiz WebElement listinin locator'ı hatalı olursa..
         * kod hata fırlatmaz, bunun yerine içi boş bir list elde etmiş oluruz..
         * eğer aynı işlem tek bir WebElement için yapılsaydı.. NoSuchElement hatası alacaktık...
         */
        driver.get("https://demoqa.com/elements");

        List<WebElement> headers = driver.findElements(By.cssSelector("Ahmet"));

        int expectedSize = 6;
        System.out.println("headers.size() = " + headers.size());

    }

    @Test
    public void findElements_1() throws InterruptedException {

        /**
         * navigate to https://www.saucedemo.com/
         * locate login form elements with one locator (username box, password box and login button)
         * send "standard_user" to username box
         * send "secret_sauce" to password box
         * click Login button
         * then take all product names to a web element list and print the text of elements
         * verify that first web element text is "Sauce Labs Backpack"
         */

        driver.get("https://www.saucedemo.com/");
        List<WebElement> loginInputs = driver.findElements(By.xpath("//input"));
        loginInputs.get(0).sendKeys("standard_user");
        loginInputs.get(1).sendKeys("secret_sauce");
        loginInputs.get(2).click();
        Thread.sleep(3000);


        List<WebElement> products = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));


        for (WebElement product : products) {
            System.out.println(product.getText());
        }

        System.out.println("-------------------");

        for (int i = 0; i < products.size(); i++) {
            System.out.println(products.get(i).getText());
        }
        System.out.println("--------------------");

        products.forEach(e -> {
            System.out.println(e.getText());
        });


        String actualFirstProductName = products.get(0).getText();
        String expectedFirstProductName = "Sauce Labs Backpack";

        Assert.assertEquals(actualFirstProductName, expectedFirstProductName);

        Random rd=new Random();

    }


    @Test
    public void findElements_Task() throws InterruptedException {

        /**
         * navigate to http://www.eurotech.study/
         * accept cookies
         * click login
         * locate emailBox, passBox and Login Button with one locator and put them in a list which named as inputs
         * verify that the size of list is 3
         * verify that the value of 3rd element is Login
         * send your credentials to related boxes and then click login button
         * verify success login with "Welcome ......." text
         * locate Experience Credentials and Education Credentials with findElements()
         * then get both element texts and print them
         */

        driver.get("http://www.eurotech.study/");
        //accept cookies
        driver.findElement(By.id("rcc-confirm-button")).click();
        Thread.sleep(2000);

        //click login
        WebElement loginBtn = driver.findElement(By.linkText("Login"));
        loginBtn.click();
        Thread.sleep(2000);

        //locate emailBox, passBox and Login Button with one locator and put them in a list which named as inputs
        //inputs list contains 3 different webElement
        //we can get any of these webElement by manipulating 'inputs list'
        List<WebElement> inputs = driver.findElements(By.cssSelector("input"));

        //assert that the size is 3
        System.out.println(inputs.size());
        Assert.assertTrue(inputs.size() == 3);

        //verify that the value of 3rd element is Login
        String actualValue = inputs.get(2).getAttribute("value");
        String expectedValue = "Login";
        Assert.assertEquals(actualValue, expectedValue);

        //send your credentials to related boxes and then click login button
        inputs.get(0).sendKeys("sgezer56@gmail.com");
        inputs.get(1).sendKeys("Sg12345678");
        inputs.get(2).click();
        Thread.sleep(2000);

        //verify success login with "Welcome Salim Gezer" text
        WebElement personalName = driver.findElement(By.id("dashboard-p1"));
        String actualNameText = personalName.getText();
        String expectedNameText = "Welcome Salim Gezer";

        Assert.assertEquals(actualNameText, expectedNameText, "verify that the names are same");
        Thread.sleep(2000);

        List<WebElement> experienceAndEducations = driver.findElements(By.xpath("//h2"));
        //ayrı ayrı textleri alıp yazdıralım..
        System.out.println("experienceAndEducations.get(0).getText() = " + experienceAndEducations.get(0).getText());
        System.out.println("experienceAndEducations.get(1).getText() = " + experienceAndEducations.get(1).getText());
        System.out.println("----------------------");
        //for each loop ile iki texti loop içinde yazdıralım
        for (WebElement experienceAndEducation : experienceAndEducations) {
            System.out.println("experienceAndEducation.getText() = " + experienceAndEducation.getText());
        }
    }

}

/**
 * Açıklamalar....
 * findElements() --> bize WebElement'leri bir liste olarak döner.. (1 of 3 ise listede 3 element bulunur..)
 * List<WebElement> inputs = driver.findElements(By.xpath("xPathFormülü"));  // diğer yöntemler de kullanılabilir..
 * elements.get(0).click() --> listenin ilk elementine click yapar
 * elements.get(1).getText() --> listenin ikinci elementinin textini alır.
 * elements.get(2).isDisplayed() --> listenin üçüncü elementinin sayfada görünüp/görünmediğini doğrular..
 * ...
 * findElement() ve findElements() arasındaki farklar..
 * a.  findElement() --> WebElement döner, eğer elementi locate edemezse noSuchElementException fırlatır.
 * b.  findElements() --> WebElement listesi döner. eğer elementleri locate edemezse boş bir liste döner
 * bu nedenle hiçbir zaman noSuchElementException hatası fırlatmaz... bulursa dolu, bulamazsa boş liste verir.
 */
