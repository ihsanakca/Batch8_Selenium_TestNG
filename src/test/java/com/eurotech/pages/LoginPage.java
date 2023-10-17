package com.eurotech.pages;

import com.eurotech.utilities.ConfigurationReader;
import com.eurotech.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LoginPage extends BasePage{

    public LoginPage(){
        super();
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(id = "email")
    public WebElement emailBox;

    //WebElement emailBox=driver.findElement(By.id("email"));  --->FindBy annotaion'ı bu işlemi yapar.
    // Seleniumdan gelir. Page Object Model ile ilgili bütün herşey selenium kaynaklıdır.

    @FindBy(id = "yourPassword")
    public WebElement passwordBox;

    @FindBy(xpath = "//button[text()='Login']")
    public WebElement loginBtn;

    @FindBy(xpath = "//div[contains(text(),'Password is incorrect.')]")
    public WebElement wrongPasswordWarningMessage;

    @FindBy(xpath = "//div[contains(text(),'Email address is incorrect.')]")
    public WebElement wrongEmailWarningMessage;

    @FindBy(css = "input.form-control,button")
    public List<WebElement> inputs;

    //AND gibi çalışır iki @FindBy'ın ikisinin de doğru olması gerekir.
    @FindBys({
            @FindBy(css = "#email"),
            @FindBy(xpath = "//input[@name='email']")
    })
    public WebElement emailBoxWithFindBys;

    //OR gibi çalışır iki @FindBy'dan biri doğru ise eğer, yeterlidir.
    @FindAll({
            @FindBy(css = "#yourPassword"),
            @FindBy(css = "[name='ihsan']")
    })
    public WebElement passwordBoxWithFindAll;


    public void login(String userEmail,String password){
        emailBox.sendKeys(userEmail);
        passwordBox.sendKeys(password);
        loginBtn.click();
    }

    public void login(){
        emailBox.sendKeys(ConfigurationReader.get("userEmail"));
        passwordBox.sendKeys(ConfigurationReader.get("password"));
        loginBtn.click();
    }

}
