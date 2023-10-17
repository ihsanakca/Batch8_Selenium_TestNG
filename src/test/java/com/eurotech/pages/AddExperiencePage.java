package com.eurotech.pages;

import com.eurotech.utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class AddExperiencePage extends BasePage {

    Faker faker = new Faker();
    @FindBy(xpath = "//div/button[text()='Add Experience']")
    public WebElement addExperienceBtn;

    @FindBy(css = "input#job")
    public WebElement jobTitle;

    public String jobTitleName = faker.job().title();
    String companyName=faker.company().name();
    String locationName=faker.address().cityName();
    String fromDate="11112020";
    String toDate="10102022";
    String jobDescription= faker.lorem().characters(25,false,false);

    public void addExperienceMtd() {
        Actions actions = new Actions(Driver.get());

        actions.click(jobTitle)
                .sendKeys(jobTitleName+ Keys.TAB)
                .sendKeys(companyName + Keys.TAB)
                .sendKeys(locationName + Keys.TAB)
                .sendKeys(fromDate + Keys.TAB + Keys.TAB)
                .sendKeys(toDate + Keys.TAB)
                .sendKeys(jobDescription + Keys.TAB +Keys.ENTER).perform();
    }
}
