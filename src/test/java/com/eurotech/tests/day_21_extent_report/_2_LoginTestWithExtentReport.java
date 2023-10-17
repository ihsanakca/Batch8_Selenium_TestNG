package com.eurotech.tests.day_21_extent_report;

import com.eurotech.pages.DashboardPage;
import com.eurotech.pages.LoginPage;
import com.eurotech.tests.TestBase;
import com.eurotech.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _2_LoginTestWithExtentReport extends TestBase {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    @Test
    public void positiveLoginTest_4(){

        /**
         * navigate to kraft login page
         * login with valid credentials
         * verify that the user's name is seen on dashboard page
         *
         * note: do login process with login() method  //without parameter
         */
        extentLogger=report.createTest("TC001 Positive Login Test");

        loginPage = new LoginPage();
        dashboardPage=new DashboardPage();

        extentLogger.info("navigate to kraft login page");
        extentLogger.info("login with valid credentials");
        loginPage.login();

        extentLogger.info("verify that the user's name is seen on dashboard page");
        String actualUserName = dashboardPage.userName.getText();
        String expectedUserName= ConfigurationReader.get("userName");
        Assert.assertEquals(actualUserName,expectedUserName,"should be same");

        extentLogger.pass("Passed.");
    }

    @Test
    public void wrongPasswordTest() {
        /**
         * navigate to https://www.krafttechexlab.com/login
         * type in correct username
         * type in wrong password
         * verify that user cannot login
         * and takes the warning message: "Password is incorrect. Please check"
         */

        extentLogger=report.createTest("TC003 Negative Login Test (Wrong Password)");

        loginPage=new LoginPage();

        extentLogger.info("navigate to "+ConfigurationReader.get("url"));
        extentLogger.info("type in correct username");
        loginPage.emailBox.sendKeys(ConfigurationReader.get("userEmail"));

        extentLogger.info("type in wrong password");
        loginPage.passwordBox.sendKeys("wrongPassword");

        extentLogger.info("click on login button");
        loginPage.loginBtn.click();

        extentLogger.info("verify that the warning message has: Password is incorrect. Please check");
        String actualMessage = loginPage.wrongPasswordWarningMessage.getText();
        String expectedMessage="Password is incorrect. Please check";
        Assert.assertEquals(actualMessage,expectedMessage,"Both message should be same");

        extentLogger.pass("Passed.");
    }
}
