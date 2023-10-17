package com.eurotech.tests.day_17_WebTables;

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
import java.util.concurrent.TimeUnit;

public class _1_WebTables {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().setPosition(new Point(-1000, 0));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com/tables");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void printWholeTable(){
        /**
         * navigate to https://the-internet.herokuapp.com/tables
         * get the whole data from table (including column headers)
         * verify that the table contains fbach@yahoo.com
         * and print all table datas
         */
       // driver.get("https://the-internet.herokuapp.com/tables");
        WebElement table = driver.findElement(By.xpath("//table[@id='table1']"));
        String allTableData = table.getText();
        String expectedData="fbach@yahoo.com";

        Assert.assertTrue(allTableData.contains(expectedData));

        System.out.println(allTableData);
    }

    @Test
    public void getAllColumnHeaders(){
        /**
         * navigate to https://the-internet.herokuapp.com/tables
         * get the column headers
         * verify that the column headers contains First Name
         * and print all headers' name
         */
       // driver.get("https://the-internet.herokuapp.com/tables");
        WebElement columnHeaders = driver.findElement(By.xpath("//table[@id='table1']/thead"));

        String expectedHeader="First Name";

        Assert.assertTrue(columnHeaders.getText().contains(expectedHeader));

        System.out.println( columnHeaders.getText());

    }

    @Test
    public void getColumnHeadersOneByOne(){
        /**
         * navigate to https://the-internet.herokuapp.com/tables
         * get all web elements of column names  to a list
         * print all column names
         */

        List<WebElement> columnHeaders = driver.findElements(By.xpath("//table[@id='table1']/thead//th"));
        int numberOfColumn = columnHeaders.size();
        System.out.println("numberOfColumn = " + numberOfColumn);

        for (WebElement columnHeader : columnHeaders) {
            System.out.println("columnHeader.getText() = " + columnHeader.getText());
        }

    }

    @Test
    public void getAllRows(){

        /**
         * navigate to https://the-internet.herokuapp.com/tables
         * get the number of row with column header row
         * get the number of row without column header row
         */

        //number of row with column header row
        List <WebElement> allRowWithHeader = driver.findElements(By.xpath("//table[@id='table1']//tr"));
        System.out.println("allRowWithHeader.size() = " + allRowWithHeader.size());

        //number of row without column header row
        List <WebElement> allRowWithoutHeader = driver.findElements(By.xpath("//table[@id='table1']/tbody//tr"));
        System.out.println("allRowWithoutHeader.size() = " + allRowWithoutHeader.size());

    }

    @Test
    public void getSingleRow(){

        /**
         * navigate to https://the-internet.herokuapp.com/tables
         * get the second row info and print it
         * get all row and print them
         * get all row dynamically and print them
         */

        driver.get("https://the-internet.herokuapp.com/tables");
        //get the second row info and print it
        WebElement secondRow = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[2]"));
        System.out.println("secondRow.getText() = " + secondRow.getText());
        System.out.println("-----------------------");

        //get all row and print them
        List <WebElement> allRowWithoutHeader = driver.findElements(By.xpath("//table[@id='table1']/tbody//tr"));

        for (WebElement row : allRowWithoutHeader) {
            System.out.println("row.getText() = " + row.getText());
        }
        System.out.println("-----------------------");

       // get all row dynamically and print them
        System.out.println("dataOfRow(3) = " + dataOfRow(3));

        System.out.println("-----------------------");

        for (int i = 1; i <= allRowWithoutHeader.size(); i++) {
            System.out.println("dataOfRow(i) = " + dataOfRow(i));
        }

    }
    @Test
    public void getAllCellsInOneRow(){

        /**
         * navigate to https://the-internet.herokuapp.com/tables
         * get the second row info cell by cell and print it
         */

        //get the second row info and print it
        List <WebElement> secondRowInfo = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr[2]/td"));
        for (WebElement element : secondRowInfo) {
            System.out.println("element.getText() = " + element.getText());
        }

    }

    @Test
    public void getSingleCellOfTable(){
        /**
         * navigate to https://the-internet.herokuapp.com/tables
         * get the data of specific cell by using row and column numbers
         */

        int numberOfColumn=getNumberOfColumns();
        int numberOfRow=getNumberOfRows();

        for (int i =1; i <= numberOfRow; i++) {
            for (int j =1; j <=numberOfColumn ; j++) {
//                WebElement cell = driver.findElement(By.xpath("//table[@id='table1']/tbody//tr["+i+"]/td["+j+"]"));
//                System.out.print(cell.getText()+" ");
                System.out.print(dataOfCell(i, j)+" ");
            }
            System.out.println();
        }

        System.out.println("dataOfCell(2,4) = " + dataOfCell(2, 4));

    }

    private int getNumberOfRows() {
        List <WebElement> allRowWithoutHeader = driver.findElements(By.xpath("//table[@id='table1']/tbody//tr"));
        return allRowWithoutHeader.size();
    }

    private int getNumberOfColumns() {
        List<WebElement> columnHeaders = driver.findElements(By.xpath("//table[@id='table1']/thead//th"));
        return columnHeaders.size();
    }

    private String dataOfRow(int row ) {
        String xPath="//table[@id='table1']/tbody/tr["+row+"]";
        return driver.findElement(By.xpath(xPath)).getText();
    }

    String dataOfCell(int row,int column){
        String xPath="//table[@id='table1']/tbody//tr["+row+"]/td["+column+"]";
        return driver.findElement(By.xpath(xPath)).getText();
    }


}
/**
 * WebTables
 * In html tables are represented with <table> tag -- tablonun tamamını temsil eder
 * Tables are made of <thead> and <tbody> -- tablolar genellikle <thead> ve <tbody> bölümlerinden oluşur.
 * <thead> --> this is the table header, here we have table column names -- sütun başlıklarını tanımlamak içindir.
 * <tr> table row, indicates one whole row  -- tablodaki bütün bir satırı tanımlar.
 * <th> --> this tag indicates a cell that is used for table headers  -- tek bir sütun/satır başlığını tanımlamak içindir
 * <tbody> this is where the data is -- tablonun verisinin olduğu bölümü tanımlar.
 * <tr> table row, indicates one whole row -- tablodaki bütün bir satırı tanımlar.
 * <td> --> cell in a table body  -- hücreyi tanımlar ve veri burada tutulur.
 *
 * Note : Web Table'lardan veri çekmek için xPath kullanmak gerekir. (index ve child to parent işlevi nedeniyle)
 */
/**
 * div'li web tablelar ve dynamic web tablelar hakkında da bilgi verelim...
 */
