package com.eurotech.tests.day_15_actions_fileUpload_jsExecutor;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class _1_ActionClass {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().setPosition(new Point(-1000, 0));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void hoverOver() {
        /**
         * navigate to https://testpages.herokuapp.com/styled/csspseudo/css-hover.html
         * hover over "Hover Para" element
         * get the text which is seen after hover action
         * and verify that the text is "You can see this paragraph now that you hovered on the above 'button'."
         * also verify that the text is displayed (use explicit wait)
         * hover over the "Hover Div" and verify that the text is not displayed anymore. (use explicit wait)
         */
        driver.get("https://testpages.herokuapp.com/styled/csspseudo/css-hover.html");
        WebElement hoverPara = driver.findElement(By.id("hoverpara"));
        Actions actions = new Actions(driver);

        actions.moveToElement(hoverPara).perform();

        WebElement hoverEffect = driver.findElement(By.id("hoverparaeffect"));
        String actualText = hoverEffect.getText();
        String expectedText = "You can see this paragraph now that you hovered on the above 'button'.";
        Assert.assertEquals(actualText, expectedText);
        Assert.assertTrue(new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(hoverEffect)).isDisplayed());

        WebElement hoverDiv = driver.findElement(By.id("hoverdivpara"));
        actions.moveToElement(hoverDiv).perform();
        Assert.assertTrue(new WebDriverWait(driver, 10).until(ExpectedConditions.invisibilityOf(hoverEffect)));

    }

    @Test
    public void hoverOver_Task() {
        /**
         * go to https://the-internet.herokuapp.com/hovers
         * locate all users (image on the page) with findElements()
         * hover over all of them and verify that "name:user1-2-3" is displayed
         * if any time issues solve them with implicitly or explicitly waits
         */
//        driver.get("https://the-internet.herokuapp.com/hovers");
//        Actions actions = new Actions(driver);
        /*
        List<WebElement> users = driver.findElements(By.xpath("//img[@alt='User Avatar']"));

        //moveToElement()--> move your mouse to the web element ( hover over)
        //perform()--> perform the action, complete the action
        actions.moveToElement(users.get(0)).perform();
        WebElement user1 = driver.findElement(By.xpath("//*[.='name: user1']"));
        Assert.assertTrue(user1.isDisplayed(), "Verify that element is displayed");

        actions.moveToElement(users.get(1)).perform();
        WebElement user2 = driver.findElement(By.xpath("//*[.='name: user2']"));
        Assert.assertTrue(user2.isDisplayed(), "Verify that element is displayed");

        actions.moveToElement(users.get(2)).perform();
        WebElement user3 = driver.findElement(By.xpath("//*[.='name: user3']"));
        //    Assert.assertTrue(user3.isDisplayed(),"Verify that element is displayed");

        Assert.assertTrue(new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(user3)).isDisplayed());
*/
        driver.get("https://the-internet.herokuapp.com/hovers");
        Actions actions = new Actions(driver);
        for (int i = 2; i <=4 ; i++) {

            //(//img)[2]
            //(//img)[3]
            //(//img)[4]

            String imgXpath="(//img)["+i+"]";
            //üzerinde hover yapılan elementlere img dersek
            WebElement img=driver.findElement(By.xpath(imgXpath));

            actions.moveToElement(img).perform();

            //h5[text()='name: user1']
            //h5[text()='name: user2']
            //h5[text()='name: user3']

            String textXpath="//h5[text()='name: user"+(i-1)+"']";
           //üzerinde hover yapılınca altta çıkan yazılara text dersek
            WebElement text=driver.findElement(By.xpath(textXpath));

            Assert.assertTrue(new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(text)).isDisplayed());
        }


    }

    @Test
    public void dragAndDrop() {
        /**
         * go to https://webdriveruniversity.com/Actions/index.html
         * take the "DRAG ME TO MY TARGET!" box and drop it "DROP HERE!" place
         * verify that "Dropped!" text is displayed..(make text correction at the same time)
         */
        driver.get("https://webdriveruniversity.com/Actions/index.html");
        WebElement drag = driver.findElement(By.cssSelector("div#draggable"));
        WebElement drop = driver.findElement(By.cssSelector("div#droppable"));

        Actions actions = new Actions(driver);
        //1.way
        actions.dragAndDrop(drag, drop).perform();

        //2.way
     //          actions.moveToElement(drag).clickAndHold().moveToElement(drop).pause(2000).release().build().perform();

        //verification
        WebElement droppedElement = driver.findElement(By.cssSelector("div#droppable>p"));
        String actualText = droppedElement.getText();
        String expectedText = "Dropped!";
        Assert.assertTrue(droppedElement.isDisplayed());
        Assert.assertEquals(actualText, expectedText);
    }

    @Test
    public void dragAndDrop_Task() {
        /**
         * go to https://demoqa.com/droppable
         * take "Drag me" and drop it "Drop here" section
         * verify that the "Dropped!" message is displayed (make text verification)
         */
        driver.get("https://demoqa.com/droppable");

        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.xpath("(//div[@id='droppable'])[1]"));

        Actions actions = new Actions(driver);

        actions.dragAndDrop(source, target).perform();

        WebElement verifyMessage = driver.findElement(By.xpath("//p[text()='Dropped!']"));
        System.out.println("verifyMessage.getText() = " + verifyMessage.getText());

        Assert.assertTrue(verifyMessage.isDisplayed());
        Assert.assertEquals(verifyMessage.getText(), "Dropped!", "Verify that element has dropped");
    }

    @Test
    public void clickWithAction() throws InterruptedException {
        /**
         * navigate to https://skill-test.net/mouse-double-click
         * make double click to the Click box
         * make a normal click to the Click Box (not the middle of element)
         * click on Right Click Test link from left menu (use actions)
         * make right click to the Start box and wait three seconds
         * make normal click on Reset box (use actions)
         */

        driver.get("https://skill-test.net/mouse-double-click");
        WebElement clicker = driver.findElement(By.id("clicker"));
        Actions actions = new Actions(driver);

        //1.yol
        actions.doubleClick(clicker).perform();
        //2.yol
      //  actions.moveToElement(clicker).doubleClick().perform();

        //tıklama yeri (normalde ortadır)---> 5 sağa, 5 aşağıya
          actions.moveToElement(clicker,5,5).click().build().perform();

        WebElement rightClick = driver.findElement(By.xpath("//span[text()='Right Click Test']"));

        //1.yol
     //   actions.moveToElement(rightClick).click().perform();
        //2.yol
        actions.click(rightClick).perform();

        Thread.sleep(3000);

        WebElement rightClickPlace=driver.findElement(By.id("clicker"));


        actions.contextClick(rightClickPlace).perform();
        Thread.sleep(3000);
        WebElement resetBtn=driver.findElement(By.id("reset"));
        actions.moveToElement(resetBtn).click().perform();

    }

    @Test
    public void fillingFormWithAction() {
        /**
         * go to http://www.eurotech.study/
         * accept cookies
         * click login
         * send your credentials to related boxes and then click login button
         * click on Add Experience link
         * fill form with action class
         * verify the success message after submitted the form
         */
        driver.get("http://www.eurotech.study/");
        driver.findElement(By.id("rcc-confirm-button")).click();

        WebElement loginBtn = driver.findElement(By.linkText("Login"));
        loginBtn.click();

        List<WebElement> inputs = driver.findElements(By.cssSelector("input"));

        //send your credentials to related boxes and then click login button
        inputs.get(0).sendKeys("sgezer56@gmail.com");
        inputs.get(1).sendKeys("Sg12345678");
        inputs.get(2).click();

        WebElement addExperience=driver.findElement(By.linkText("Add Experience"));
        addExperience.click();

        WebElement jobTitle=driver.findElement(By.id("addexperience-jobtitle-input"));
        Actions actions=new Actions(driver);

        actions.click(jobTitle)
                .sendKeys("QA Engineer"+Keys.TAB)
                .sendKeys("Google"+Keys.TAB)
                .sendKeys("İstanbul"+Keys.TAB)
                .sendKeys("01012020"+Keys.TAB+Keys.TAB)
                .sendKeys("11112022"+Keys.TAB+Keys.TAB)
                .sendKeys("Nice Job"+Keys.TAB+Keys.ENTER).perform();

        String expectedMessage="Experience Added";
        String actualMessage=driver.findElement(By.cssSelector(".alert.alert-success")).getText();
        Assert.assertEquals(actualMessage,expectedMessage);

    }

    @Test
    public void fillingFormWithAction_Task() {
        /**
         * go to http://www.eurotech.study/
         * accept cookies
         * click login
         * send your credentials to related boxes and then click login button
         * click on Add Education link
         * fill form with action class
         * verify the success message after submitted the form
         */
        driver.get("http://www.eurotech.study/");
        driver.findElement(By.id("rcc-confirm-button")).click();

        WebElement loginBtn = driver.findElement(By.linkText("Login"));
        loginBtn.click();

        List<WebElement> inputs = driver.findElements(By.cssSelector("input"));

        //send your credentials to related boxes and then click login button
        inputs.get(0).sendKeys("sgezer56@gmail.com");
        inputs.get(1).sendKeys("Sg12345678");
        inputs.get(2).click();

        WebElement addExperience=driver.findElement(By.linkText("Add Education"));
        addExperience.click();

        WebElement schoolOrBootcamp=driver.findElement(By.id("addecutaion-form-addschool-btn"));
        Actions actions=new Actions(driver);

        actions.click(schoolOrBootcamp)
                .sendKeys("Euro Tech"+Keys.TAB)
                .sendKeys("Master Degree"+Keys.TAB)
                .sendKeys("Tester"+Keys.TAB)
                .sendKeys("01012020"+Keys.TAB+Keys.TAB)
                .sendKeys("11112022"+Keys.TAB+Keys.TAB)
                .sendKeys("Nice course"+Keys.TAB+Keys.ENTER).perform();

        String expectedMessage="Education Added";
        String actualMessage=driver.findElement(By.cssSelector(".alert.alert-success")).getText();
        Assert.assertEquals(actualMessage,expectedMessage);



    }

    @Test
    public void rightClickOpenNewWindow() throws InterruptedException {
        /**
         * go to https://testpages.herokuapp.com/styled/csspseudo/css-hover.html
         * make right click and open in new tab  (sağ ctrl+click)
         * switch to new opened tab
         * verify that the page title is "EvilTester.com"
         */
        driver.get("https://testpages.herokuapp.com/styled/csspseudo/css-hover.html");
        Thread.sleep(2000);
        WebElement evilTesterPage = driver.findElement(By.linkText("EvilTester.com"));
        Actions actions = new Actions(driver);

        actions.keyDown(Keys.LEFT_CONTROL)
                .click(evilTesterPage)
                .keyUp(Keys.LEFT_CONTROL)
                .build()
                .perform();

        ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tab.get(1));
        String  actualTitle=driver.getTitle();
        String expectedTitle="EvilTester.com";

        Assert.assertEquals(actualTitle,expectedTitle);
    }

    @Test
    public void fillingFormWithAction_Task_Gulden() throws InterruptedException {

/**
 * go to http://www.eurotech.study/
 * accept cookies
 * click login
 * send your credentials to related boxes and then click login button
 * click on Add Education link
 * fill form with action class
 * verify the success message after submitted the form
 */

        driver.get("http://www.eurotech.study/");
        WebElement cookies = driver.findElement(By.id("rcc-confirm-button"));
        cookies.click();

        WebElement login = driver.findElement(By.linkText("Login"));
        login.click();

        List<WebElement> inputs = driver.findElements(By.xpath("//input"));
        inputs.get(0).sendKeys("obiwan@gmail.com");
        inputs.get(1).sendKeys("123456");
        inputs.get(2).click();

        WebElement education = driver.findElement(By.cssSelector("a[class='btn btn-light']:nth-of-type(3)"));
        education.click();
        Actions actions = new Actions(driver);

        WebElement educationForm = driver.findElement(By.id("addecutaion-form-addschool-btn"));
        actions.click(educationForm)
                .sendKeys("Jedi" + Keys.TAB)
                .sendKeys("Master" + Keys.TAB)
                .sendKeys("Force" +Keys.TAB)
                .sendKeys("11051977" + Keys.TAB + Keys.TAB)
                .sendKeys("11122019" + Keys.TAB + Keys.TAB)
                .sendKeys("May the" + Keys.TAB + Keys.ENTER).perform();

    }



}
