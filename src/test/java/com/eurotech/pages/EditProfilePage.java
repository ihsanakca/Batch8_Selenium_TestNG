package com.eurotech.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class EditProfilePage extends BasePage{

    @FindBy(css = "#about")
    public WebElement aboutInputBox;
    @FindBy(xpath = "(//input[@id='company'])[1]")
    public WebElement companyInputBox;
    @FindBy(xpath = "//select[@id='job']")
    public WebElement jobInputBox;
    @FindBy(css = "#website")
    public WebElement websiteInputBox;
    @FindBy(xpath = "(//input[@id='location'])[1]")
    public WebElement locationInputBox;
    @FindBy(css = "#skills")
    public WebElement skillsInputBox;
    @FindBy(xpath = "//*[.='Save Changes']")
    public WebElement saveChangeBtn;

    public void selectJob(String jobOption){
        Select select=new Select(jobInputBox);
        select.selectByVisibleText(jobOption);
    }
}
