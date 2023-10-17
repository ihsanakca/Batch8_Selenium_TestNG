package com.eurotech.pages;


import com.eurotech.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class AddEducationPage extends BasePage {

    @FindBy(xpath = "//div/button[text()='Add Education']")
    public WebElement addEducationBtn;

    @FindBy(id = "school")
    public WebElement schoolOrBootcampBox;

    public void addEducationMtd(String school, String degreeOrCertificate, String study, String fromDate, String toDate, String programDescription) {
        Actions actions = new Actions(Driver.get());

        actions.click(schoolOrBootcampBox)
                .sendKeys(school+ Keys.TAB)
                .sendKeys(degreeOrCertificate+Keys.TAB)
                .sendKeys(study+Keys.TAB)
                .sendKeys(fromDate+Keys.TAB+Keys.TAB)
                .sendKeys(toDate+Keys.TAB)
                .sendKeys(programDescription+Keys.TAB+Keys.ENTER).perform();
    }
}
