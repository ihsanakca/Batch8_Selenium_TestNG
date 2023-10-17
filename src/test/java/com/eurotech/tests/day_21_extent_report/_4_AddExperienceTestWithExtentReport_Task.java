package com.eurotech.tests.day_21_extent_report;

import com.eurotech.pages.*;
import com.eurotech.tests.TestBase;
import com.eurotech.utilities.BrowserUtils;
import com.eurotech.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _4_AddExperienceTestWithExtentReport_Task extends TestBase {

    LoginPage loginPage;
    DashboardPage dashboardPage;
    UserProfilePage userProfilePage;
    AddExperiencePage addExperiencePage;

    @Test
    public void addExperienceTest() {

        /**
         1-go to kraft login page
         2-make login
         3-Assert successful login with user name
         4-Navigate to My Profile with related method
         5-Verify that User Profile page is displayed
         6-Navigate to Add Experience tab with related method
         7-Verify that add experince page is displayed
         8-Fill the form with non-parameterized method (using actions class is optional)
         9-Verify that added experience record can be seen at user profile page... (assert with job title)
         10-Delete last added experience record

         important note: every student should use own credentials, otherwise the test case will fail....
         */

        extentLogger = report.createTest("TC007 Adding New Experience");

        loginPage = new LoginPage();
        dashboardPage = new DashboardPage();
        userProfilePage = new UserProfilePage();
        addExperiencePage = new AddExperiencePage();

        extentLogger.info("Navigate to " + ConfigurationReader.get("url"));
        extentLogger.info("Enter site with correct userEmail and password");
        loginPage.login();

        extentLogger.info("Verify that login is successful with account name= " + ConfigurationReader.get("userName"));
        BrowserUtils.waitForVisibility(dashboardPage.userName, 5);
        String expectedUserName = ConfigurationReader.get("userName");
        String actualUserName = dashboardPage.userName.getText();
        Assert.assertEquals(actualUserName, expectedUserName);

        extentLogger.info("Navigate to My Profile");
        dashboardPage.navigateToTabsAndModules(ConfigurationReader.get("userName"), "My Profile");
        BrowserUtils.waitForVisibility(userProfilePage.userProfilePageTitle,5);

        extentLogger.info("Navigate to Add Experience tab");
        userProfilePage.navigateUserProfileMenu("Add Experience");

        extentLogger.info("Adding new experience");
        addExperiencePage.addExperienceMtd();

        extentLogger.info("Verify that added experience record can be seen at user profile page");
        BrowserUtils.waitForVisibility(userProfilePage.userProfilePageTitle, 5);
        String actualExperienceRecord = userProfilePage.addedExperienceName(addExperiencePage.jobTitleName);
        String expectedExperienceRecord = addExperiencePage.jobTitleName;
        Assert.assertEquals(actualExperienceRecord, expectedExperienceRecord);

        extentLogger.info("Delete last added experience record");
        userProfilePage.deleteExperience(addExperiencePage.jobTitleName);

        extentLogger.pass("PASSED");

    }
}
