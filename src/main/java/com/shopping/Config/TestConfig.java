package com.shopping.Config;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestConfig 
{
	String driverPath = "../sampleHackProj/src/main/java/externalDrivers/chromedriver.exe";
	public static WebDriver driver;


	@BeforeMethod
	public void startBrowser() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://automationpractice.com/index.php");
	}

	@AfterMethod
	public void endTest() {
		driver.quit();
	}
}
