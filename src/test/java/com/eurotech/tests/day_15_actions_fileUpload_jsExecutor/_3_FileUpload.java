package com.eurotech.tests.day_15_actions_fileUpload_jsExecutor;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class _3_FileUpload {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().setPosition(new Point(-1000, 0));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void fileUpload() throws InterruptedException {
        /**
         * go to https://demoqa.com/upload-download
         * upload ccc.txt (which is on your desktop)
         * verify that the file is uploaded
         */

        driver.get("https://demoqa.com/upload-download");
        WebElement uploadFile = driver.findElement(By.id("uploadFile"));
        Thread.sleep(2000);
        uploadFile.sendKeys("C:\\Users\\ihsan\\OneDrive\\Masaüstü\\ccc.txt");


        String filePathText = driver.findElement(By.id("uploadedFilePath")).getText();
        String fileName="ccc.txt";

        Assert.assertTrue(filePathText.contains(fileName));

    }

    @Test
    public void systemPropertiesTest() {
        Properties properties = System.getProperties();
        //bütün sistem özellikleri
        properties.list(System.out);

        //key--->value ile çalışır...

        System.out.println("System.getProperty(\"os.name\") = " + System.getProperty("os.name"));
        System.out.println("System.getProperty(\"user.name\") = " + System.getProperty("user.name"));
        System.out.println("System.getProperty(\"user.dir\") = " + System.getProperty("user.dir"));

    }

    @Test
    public void test1(){
        System.out.println("System.getenv(\"Password\") = " + System.getenv("Password"));
    }

    @Test
    public void fileUpload2() throws InterruptedException {
        /**
         * proje kapsamında dosya yükleme işlemi
         * test klasörü altında resources directory'si oluşturulur (projeye dışarıdan eklenecek dosyalar burada olur.)
         * upload edilecek dosya bu klasöre kopyalanır (ccc.txt)
         * System.getProperty() metodu kullanılarak.. projenin yolu (path) alınır..
         * upload edilecek dosyaya sağ click yapılarak, projeden sonraki yolu (path) alınır..
         * iki path araya "/"  slash konularak birleştirilir. Artık projeyi her indirenin kullanabileceği path oluşur..
         * bu path kullanılarak dosya upload edilir.
         */
        driver.get("https://demoqa.com/upload-download");
        WebElement uploadFile = driver.findElement(By.id("uploadFile"));

        String projectPath=System.getProperty("user.dir");
        String filePath="src/test/resources/ccc.txt";
        String fullPath=projectPath+"/"+filePath;

        uploadFile.sendKeys(fullPath);

        String filePathText = driver.findElement(By.id("uploadedFilePath")).getText();
        String fileName="ccc.txt";

        Assert.assertTrue(filePathText.contains(fileName));

    }

    @Test
    public void fileUpload_Task() {
        /**
         * resources klasöründe fileUploadDemo.txt dosyası oluştur.
         * https://the-internet.herokuapp.com/upload sitesine git
         * sitedeki dosya yükleme kısmına bu dosyayı yükle (dynamic path ile)
         * Upload butonuna bas
         * çıkan sayfadan yüklenen dosyanın ismini doğrula
         */


        driver.get("https://the-internet.herokuapp.com/upload");
        WebElement chooseFile= driver.findElement(By.cssSelector("#file-upload"));

        String projectPath=System.getProperty("user.dir");
        String filePath="src/test/resources/fileUploadDemo.txt";
        String fullPath=projectPath+"/"+filePath;
        System.out.println("fullPath = " + fullPath);

        chooseFile.sendKeys(fullPath);
        driver.findElement(By.id("file-submit")).click();

        String actualText=driver.findElement(By.id("uploaded-files")).getText();

        Assert.assertEquals(actualText, "fileUploadDemo.txt");


    }

    @Test
    public void fileDownload() throws InterruptedException {
        /**
         * navigate to https://demoqa.com/upload-download
         * click on download button
         * verify that the sampleFile.jpeg file is downloaded to the Downloads directory
         *
         * Note: Bir dosyanın bilgisayarınızda verilen path'in gösterdiği yerde olup olmadığını
         * Java'dan gelen Files classının exists metodu ile kontrol edebiliriz. Bu metod bir boolean değer döner.
         */
        driver.get("https://demoqa.com/upload-download");
        WebElement downloadLink=driver.findElement(By.linkText("Download"));
        downloadLink.click();

        Thread.sleep(7000);

        //verification
        String filePath=System.getProperty("user.home")+"/Downloads/sampleFile.jpeg";
        Assert.assertTrue(Files.exists(Paths.get(filePath)));

    }
}
