package com.shopping.PageObjects;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.shopping.Utils.ReportsAndScreenshots;

public class LoginModule 
{

	WebDriver driver;

	@FindBy(xpath="//a[@title='Log in to your customer account']")
	private WebElement signInLable;
	@FindBy(xpath="//h3[contains(text(),'Already registered')]")
	private WebElement alreadyRegistered;
	@FindBy(xpath="//h3[contains(text(),'Already registered?')]/following-sibling::div//label[contains(text(),'Email address')]/following-sibling::input")
	private WebElement email;
	@FindBy(xpath="//input[@id='passwd']")
	private WebElement password;
	@FindBy(xpath="//button[@id='SubmitLogin']")
	private WebElement loginButton;
	@FindBy(xpath="//h1[contains(text(),'My account')]")
	private WebElement myAccount;
	@FindBy(xpath="//h3[contains(text(),'Create an account')]")
	private WebElement createAnAccount;
	@FindBy(xpath="//input[@id='email_create']")
	private WebElement createAccountEmail;
	

	public LoginModule(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
		
	public void signIn()
	{
		//click on Sign in
		signInLable.click();
		ReportsAndScreenshots.captureScreenShot(driver);

		assertTrue(alreadyRegistered.isDisplayed());
		ReportsAndScreenshots.captureScreenShot(driver);


		//Login
		email.click();
		email.sendKeys("raja.desaboina@gmail.com");
		ReportsAndScreenshots.captureScreenShot(driver);

		password.click();
		password.sendKeys("Qerty@1");
		ReportsAndScreenshots.captureScreenShot(driver);

		loginButton.click();
		ReportsAndScreenshots.captureScreenShot(driver);

		//String myaccount = myaccount.getText();
		Assert.assertTrue(myAccount.isDisplayed(), "Assert Home Page");
		ReportsAndScreenshots.captureScreenShot(driver);

	}

	public void signout()
	{

	}

}
