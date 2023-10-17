package com.eurotech.tests.day_11_listOfElements_dropDowns;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class _2_DropDownsWithSelectTag {

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
    public void dropDownWithSelectTag() throws InterruptedException {
        /**
         * Select Menu
         * go to https://demoqa.com/select-menu
         * locate Old Style Select Menu (dropdown menu)
         * get all colorsOptions(web elements) as a list
         * verify that the number of webElement is 11
         * click (select) green
         * verify that the selected option's text is 'Green'
         */

        driver.get("https://demoqa.com/select-menu");

        //locate the dropdown menu
        WebElement dropDownMenu = driver.findElement(By.cssSelector("#oldSelectMenu"));

        //create a select object to manipulate the dropdown menu
        Select colors = new Select(dropDownMenu);

        //get all webelements in the dropdown menu by using getOptions() method
        List<WebElement> colorOptions = colors.getOptions();

        System.out.println(colorOptions.size());

        //verify the size of the list
        Assert.assertTrue(colorOptions.size() == 11);

        //listeyi yazdıralım
        for (WebElement option : colorOptions) {
            System.out.println("option.getText() = " + option.getText());
        }

        //green elementini seçelim.----->indexi 2.
        colorOptions.get(2).click();
        Thread.sleep(2000);

        String actualText=colors.getFirstSelectedOption().getText();
        String expectedText="Green";

        Assert.assertEquals(actualText,expectedText);


        /**
         * select the blue option by visible text method
         * get the selected webElement and put into a webElement bucket by getFirstSelectedOption() (assigning)
         * verify that the selected option's text is 'Blue'
         */


        //select the blue option with visible text
        colors.selectByVisibleText("Blue");
        Thread.sleep(2000);

        //get the selected webElement and put into a webElement bucket by getFirstSelectedOption()
        WebElement selectedElement_1 = colors.getFirstSelectedOption();

        //verify that the selected option's text is 'Blue'
        String actualText1 = selectedElement_1.getText();
        String expectedText1 = "Blue";
        Assert.assertEquals(actualText1,expectedText1);

        /**
         * select the black option by index method
         * get the selected webElement and put into a webElement bucket by getFirstSelectedOption() (assigning)
         * verify that the selected option's text is 'Black'
         */

        // select the black option by index method
        colors.selectByIndex(5);
        Thread.sleep(2000);

        //get the selected webElement and put into a webElement bucket by getFirstSelectedOption()
        WebElement selectedElement_2 = colors.getFirstSelectedOption();

        //verify that the text is black
        String actualText2 = selectedElement_2.getText();
        String expectedTest2 = "Black";
        Assert.assertEquals(actualText2,expectedTest2);

        /**
         * select the voilet option by value attribute method
         * get the selected webElement and put into a webElement bucket by getFirstSelectedOption() (assigning)
         * verify that the selected option's text is 'Voilet'
         */

        // select the voilet by value attribute option
        colors.selectByValue("7");
        Thread.sleep(2000);

        //get the selected webElement and put into a webElement bucket by getFirstSelectedOption()
        WebElement selectedElement_3 = colors.getFirstSelectedOption();

        //verify that the text is 'Voilet'
        String actualText3 = selectedElement_3.getText();
        String expectedText3 = "Voilet";
        Assert.assertEquals(actualText3,expectedText3);
    }

    @Test
    public void dropDownWithSelectTag_Task() throws InterruptedException {

        /**
         * navigate to https://www.amazon.com/"
         * locate the dropdown menu nearby the search box
         * select the Baby department by using text then print the department name
         * select the Books department by using index then print the department name
         * select the Health & Household department by using value attribute then print the department name
         * get all options to a list
         * print all departments name
         * get the text of fifth element and verify that the text is Books
         */

        driver.get("https://www.amazon.com/");
        WebElement searchDropdownBox = driver.findElement(By.id("searchDropdownBox"));

        Select select = new Select(searchDropdownBox);

        select.selectByVisibleText("Baby");
        System.out.println(select.getFirstSelectedOption().getText());
        Thread.sleep(2000);
        System.out.println("------------------------");

        select.selectByIndex(5);
        System.out.println(select.getFirstSelectedOption().getText());
        Thread.sleep(2000);
        System.out.println("------------------------");

        select.selectByValue("search-alias=hpc-intl-ship");
        System.out.println(select.getFirstSelectedOption().getText());
        Thread.sleep(2000);
        System.out.println("------------------------");

        List<WebElement> options = select.getOptions();

        options.forEach(e -> {
            System.out.println(e.getText());
        });

        System.out.println("------------------------");

        System.out.println(options.size());

        Assert.assertTrue(options.get(5).getText().equals("Books"));

    }

    /**
     * AÇIKLAMALAR:
     * Özel bir web element yapısına sahiptir.
     * İki yolla locate edilirler.
     *
     * 1. Normal yol --> Web element bilinen yollar ile locate edilir ve manual olarak yapılan işlemler koda aktarılır.
     * Note: Eğer menüdeki elementleri inspect yapamıyorsanız
     * --> right click/inspect/eventlisteners/blur  burada bulunan bütün seçenekler silinir.
     *
     * 2.Select class --> Eğer dropdown elementi select tagı ile yapılmışsa seleniumdan gelen
     * 'Select' class bu menudeki opsiyonlarla iletişime geçmek için kullanılır.
     *  2.1. Dropdown web elementi locate edilir (select tagıyla olan yer) -->
     * WebElement dropDown = driver.findElement(By.xpath("formula"));
     *
     *  2.2. Select classından bir select nesnesi oluşturulur. --> Select select = new Select(dropDown);
     *    2.2.1 select.getOptions() --> menudeki bütün seçenekleri bir WebElement liste alır.
     *    2.2.2 select.selectByVisibleText("...") --> görünen texte göre elementi seçtirir.
     *            select.getFirstSelectedOption() --> seçilen element ilk sıraya geçer. Bu elementi bir variable assign ederiz.
     *    2.2.3 select.selectByIndex("...") --> index (sıra no) ile elementi seçtirir.
     *            select.getFirstSelectedOption() --> seçilen element ilk sıraya geçer. Bu elementi bir variable assign ederiz.
     *    2.2.4 select.selectByValue("...") value attribute değeri ile elementi seçtiri.
     *            select.getFirstSelectedOption() --> seçilen element ilk sıraya geçer. Bu elementi bir variable assign ederiz.
     */

}
