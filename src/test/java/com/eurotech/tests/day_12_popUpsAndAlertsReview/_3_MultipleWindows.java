package com.eurotech.tests.day_12_popUpsAndAlertsReview;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class _3_MultipleWindows {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().setPosition(new Point(-1000, 0));
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void test1() throws InterruptedException {

        /**
         *navigate to "https://testpages.herokuapp.com/styled/windows-test.html"
         * click Basic Ajax in new page
         * switch to new opened page
         * verify that the page title is "Test Page For Basic Ajax Example"
         * verify that the new page's url is different
         */

        driver.get("https://testpages.herokuapp.com/styled/windows-test.html");
        driver.findElement(By.linkText("Basic Ajax in new page")).click();
        Thread.sleep(2000);

        String currentTab = driver.getWindowHandle();
        Set<String> tabs = driver.getWindowHandles();

        System.out.println("currentTab = " + currentTab);
        System.out.println("tabs = " + tabs);

        for (String tab : tabs) {
            if (!currentTab.equals(tab)){
                driver.switchTo().window(tab);
                break;
            }
        }

        String actualTitle= driver.getTitle();
        String expectedTitle= "Test Page For Basic Ajax Example";

        Assert.assertEquals(actualTitle,expectedTitle);
        Assert.assertFalse(driver.getCurrentUrl().equals("https://testpages.herokuapp.com/styled/windows-test.html"));


    }

    @Test
    public void test2() throws InterruptedException {
        /**
         *navigate to "https://testpages.herokuapp.com/styled/windows-test.html"
         * click all three links
         * switch to the page whose title is "Test Page For Element Attributes"
         * verify that the page title
         * verify that the new page's url is different
         */
        driver.get("https://testpages.herokuapp.com/styled/windows-test.html");
        driver.findElement(By.linkText("Basic Ajax in new page")).click();
        driver.findElement(By.linkText("Attributes in new page")).click();
        driver.findElement(By.linkText("Alerts In A New Window From JavaScript")).click();
        Thread.sleep(2000);

        Set<String> allTabs = driver.getWindowHandles();

        String targetTitle="Test Page For Element Attributes";

        for (String tab : allTabs) {
            driver.switchTo().window(tab);
            if (driver.getTitle().equals(targetTitle)){
                break;
            }
        }

        String actualTitle= driver.getTitle();
        Assert.assertEquals(actualTitle,targetTitle);

        Assert.assertFalse(driver.getCurrentUrl().equals("https://testpages.herokuapp.com/styled/windows-test.html"));


    }

    @Test
    public void multipleWindow_Task() throws InterruptedException {

        /**
         * https://the-internet.herokuapp.com/windows sayfasını açın
         * "Click Here" linkine tıklayın
         * yeni açılan pencereye geçin
         * yeni açılan sayfada "New Window" başlığının olduğunu doğrulayın.
         * yeni açılan pencerenin title ve url'sini alıp yazdırın. (isterseniz bunları kullanarak verification yapabilirsiniz)
         */

        driver.get("https://the-internet.herokuapp.com/windows");
        WebElement clickHereButton = driver.findElement(By.xpath("//a[.='Click Here']"));
        clickHereButton.click();

        Thread.sleep(2000);

        //switched between windows
        String currentWindow = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();

        for (String windowHandle : windowHandles) {
            if(!currentWindow.equals(windowHandle)){
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        //verification
        WebElement newWindow = driver.findElement(By.xpath("//h3[.='New Window']"));
        String actual = newWindow.getText();
        String expected = "New Window";
        Assert.assertEquals(actual,expected);

    }
}
