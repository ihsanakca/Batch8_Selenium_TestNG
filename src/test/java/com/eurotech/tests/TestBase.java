package com.eurotech.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.eurotech.utilities.BrowserUtils;
import com.eurotech.utilities.ConfigurationReader;
import com.eurotech.utilities.Driver;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestBase {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;
    static protected ExtentReports report;
    protected ExtentHtmlReporter htmlReporter;
    protected ExtentTest extentLogger;

    @BeforeTest
    public void setUpTest(){

        report=new ExtentReports();

        String projectPath=System.getProperty("user.dir");
        String reportPath=projectPath+"/test-output/report.html";
        //String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        //String reportPath=projectPath + "/test-output/report"+date+".html";

        htmlReporter=new ExtentHtmlReporter(reportPath);

        report.attachReporter(htmlReporter);

        htmlReporter.config().setReportName("Smoke Testi");

        report.setSystemInfo("Enviroment","UAT");
        report.setSystemInfo("Browser", ConfigurationReader.get("browser"));
        report.setSystemInfo("OS",System.getProperty("os.name"));
        report.setSystemInfo("Test Specialist","UmutIhsan");
        report.setSystemInfo("PO","Bilal Sağlam");

    }

    @AfterTest
    public void tearDownTest(){
        report.flush();
    }

    @BeforeMethod
    public void setUp() {
        driver = Driver.get();
        driver.manage().window().setPosition(new Point(-1000, 0));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfigurationReader.get("url"));
        wait=new WebDriverWait(driver,10);
        actions=new Actions(driver);
    }

    @AfterMethod
    public void tearDown(ITestResult result) throws IOException {
            //if the test fails-- eğer test başarısız olursa
        if (result.getStatus()==ITestResult.FAILURE){
            //record the name of the failed test-başarısız testin adını alalım
            extentLogger.fail(result.getName());
            //Take the screenshot and return the location of screenshot
            //ekran görüntüsü (screen shot) alalım ve ekran görüntüsünün kayıt edileceği yolu alalım
            String screenShotPath = BrowserUtils.getScreenshot(result.getName());
            //add the screenshot to the report-ekran görüntüsünü rapora ekleyelim
            extentLogger.addScreenCaptureFromPath(screenShotPath);
            //capture the exception and put inside the report-//hata logunu (exception logs) raporun içine koyalım
            extentLogger.fail(result.getThrowable());
        }
        Driver.closeDriver();
    }
}
