package sampleHackProj;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class testConfig 
{
	String driverPath = "../sampleHackProj/src/main/java/externalDrivers/chromedriver.exe";
    public WebDriver driver;

    
	@BeforeClass
    public void startBrowser() {
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//        driver.get("http://ec2-54-86-140-242.compute-1.amazonaws.com:8080/maven-web-application/");
        driver.get("http://52.54.87.241:8080/SampleWebApplication/");
        
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Hello')]")));
    }

    @Test
    public void navigateToUrl() {
//        driver.get("https://www.google.com/");
//    	driver.get("http://ec2-54-86-140-242.compute-1.amazonaws.com:8080/myweb-0.0.5/");
    	System.out.println("Page loaded.. !!");
    }

    @AfterClass
    public void endTest() {
        driver.quit();
    }
}
