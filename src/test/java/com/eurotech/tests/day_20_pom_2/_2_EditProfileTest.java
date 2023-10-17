package com.eurotech.tests.day_20_pom_2;

import com.eurotech.pages.DashboardPage;
import com.eurotech.pages.EditProfilePage;
import com.eurotech.pages.LoginPage;
import com.eurotech.pages.UserProfilePage;
import com.eurotech.tests.TestBase;
import com.eurotech.utilities.BrowserUtils;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _2_EditProfileTest extends TestBase {

    LoginPage loginPage=new LoginPage();

    @Test
    public void editProfileTest() {
        /**
         * Class Task
         * THIS TASK WILL BE IMPLEMENTED USING POM
         * which means we will have one test class for the test
         * and one corresponding page having all locators and actions for the page
         *
         * go to https://www.krafttechexlab.com/login
         * enter valid credentials (your credentials)
         * wait for usernames are displayed (both middle and right top)
         * go to Melih Gezer --> myProfile
         * wait for page title is displayed
         *** create a method that navigate you to specific module based on the given parameter
         * go to Edit Profile page using the method just mentioned above
         * fill out the fields
         * -->about --> SDET programme , graduated from KraftTech
         * -->Company --> Google
         * -->Job  --> QA Automation Engineer
         * -->Website --> www.google.com
         * -->Location --> Istanbul
         * -->Skills --> Java,Selenium, TestNG
         * click save changes button
         * verify that "Profile updated" message is appeared
         */

        LoginPage loginPage=new LoginPage();
        DashboardPage dashboardPage=new DashboardPage();
        UserProfilePage userProfilePage=new UserProfilePage();
        EditProfilePage editProfilePage=new EditProfilePage();

        loginPage.login();

        BrowserUtils.waitForVisibility(dashboardPage.userName, 5);
        BrowserUtils.waitForVisibility(dashboardPage.userNameAtTheTabMenu, 5);

        dashboardPage.navigateToTabsAndModules("Melih Gezer","My Profile");

        BrowserUtils.waitForVisibility(userProfilePage.userProfilePageTitle, 5);

        userProfilePage.navigateUserProfileMenu("Edit Profile");

        editProfilePage.aboutInputBox.clear();
        editProfilePage.aboutInputBox.sendKeys("SDET programme , graduated from KraftTech");

        editProfilePage.companyInputBox.clear();
        editProfilePage.companyInputBox.sendKeys("Google");

//         Select select=new Select(editProfilePage.jobInputBox);
//         select.selectByVisibleText("QA Automation Engineer");

        editProfilePage.selectJob("QA Automation Engineer");

        editProfilePage.websiteInputBox.clear();
        editProfilePage.websiteInputBox.sendKeys("www.google.com");

        editProfilePage.locationInputBox.clear();
        editProfilePage.locationInputBox.sendKeys("Istanbul");

        editProfilePage.skillsInputBox.clear();
        editProfilePage.skillsInputBox.sendKeys("Java,Selenium,TestNG");

      //  editProfilePage.saveChangeBtn.click();

        String expectedMessage="Profile Updated";
        //String actualMessage=userProfilePage.updateMessage.getText();
        String actualMessage=userProfilePage.updateMessageGetText();

        Assert.assertEquals(actualMessage,expectedMessage);



        BrowserUtils.waitFor(3);



    }
}
