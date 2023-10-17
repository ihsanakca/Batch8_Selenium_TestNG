package com.eurotech.pages;


import com.eurotech.utilities.BrowserUtils;
import com.eurotech.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public abstract class BasePage {
    public BasePage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(css = ".d-none.d-md-block.dropdown-toggle.ps-2")
    public WebElement userNameAtTheTabMenu;

    @FindBy(xpath = "//li[contains(@class,'nav-item dropdown')]")
    public List<WebElement> tabMenus;

  //  public abstract void verifyPageTitle();

    public void navigateToTabs(String tabName){
        String tabsXpath = "//span[.='" + tabName + "']";
        Driver.get().findElement(By.xpath(tabsXpath)).click();
    }

    public void  navigateToTabsAndModules(String tabName,String moduleName){

        String tabsXpath="//span[text()='"+tabName+"']";
        WebElement tab = Driver.get().findElement(By.xpath(tabsXpath));
        tab.click();

        if (!moduleName.isEmpty()){
            String moduleXpath = "//span[text()='" + moduleName + "']";
            WebElement module = Driver.get().findElement(By.xpath(moduleXpath));
            BrowserUtils.clickWithJS(module);
        }

    }
}
