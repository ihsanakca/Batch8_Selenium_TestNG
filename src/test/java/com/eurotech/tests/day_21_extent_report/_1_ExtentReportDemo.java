package com.eurotech.tests.day_21_extent_report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.eurotech.utilities.ConfigurationReader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class _1_ExtentReportDemo {

    //This class is used for starting and building reports
    //Bu class rapor oluşturmak ve rapor ile ilgili metadata'yı tanımlamak için kullanılır. (Rapora özel)
    ExtentReports report;

    //This class is used to create html report file
    //Bu class raporumuzun html formatında olmasını sağlar..
    ExtentHtmlReporter htmlReporter;

    //this will define a test, enable adding logs and test steps
    //Her test ile ilgili log kayıtlarını ve test adımlarını tutmamızı sağlar. (Teste özel)
    ExtentTest extentLogger;


    @BeforeMethod
    public void setUp() {
        //initialize class
        report=new ExtentReports();

        //create a report path--raporun kayıt edileceği yerin yolunu belirleyelim
        String projectPath=System.getProperty("user.dir");
        String reportPath=projectPath+"/test-output/report.html";

        // initialize the html report with the report path
        //HTML raporumuzu path ile oluşturalım
        htmlReporter=new ExtentHtmlReporter(reportPath);

        //attach the html report to the report object
        //HTML raporumuzu report nesnesiyle ilişkilendirelim
        report.attachReporter(htmlReporter);

        //title in report
        //raporun başlığını düzenleyelim
        htmlReporter.config().setReportName("Smoke Testi");

        // set environment information
        //raporun metadatasını (genel bilgilerini-ortam) düzenleyelim
        report.setSystemInfo("Enviroment","UAT");
        report.setSystemInfo("Browser", ConfigurationReader.get("browser"));
        report.setSystemInfo("OS",System.getProperty("os.name"));
        report.setSystemInfo("Test Specialist","UmutIhsan");
        report.setSystemInfo("PO","Bilal Sağlam");

    }

    @Test
    public void test1() {
        //specific test case name
        //mevcut testimizin ismini girelim
        extentLogger=report.createTest("TC001_DemoTest");

        //test steps
        //test adımlarımızı girelim
        extentLogger.info("Chrome browserı aç");
        //code here
        extentLogger.info("Web sitesine git "+ConfigurationReader.get("url"));
        //code here
        extentLogger.info("Emaili gir");
        //code here
        extentLogger.info("Şifreyi gir");
        //code here
        extentLogger.info("Logine bas");
        //code here
        extentLogger.info("Siteye girildiğini kullanıcı adı "+ConfigurationReader.get("userName")+" ile doğrula");
        //code here

        //if this code executes, the test will be admitted as "passed".
        //eğer test buraya kadar gelmişse o testi geçti diye belirleyelim.
        extentLogger.pass("PASSED");


    }

    @AfterMethod
    public void tearDown() {
        //where the report is actually generated.
        //raporun gerçek anlamda oluşturulduğu yer.
        report.flush();
    }
}
