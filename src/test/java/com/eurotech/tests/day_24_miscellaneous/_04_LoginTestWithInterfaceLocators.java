package com.eurotech.tests.day_24_miscellaneous;



import com.eurotech.pages.LocatorsLoginPage;
import com.eurotech.tests.TestBase;
import com.eurotech.utilities.ConfigurationReader;
import org.testng.annotations.Test;

public class _04_LoginTestWithInterfaceLocators extends TestBase implements LocatorsLoginPage {

    @Test
    public void loginTest_1(){
        /**
         * navigate to kraft login page
         * Prepare an interface and put emailBox, passwordBox and Login button locators there
         * call these locators and send keys to them and have login to the site
         */

        driver.findElement(emailBox_loc).sendKeys(ConfigurationReader.get("userEmail"));
        driver.findElement(passwordBox_loc).sendKeys(ConfigurationReader.get("password"));
        driver.findElement(loginBtn_loc).click();
    }

    @Test
    public void loginTest_2(){

        /**
         * navigate to kraft login page
         * Prepare a login method in the interface
         * call this method and have login to the site
         */

        login();
    }
}
