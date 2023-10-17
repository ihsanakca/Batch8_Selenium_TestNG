package com.eurotech.tests.day_20_pom_2;

import com.eurotech.pages.AddEducationPage;
import com.eurotech.pages.DashboardPage;
import com.eurotech.pages.LoginPage;
import com.eurotech.pages.UserProfilePage;
import com.eurotech.tests.TestBase;
import com.eurotech.utilities.BrowserUtils;
import com.eurotech.utilities.ConfigurationReader;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _3_AddEducationTest_Task extends TestBase {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    UserProfilePage userProfilePage;
    AddEducationPage addEducationPage;


    @Test
    public void addEducationTest() {
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

        loginPage=new LoginPage();
        dashboardPage=new DashboardPage();
        userProfilePage=new UserProfilePage();
        addEducationPage=new AddEducationPage();

        loginPage.login(ConfigurationReader.get("userEmail"),ConfigurationReader.get("password"));

        BrowserUtils.waitForVisibility(dashboardPage.userName,5);

        String actualUserName=dashboardPage.userName.getText();
        String expectedUserName=ConfigurationReader.get("userName");
        Assert.assertEquals(actualUserName,expectedUserName,"usernames should be same");

        dashboardPage.navigateToTabsAndModules(ConfigurationReader.get("userName"),"My Profile");

        BrowserUtils.waitForVisibility(userProfilePage.userProfilePageTitle,5);
        Assert.assertTrue(userProfilePage.userProfilePageTitle.isDisplayed());

        userProfilePage.navigateUserProfileMenu("Add Education");

        wait.until(ExpectedConditions.visibilityOf(addEducationPage.addEducationBtn));
        Assert.assertTrue(addEducationPage.addEducationBtn.isDisplayed());

        addEducationPage.addEducationMtd("Gazi University","Good Degree","Finance",
                "11122018","12122021","Very nice education");

        String expectedUserSchoolName="Gazi University";
        String actualUserSchoolName=userProfilePage.addedEducationName("Gazi University");
        Assert.assertEquals(actualUserSchoolName,expectedUserSchoolName,"should be same");

        userProfilePage.deleteEducation(userProfilePage.addedEducationName("Gazi University"));

    }
}
