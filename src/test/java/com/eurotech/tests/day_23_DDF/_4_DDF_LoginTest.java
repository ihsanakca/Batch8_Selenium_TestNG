package com.eurotech.tests.day_23_DDF;


import com.eurotech.pages.DashboardPage;
import com.eurotech.pages.LoginPage;
import com.eurotech.tests.TestBase;
import com.eurotech.utilities.ConfigurationReader;
import com.eurotech.utilities.ExcelUtil;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class _4_DDF_LoginTest extends TestBase {

    /**
     * Make login test with DDF (Excel File)
     * Use LoginList.xlsx and QaTeam1 sheet
     * Report's name should arrange dynamically
     */

    LoginPage loginPage;
    DashboardPage dashboardPage;

    @DataProvider
    public Object[][] userData() {
        ExcelUtil qaTeam1 = new ExcelUtil(ConfigurationReader.get("excelPath"), "QaTeam1");
        String[][] data = qaTeam1.getDataArrayWithoutFirstRow();
        return data;
    }

    @Test(dataProvider = "userData")
    public void loginTestWithDDF(String yourName, String yourEmail, String password) {
        extentLogger = report.createTest("TC_0005 DDF " + yourName + "'s Login Test");

        loginPage = new LoginPage();
        dashboardPage = new DashboardPage();

        extentLogger.info("navigate to Login page");
        extentLogger.info("login with valid credentials");
        loginPage.login(yourEmail, password);

        extentLogger.info("verify success login with username");
        String actualName = dashboardPage.userName.getText();
        Assert.assertEquals(actualName, yourName);

        extentLogger.pass("Passed");

    }

    /**
     * Make login test with DDF (Excel File)
     * Use LoginList.xlsx and QaTeam2 sheet
     * Report's name should arrange dynamically
     */


    @DataProvider
    public Object[][] userData_2() {
        ExcelUtil qaTeam2 = new ExcelUtil(ConfigurationReader.get("excelPath"), "QaTeam2");
        String[][] data = qaTeam2.getDataArrayWithoutFirstRow();
        return data;
    }

    @Test(dataProvider = "userData_2")
    public void loginTestWithDDF_2(String yourEmail, String password, String yourName) {
        extentLogger = report.createTest("TC_0005 DDF " + yourName + "'s Login Test");

        loginPage = new LoginPage();
        dashboardPage = new DashboardPage();

        extentLogger.info("navigate to Login page");
        extentLogger.info("login with valid credentials");
        loginPage.emailBox.sendKeys(yourEmail);
        loginPage.passwordBox.sendKeys(password);
        loginPage.loginBtn.click();

        extentLogger.info("verify success login with username");
        String actualName = dashboardPage.userName.getText();
        Assert.assertEquals(actualName, yourName);

        extentLogger.pass("Passed");

    }

}
