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

public class _3_DropDownsWithoutSelectTag {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().setPosition(new Point(-1000, 0));
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void dropDownWithoutSelectTag_1() throws InterruptedException {
        /**
         * navigate to https://demo.aspnetawesome.com/
         * locate and click DropdownList (Mango ile başlayan liste)
         * get all option names and print them
         * click potato by index (6)
         * relocate dropdown menu (çünkü listenin yapısı değişti)
         * click banana with its own locator (banana'yı locate edip tıklayalım.)
         */

        driver.get("https://demo.aspnetawesome.com/");
        WebElement dropDownMenu = driver.findElement(By.xpath("(//div[text()='Mango'])[1]"));
        dropDownMenu.click();
        Thread.sleep(2000);

        List<WebElement> plantsMenu = driver.findElements(By.xpath("(//div[@class='o-itsc'])[5]//li"));
        System.out.println("plantsMenu.size() = " + plantsMenu.size());

        for (WebElement plant : plantsMenu) {
            System.out.println("food.getText() = " + plant.getText());
        }

        //click on potato
        plantsMenu.get(6).click();
        Thread.sleep(2000);

        WebElement dropDownMenu1 = driver.findElement(By.xpath("(//div[text()='Potato'])[1]"));
        dropDownMenu1.click();

        Thread.sleep(2000);

        //click on banana
        WebElement banana = driver.findElement(By.xpath("(//div[text()='Banana'])[2]"));
        banana.click();

        Thread.sleep(2000);

    }


    @Test
    public void dropDownWithoutSelectTag_2() throws InterruptedException {
        /**
         * navigate to https://demoqa.com/select-menu
         * click Select Value dropdown
         * select (click) "Group 1, option 2" from Select Value dropdown
         * locate the new "Group 1, option 2" web element (stale element daha sonra anlatılacak)
         * verify that the element text is "Group 1, option 2"
         */

        driver.get("https://demoqa.com/select-menu");
        WebElement dropDownMenuWithoutSelect = driver.findElement(By.xpath("//div[text()='Select Option']"));
        dropDownMenuWithoutSelect.click();
        Thread.sleep(2000);

        WebElement group1Option2 = driver.findElement(By.xpath("//div[text()='Group 1, option 2']"));
        //String actualText = group1Option2.getText();
        group1Option2.click();

        //locate the new "Group 1, option 2" web element
        WebElement group1Option2_1 = driver.findElement(By.xpath("//div[text()='Group 1, option 2']"));
        String actualText2 = group1Option2_1.getText();    //stale element
        String expectedText = "Group 1, option 2";

        //Assert.assertEquals(actualText, expectedText);
        Assert.assertEquals(actualText2, expectedText);

        Thread.sleep(2000);

    }
    

    @Test
    public void dropDownWithoutSelectTag_Task() throws InterruptedException {

        /**
         * navigate to https://demoqa.com/select-menu
         * click Select One dropdown
         * click on 'Mrs.'
         * locate new 'Mrs.' webElement
         * get the selected option text verify that the text is "Mrs."
         *
         * NOT:right click/inspect/eventlisteners/blur  burada bulunan bütün seçenekler silinir.
         */

        driver.get("https://demoqa.com/select-menu");

        //locate the dropdown menu and click on it
        WebElement dropDownMenu = driver.findElement(By.xpath("//div[text()='Select Title']"));
        dropDownMenu.click();

        //locate the 'Mrs.' webElement
        WebElement optionInDropDown = driver.findElement(By.cssSelector("#react-select-3-option-0-2"));
        optionInDropDown.click();

        //locate new 'Mrs.' webElement
        WebElement targetElement = driver.findElement(By.xpath("(//div[@class=' css-1hwfws3'])[2]"));

        //verification
        String actual = targetElement.getText();
        String expected = "Mrs.";
        Assert.assertEquals(actual,expected);


    }

}
