package com.eurotech.tests.day_13_iframeReview;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class _2_Iframe_Task {
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


    //first way
    //id value or name value
    @Test
    public void iframe_NameOrId() throws InterruptedException {
        /**
         * navigate to https://the-internet.herokuapp.com/iframe
         * get te text of heading "An iFrame containing the TinyMCE WYSIWYG Editor" and print it
         * Firstly clear the text area  which contains "Your content goes here."
         * And send a new text to the area : "Hello World!"
         * get te text of heading "An iFrame containing the TinyMCE WYSIWYG Editor" and print it again.
         * NOT : frame geçişlerinde id veya name kullanalım.
         */

        driver.get("https://the-internet.herokuapp.com/iframe");
        Thread.sleep(2000);

        //we will be able to locate this element since it is in the default HTML
        WebElement upTitle = driver.findElement(By.xpath("//textarea[@id='mce_0']/../h3"));
        System.out.println("upTitle.getText() = " + upTitle.getText());

        //we will not be able to locate this element since it is in another HTML/frame
        /*WebElement targetElement = driver.findElement(By.xpath("//p[text()='Your content goes here.']"));
        System.out.println("targetElement.getText() = " + targetElement.getText());*/

        //switch driver to the target html block by using "id value" or "name value"
        driver.switchTo().frame("mce_0_ifr");

        WebElement targetElement = driver.findElement(By.xpath("//p[text()='Your content goes here.']"));
        targetElement.clear();
        targetElement.sendKeys("Hello World!");

        //switch driver to the parent (default) HMTL
        //go back to parent frame
        driver.switchTo().parentFrame();

        //tekrar locate etmek gerekir mi?
        WebElement upTitle1 = driver.findElement(By.xpath("//textarea[@id='mce_0']/../h3"));
        System.out.println("upTitle1.getText() = " + upTitle1.getText());
    }

    @Test
    public void iframe_index() throws InterruptedException {
        /**
         * navigate to https://the-internet.herokuapp.com/iframe
         * get te text of heading "An iFrame containing the TinyMCE WYSIWYG Editor" and print it
         * Firstly clear the text area  which contains "Your content goes here."
         * And send a new text to the area : "Hello World!"
         * get te text of heading "An iFrame containing the TinyMCE WYSIWYG Editor" and print it again.
         * NOT : frame geçişlerinde index kullanalım. index 0'dan başlar..
         */

        driver.get("https://the-internet.herokuapp.com/iframe");
        Thread.sleep(2000);

        WebElement upTitle = driver.findElement(By.xpath("//textarea[@id='mce_0']/../h3"));
        System.out.println("upTitle.getText() = " + upTitle.getText());

        //switch driver by index number
        driver.switchTo().frame(0);

        WebElement targetElement = driver.findElement(By.xpath("//p[text()='Your content goes here.']"));

        //remove the text
        targetElement.clear();

        Thread.sleep(2000);

        //send a new text and confirm
        targetElement.sendKeys("Hello World!");

        Thread.sleep(2000);

        //switch driver to the parent (default) HMTL
        driver.switchTo().defaultContent();

        WebElement upTitle1 = driver.findElement(By.xpath("//textarea[@id='mce_0']/../h3"));
        System.out.println("upTitle1.getText() = " + upTitle1.getText());
    }

    @Test
    public void iframe_webElement() throws InterruptedException {
        /**
         * navigate to https://the-internet.herokuapp.com/iframe
         * get te text of heading "An iFrame containing the TinyMCE WYSIWYG Editor" and print it
         * Firstly clear the text area  which contains "Your content goes here."
         * And send a new text to the area : "Hello World!"
         * get te text of heading "An iFrame containing the TinyMCE WYSIWYG Editor" and print it again.
         * NOT : frame geçişlerinde web element kullanalım.
         */
        driver.get("https://the-internet.herokuapp.com/iframe");
        Thread.sleep(2000);

        WebElement upTitle = driver.findElement(By.xpath("//textarea[@id='mce_0']/../h3"));
        System.out.println("upTitle.getText() = " + upTitle.getText());

        WebElement frame = driver.findElement(By.cssSelector("#mce_0_ifr"));
        //switch driver by webelement
        driver.switchTo().frame(frame);

        WebElement targetElement = driver.findElement(By.xpath("//p[text()='Your content goes here.']"));

        //remove the text
        targetElement.clear();

        Thread.sleep(2000);

        //send a new text and confirm
        targetElement.sendKeys("Hello World!");

        Thread.sleep(2000);

        //switch driver to the parent (default) HMTL
        driver.switchTo().parentFrame();

        WebElement upTitle1 = driver.findElement(By.xpath("//textarea[@id='mce_0']/../h3"));
        System.out.println("upTitle1.getText() = " + upTitle1.getText());
    }

    @Test
    public void nestedIframe(){

        /**
         * go to https://the-internet.herokuapp.com/nested_frames
         * verify that the MIDDLE text is seen  -- by name
         * verify that the RIGHT text is seen   -- by index
         * verify that the BOTTOM text is seen  --by index
         * NOT: belirtilmeyen geçişlerde istediğiniz yöntemi kullanabilirsiniz..
         */
        driver.get("https://the-internet.herokuapp.com/nested_frames");

        //switch the middle frame and get the MIDDLE text
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-middle");
        WebElement middle = driver.findElement(By.cssSelector("#content"));
        Assert.assertTrue(middle.isDisplayed());
        System.out.println( driver.findElement(By.cssSelector("#content")).getText());

        //go to right frame and get text
        driver.switchTo().parentFrame(); // selenium switch to parent
        //driver.switchTo().defaultContent();//selenium switch the directly top
        //  driver.switchTo().frame("frame-top");---> bu hata verir. aşağıdan yukarı çıkarken parent ya da default metodları olur.
        driver.switchTo().frame(2);
        WebElement right = driver.findElement(By.xpath("//body[contains(text(),'RIGHT')]"));
        Assert.assertTrue(right.isDisplayed());
        System.out.println(driver.findElement(By.tagName("body")).getText());

        //go to bottom frame and get text
        driver.switchTo().defaultContent();// to go to HTML
        driver.switchTo().frame(1);
        // driver.switchTo().frame("frame-bottom");
        WebElement bottom = driver.findElement(By.tagName("body"));
        Assert.assertTrue(bottom.isDisplayed());
        System.out.println(driver.findElement(By.tagName("body")).getText());


    }
}
