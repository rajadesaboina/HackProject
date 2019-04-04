package com.shopping.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class RegistrationModule {

	WebDriver driver;
	
	@FindBy(xpath="//a[@title='Log in to your customer account']")
	private WebElement signInLable;
	@FindBy(xpath="//h3[contains(text(),'Create an account')]")
	private WebElement createAnAccountLable;
	@FindBy(xpath="//input[@id='email_create']")
	private WebElement registerEmailId;
	@FindBy(xpath="//button[@id='SubmitCreate']")
	private WebElement createAnAccount;
	@FindBy(xpath="//h1[contains(text(),'Create an account')]")
	private WebElement createAnAccountHeader;
	@FindBy(xpath="//input[contains(@id,'id_gender1')]")
	private WebElement genderRadioButton;
	@FindBy(xpath="//input[contains(@name,'customer_firstname')]")
	private WebElement firstNameTextField;
	@FindBy(xpath="//input[contains(@name,'customer_lastname')]")
	private WebElement lastNameTextField;
	@FindBy(xpath="//input[contains(@name,'passwd')]")
	private WebElement passwordTextField;
	@FindBy(xpath="//input[contains(@name,'address1')]")
	private WebElement addressTextField;
	@FindBy(xpath="//input[contains(@name,'city')]")
	private WebElement cityTextField;
	@FindBy(xpath="//input[contains(@name,'postcode')]")
	private WebElement postalTextField;
	@FindBy(xpath="//input[contains(@name,'phone_mobile')]")
	private WebElement mobilePhoneTextField;
	@FindBy(xpath="//button[@id='submitAccount']")
	private WebElement registerButton;
	@FindBy(xpath="//h1[contains(text(),'My account')]")
	private WebElement myAccount;

	
	public RegistrationModule(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
		
	public void Register()
	{
		//click on Sign in
		signInLable.click();

//		CREATE AN ACCOUNT - Label
		Assert.assertTrue(createAnAccountLable.isDisplayed(), "Assert Home Page");
		System.out.println("Verified CREATE AN ACCOUNT - Label");

//		Enter Valid UserName
		registerEmailId.click();
		registerEmailId.sendKeys("Pal.Khokan@Hawn.com");
		System.out.println("Enter New Email ID");

		// Click on Create an account Button
		createAnAccount.click();
		System.out.println("Click on Create an account Button");

//		Verify The Header Text in Home Page
		Assert.assertTrue(createAnAccountHeader.isDisplayed(), "Assert Register Home Page");
		System.out.println("Assert Register Home Page");
		
//		Click on Mr Radio Button
		genderRadioButton.click();
		System.out.println("Click on Mr Radio Button");
		
//		Enter First name
		firstNameTextField.click();
		firstNameTextField.sendKeys("FirstName");
		System.out.println("Enter First name");
		
//		Enter Last name
		lastNameTextField.click();
		lastNameTextField.sendKeys("LastName");
		System.out.println("Enter Last name");
		
//		Enter Password name
		passwordTextField.click();
		passwordTextField.sendKeys("Qwerty@1");
		System.out.println("Enter Password");
		
//		Enter Address1 name
		addressTextField.click();
		addressTextField.sendKeys("Duggirala");
		System.out.println("Enter Address1");
		
//		Enter City
		cityTextField.click();
		cityTextField.sendKeys("Duggirala");
		System.out.println("Enter City");
		
//		Select City From Drop down
		Select drpCity = new Select(driver.findElement(By.name("id_state")));
		drpCity.selectByVisibleText("Alaska");
		
//		Enter Postal Code
		postalTextField.click();
		postalTextField.sendKeys("00000");
		System.out.println("Enter postalTextField");
		
//		Select Country From Drop down
		Select drpCountry = new Select(driver.findElement(By.name("id_country")));
		drpCountry.selectByVisibleText("United States");
		
		
//		Enter Mobile phone
		mobilePhoneTextField.click();
		mobilePhoneTextField.sendKeys("1234567890");
		System.out.println("Enter Mobile phone Field");
		
//		Click on Register Button
		registerButton.click();
		System.out.println("Click on Register Button");
		
//		Verify The MyAccount Home Page
		Assert.assertTrue(myAccount.isDisplayed(), "Assert Home Page");
	}
}
