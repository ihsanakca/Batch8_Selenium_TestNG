package com.eurotech.tests.day_19_pom_1;


import com.eurotech.pages.DashboardPage;
import com.eurotech.pages.LoginPage;
import com.eurotech.tests.TestBase;
import com.eurotech.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _1_PositiveLoginTest extends TestBase {

    @Test
    public void positiveLoginTest_OldVersion(){
        /**
         * navigate to https://www.krafttechexlab.com/login
         * login with valid credentials
         * verify success login with page title (contains Dashboard)
         */

        WebElement emailBox = driver.findElement(By.id("email"));
        WebElement passwordBox = driver.findElement(By.id("yourPassword"));
        WebElement loginBtn=driver.findElement(By.xpath("//button[text()='Login']"));

        emailBox.sendKeys(ConfigurationReader.get("userEmail"));
        passwordBox.sendKeys(ConfigurationReader.get("password"));
        loginBtn.click();

        String actualTitle = driver.getTitle();
        String expectedTitle="Dashboard";

        Assert.assertTrue(actualTitle.contains(expectedTitle));

    }

    @Test
    public void positiveLoginTest_1(){
        /**
         * navigate to https://www.krafttechexlab.com/login
         * login with valid credentials
         * verify success login with page title (contains Dashboard)
         */

        LoginPage loginPage=new LoginPage();

        WebElement emailInputBox = loginPage.emailBox;
        WebElement passwordInputBox=loginPage.passwordBox;
        WebElement loginButton=loginPage.loginBtn;

        emailInputBox.sendKeys(ConfigurationReader.get("userEmail"));
        passwordInputBox.sendKeys(ConfigurationReader.get("password"));
        loginButton.click();



//        loginPage.emailBox.sendKeys(ConfigurationReader.get("userEmail"));
//        loginPage.passwordBox.sendKeys(ConfigurationReader.get("password"));
//        loginPage.loginBtn.click();

        String actualTitle = driver.getTitle();
        String expectedTitle="Dashboard";

        Assert.assertTrue(actualTitle.contains(expectedTitle));

    }

    @Test
    public void positiveLoginTest_WithFindBysAndFindAll(){
        /**
         * navigate to https://www.krafttechexlab.com/login
         * login with valid credentials
         * verify success login with page title (contains Dashboard)
         */

        LoginPage loginPage=new LoginPage();

        loginPage.emailBoxWithFindBys.sendKeys(ConfigurationReader.get("userEmail"));
        loginPage.passwordBoxWithFindAll.sendKeys(ConfigurationReader.get("password"));
        loginPage.loginBtn.click();


        String actualTitle = driver.getTitle();
        String expectedTitle="Dashboard";

        Assert.assertTrue(actualTitle.contains(expectedTitle));

    }

    @Test
    public void positiveLoginTest_2(){
        /**
         * navigate to kraft login page
         * login with valid credentials
         * verify that the user's name is seen on dashboard page
         *
         * note: do login process with login(userEmail,password) method
         */

        LoginPage loginPage=new LoginPage();

        loginPage.login(ConfigurationReader.get("userEmail"),ConfigurationReader.get("password"));

        DashboardPage dashboardPage=new DashboardPage();
        String actualUserName = dashboardPage.userName.getText();
        String expectedUserName="Melih Gezer";

        Assert.assertEquals(actualUserName,expectedUserName);

    }

    @Test
    public void positiveLoginTest_3(){
        /**
         * navigate to kraft login page
         * login with valid credentials
         * verify that the user's name is seen on dashboard page
         *
         * note: do login process with login() method  //without parameter
         */

        LoginPage loginPage=new LoginPage();

        loginPage.login();

        DashboardPage dashboardPage=new DashboardPage();
        String actualUserName = dashboardPage.userName.getText();
        String expectedUserName="Melih Gezer";

        Assert.assertEquals(actualUserName,expectedUserName);

    }
}
