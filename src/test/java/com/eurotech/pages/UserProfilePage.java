package com.eurotech.pages;

import com.eurotech.utilities.BrowserUtils;
import com.eurotech.utilities.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserProfilePage extends BasePage{

    @FindBy(css = ".breadcrumb>li:nth-of-type(2)")
    public WebElement userProfilePageTitle;

    @FindBy(css = "[role='alert']")
    public WebElement updateMessage;

    public void navigateUserProfileMenu(String tabName){
        WebElement tabElement = Driver.get().findElement(By.xpath("//li/button[text()='"+tabName+"']"));
        tabElement.click();
    }

    public String updateMessageGetText(){
        return updateMessage.getText();
    }

    public String addedEducationName(String schoolName) {
        return Driver.get().findElement(By.xpath("//span[text()='" + schoolName + "']")).getText();
    }

    public void deleteEducation(String addedEducation) {
        WebElement deleteEducationBtn = Driver.get()
                .findElement(By.xpath("//span[text()='"+addedEducation+"']/ancestor::tr//a"));

        BrowserUtils.waitForClickablility(deleteEducationBtn, 7);
        BrowserUtils.clickWithJS(deleteEducationBtn);
        Alert alert = Driver.get().switchTo().alert();
        BrowserUtils.waitFor(2);
        alert.accept();
    }

    public String addedExperienceName(String jobTitleName) {
        return Driver.get().findElement(By.xpath("//span[text()='" + jobTitleName + "']")).getText();
    }

    public void deleteExperience(String jobTitleName) {
              WebElement deleteEducationBtn = Driver.get()
                .findElement(By.xpath("//span[text()='"+jobTitleName+"']/ancestor::tr//a"));

        BrowserUtils.waitForClickablility(deleteEducationBtn, 7);
        BrowserUtils.clickWithJS(deleteEducationBtn);
        Alert alert = Driver.get().switchTo().alert();
        BrowserUtils.waitFor(2);
        alert.accept();
    }

}
