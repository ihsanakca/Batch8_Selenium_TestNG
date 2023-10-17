package com.eurotech.tests.day_20_pom_2;

import com.eurotech.pages.DashboardPage;
import com.eurotech.pages.LoginPage;
import com.eurotech.tests.TestBase;
import com.eurotech.utilities.BrowserUtils;
import com.eurotech.utilities.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _1_DashboardTest extends TestBase {
    @Test
    public void tabMenuTest(){

        /**
         * go to kraft login page
         * login with valid credentials
         * verify that you are on the dashboard page by using 'Dashboard' keyword at top-left
         * Verify that tabs menu contains "Dashboard", "Developers", "Components", "Forms",  "JavaScript", "Melih Gezer"
         */

        LoginPage loginPage = new LoginPage();

        loginPage.login();

        List<WebElement> tabs = loginPage.tabMenus;

        List<String> actualList = new ArrayList<>();

        for (WebElement tab : tabs) {
            actualList.add(tab.getText());
        }

        List<String> expectedList = new ArrayList<>(
                Arrays.asList("Dashboard", "Developers", "Components", "Forms", "JavaScript","Melih Gezer"));

        Assert.assertEquals(actualList,expectedList);
    }


    @Test
    public void navigateMenu_1(){

        /**
         * login with valid credentials
         * go to 'developers' tab via navigateToTabs()
         * validate that you are on the right page through url
         * expectedUrl = https://www.krafttechexlab.com/developers
         */

        LoginPage loginPage = new LoginPage();
        loginPage.login();

        BrowserUtils.waitFor(2);

        DashboardPage dashboardPage=new DashboardPage();

        dashboardPage.navigateToTabs("Developers");

        BrowserUtils.waitFor(2);

        String expectedUrl = "https://www.krafttechexlab.com/developers";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl,expectedUrl);
    }


    @Test
    public void navigateMenu_2(){

        /**
         * login with valid credentials
         * go to 'Components --> Modal' submodule via navigateToTabsModule()
         * validate that you are on the right page through url
         */


        LoginPage loginPage = new LoginPage();
        loginPage.login();

        BrowserUtils.waitFor(2);

        DashboardPage dashboardPage=new DashboardPage();

        dashboardPage.navigateToTabsAndModules("Components", "Modal");

        BrowserUtils.waitFor(2);

        String expectedUrl = "https://www.krafttechexlab.com/components/modal";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl,expectedUrl);
    }


}
