package com.eurotech.tests.day_21_extent_report;

import com.eurotech.pages.AddEducationPage;
import com.eurotech.pages.DashboardPage;
import com.eurotech.pages.LoginPage;
import com.eurotech.pages.UserProfilePage;
import com.eurotech.tests.TestBase;
import com.eurotech.utilities.BrowserUtils;
import com.eurotech.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _3_AddEducationTestWithExtentReport extends TestBase {

    LoginPage loginPage;
    DashboardPage dashboardPage;
    UserProfilePage userProfilePage;
    AddEducationPage addEducationPage;

    @Test
    public void addEducationTest(){
        /**
         1-open chrome browser
         2-navigate to https://www.krafttechexlab.com/login by using configuration.properties
         3-login with parameterized/non-parameterized method
         4-Assert successful login with user name
         5-Navigate to My Profile with related method
         6-Verify that User Profile page is displayed
         7-Navigate to Add Education tab with related method
         8-Verify that add education page is displayed
         9-Fill the form with parameterized method (use actions class)
         10-Verify that added education record can be seen at user profile page... (assert with school name)
         11-Delete last added education record

         important note: every student should use own credentials, otherwise the test case will fail....
         */

        extentLogger = report.createTest("TC008 Adding New Education");

        loginPage=new LoginPage();
        dashboardPage=new DashboardPage();
        userProfilePage=new UserProfilePage();
        addEducationPage=new AddEducationPage();

        extentLogger.info("Navigate to " + ConfigurationReader.get("url"));
        extentLogger.info("Enter site with correct userEmail and password");
        loginPage.login();

        extentLogger.info("Assert successful login with user name");
        String actualUserName=dashboardPage.userName.getText();
        String expectedUserName= ConfigurationReader.get("userName");
        Assert.assertEquals(actualUserName,expectedUserName);

        extentLogger.info("Navigate to My Profile page");
        dashboardPage.navigateToTabsAndModules(ConfigurationReader.get("userName"),"My Profile");

        extentLogger.info("Verify that User Profile page is displayed");
        Assert.assertTrue(userProfilePage.userProfilePageTitle.isDisplayed());

        extentLogger.info("Navigate to Add Education tab");
        userProfilePage.navigateUserProfileMenu("Add Education");

//        Assert.assertTrue(new WebDriverWait(driver,5)
//                .until(ExpectedConditions.visibilityOf(addEducationPage.addEducationBtn)).isDisplayed());

        extentLogger.info("Verify that add education page is displayed");
        Assert.assertTrue(BrowserUtils.waitForVisibility(addEducationPage.addEducationBtn,5).isDisplayed());

        extentLogger.info("Fill the education form");
        addEducationPage.addEducationMtd
                ("ITU","First","Engineering","10102017","08102022","Hard program");


        extentLogger.info("Verify that added education record can be seen at user profile page");
        String actualSchoolName = userProfilePage.addedEducationName("ITU");
        String expectedSchoolName="ITU";
        Assert.assertEquals(actualSchoolName,expectedSchoolName);

        extentLogger.info("Delete last added education record");
        userProfilePage.deleteEducation("ITU");

        extentLogger.pass("Passed.");

    }
}
