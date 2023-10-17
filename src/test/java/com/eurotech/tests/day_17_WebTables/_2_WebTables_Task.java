package com.eurotech.tests.day_17_WebTables;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class _2_WebTables_Task {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().setPosition(new Point(-1000, 0));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://webdriveruniversity.com/Data-Table/index.html");

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
         driver.quit();
    }


    @Test
    public void getASingleCellInOneRow_Task1() {

        /**
         * Task-1
         * navigate to https://webdriveruniversity.com/Data-Table/index.html
         * get the third cell of first row --> 45  and make verification
         * get the second cell of second row --> Jackson and make verification
         */

        //get the third cell of first row --> 45
        WebElement thirdCellOfFirstRow = driver.findElement(By.xpath("(//table[@id='t01']//td/..)[1]/td[3]"));
        String actualData = thirdCellOfFirstRow.getText();
        String expectedData = "45";
        Assert.assertEquals(actualData, expectedData);

        //get the second cell of second row --> Jackson
        WebElement secondCellOfSecondRow = driver.findElement(By.xpath("(//table[@id='t01']//td/..)[2]/td[2]"));
        String actualData_2 = secondCellOfSecondRow.getText();
        String expectedData_2 = "Jackson";
        Assert.assertEquals(actualData_2, expectedData_2);
    }

    @Test
    public void printAllCellsByIndex_Task2() {

        /**
         * Task-2
         * navigate to https://webdriveruniversity.com/Data-Table/index.html
         * get the data of specific cell by using row and column numbers
         * write separate methods for this purpose
         * print whole table data by using this method (except column headers)
         */

        //we would like to write a code that it will print all cells one by one
        int rowNumber = getNumberOfRows();
        int columnNumber = getNumberOfColumns();

        for (int i = 1; i <= rowNumber; i++) {
            for (int j = 1; j <= columnNumber; j++) {
                System.out.print(getSpecificCell(i, j) + " ");
            }
            System.out.println();
        }
    }

    private int getNumberOfRows() {
        List<WebElement> allRowsWithoutHeader = driver.findElements(By.xpath("//table[@id='t01']//td/.."));
        int rowNumber = allRowsWithoutHeader.size();
        return rowNumber;
    }

    private int getNumberOfColumns() {
        List<WebElement> elements = driver.findElements(By.xpath("//table[@id='t01']//th"));
        int columnNumber = elements.size();
        return columnNumber;
    }

    private String getSpecificCell(int row, int column) {
        String xPath = "(//table[@id='t01']//td/..)[" + row + "]/td[" + column + "]";
        WebElement cell = driver.findElement(By.xpath(xPath));
        return cell.getText();
    }


}


    

