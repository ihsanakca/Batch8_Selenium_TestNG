package com.eurotech.tests.day_19_pom_1;


import com.eurotech.pages.DashboardPage;
import com.eurotech.pages.LoginPage;
import com.eurotech.tests.TestBase;
import com.eurotech.utilities.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _3_TestWithListOfWebElement extends TestBase {

    @Test
    public void positiveLoginTestWithListOfWebElement(){
        /**
         * navigate to https://www.krafttechexlab.com/login
         * login with valid credentials (use list of element)
         * verify success login user's name (Melih Gezer)
         *
         * note: use with verification both user names which are seen after success login
         */


        LoginPage loginPage=new LoginPage();

        loginPage.inputs.get(0).sendKeys(ConfigurationReader.get("userEmail"));
        loginPage.inputs.get(1).sendKeys(ConfigurationReader.get("password"));
        loginPage.inputs.get(2).click();

        DashboardPage dashboardPage=new DashboardPage();
        String actualUserName = dashboardPage.userNameAtTheTabMenu.getText();
        String expectedUserName="Melih Gezer";

        Assert.assertEquals(actualUserName,expectedUserName);

        String actualUserName_2=dashboardPage.userName.getText();

        Assert.assertEquals(actualUserName_2,expectedUserName);

    }


    @Test
    public void listOfWebElement(){

        /**   **************  ANLATILMAYACAK  ****************
         * go to kraft login page
         * login with valid credentials
         * Verify that tabs menu contains "Dashboard", "Developers", "Components", "Forms",  "JavaScript", "Melih Gezer"
         */

        LoginPage loginPage = new LoginPage();

        loginPage.emailBox.sendKeys(ConfigurationReader.get("userEmail"));
        loginPage.passwordBox.sendKeys(ConfigurationReader.get("userPassword"));
        loginPage.loginBtn.click();

        List<WebElement> tabs = loginPage.tabMenus;

        List<String> actualList = new ArrayList<>();

        for (WebElement tab : tabs) {
            actualList.add(tab.getText());
        }

        List<String> expectedList = new ArrayList<>(
                Arrays.asList("Dashboard", "Developers", "Components", "Forms", "JavaScript","mike"));

        Assert.assertEquals(actualList,expectedList);
    }
}
