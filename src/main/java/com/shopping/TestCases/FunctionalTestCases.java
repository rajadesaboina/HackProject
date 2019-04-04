package com.shopping.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.shopping.Config.TestConfig;
import com.shopping.PageObjects.AddToCart;
import com.shopping.PageObjects.LoginModule;
import com.shopping.PageObjects.RegistrationModule;
import com.shopping.Utils.ReportsAndScreenshots;

public class FunctionalTestCases extends TestConfig
{

	@Test
	public static void s_VerifyFieldsPresentOnSignInPage_101()
	{

		//Click on sign in button
		driver.findElement(By.xpath("//a[@title='Log in to your customer account']")).click();
		ReportsAndScreenshots.captureScreenShot(driver);

		//      1. CREATE AN ACCOUNT - Label
		String createAnAccount=driver.findElement(By.xpath("//h3[contains(text(),'Create an account')]")).getText();
		Assert.assertEquals(createAnAccount, "CREATE AN ACCOUNT");
		ReportsAndScreenshots.captureScreenShot(driver);
		System.out.println("Verified CREATE AN ACCOUNT - Label");

		//		2. Create Account Email Address - Text box
		Assert.assertTrue(driver.findElement(By.xpath("//input[@id='email_create']")).isDisplayed(), "verify the email");
		System.out.println("Verified Create Account Email Address - Textbox");

		//		3. ALREADY REGISTERED ? - Label
		String alreadyExists=driver.findElement(By.xpath("//h3[contains(text(),'Already registered')]")).getText();
		Assert.assertEquals(alreadyExists, "ALREADY REGISTERED?");
		ReportsAndScreenshots.captureScreenShot(driver);
		System.out.println("Verified ALREADY REGISTERED ? - Label");

		//		4. Email Address - Text box
		Assert.assertTrue(driver.findElement(By.xpath("//h3[contains(text(),'Already registered?')]/following-sibling::div//label[contains(text(),'Email address')]/following-sibling::input")).isDisplayed(), "verify the email");
		ReportsAndScreenshots.captureScreenShot(driver);
		System.out.println("Verified Email Address - Textbox");

		//		5. Password - Text box
		Assert.assertTrue(driver.findElement(By.xpath("//input[@id='passwd']")).isDisplayed(), "verify the password");
		ReportsAndScreenshots.captureScreenShot(driver);
		System.out.println("Verified Password - Textbox");

		//		6. Sign In - Button
		Assert.assertTrue(driver.findElement(By.xpath("//button[@id='SubmitLogin']")).isDisplayed(), "verify the submit button");
		ReportsAndScreenshots.captureScreenShot(driver);
		System.out.println("Verified Sign In - Button");

		//		Verified All The Fields 
		System.out.println("All The Fields Verified");

	}
	@Test
	public static void s_VerifyUserIsAbleToLoginSuccessfully_105()
	{
		LoginModule object=new LoginModule(driver);

		//		Verify That Sign In Button is Present In Home Page
		boolean status=driver.findElement(By.xpath("//a[@title='Log in to your customer account']")).isDisplayed();
		Assert.assertTrue(status);

		//		Sign In Common Method
		object.signIn();

		//		User should be sign in successfully and navigated to My Accounts page.
		System.out.println("User should be sign in successfully and navigated to My Accounts page.");
	}
	@Test
	public static void s_VerifyErrorMessageForInvalidEmailId_102()
	{

		//Click on sign in button
		driver.findElement(By.xpath("//a[@title='Log in to your customer account']")).click();
		ReportsAndScreenshots.captureScreenShot(driver);

		//		3. Email Address - Text box
		driver.findElement(By.xpath("//h3[contains(text(),'Already registered?')]/following-sibling::div//label[contains(text(),'Email address')]/following-sibling::input")).click();
		driver.findElement(By.xpath("//h3[contains(text(),'Already registered?')]/following-sibling::div//label[contains(text(),'Email address')]/following-sibling::input")).sendKeys("asdfg");
		ReportsAndScreenshots.captureScreenShot(driver);

		//		Click on Sign In Button
		driver.findElement(By.xpath("//button[@id='SubmitLogin']")).click();
		ReportsAndScreenshots.captureScreenShot(driver);

		//		Verify Following error message should be displayed:	There is 1 error -- Invalid email address.
		boolean errorMessageForEmail=driver.findElement(By.xpath("//div[contains(@class,'alert alert-danger')]//p[contains(text(),'There is 1 error')]")).isDisplayed();
		Assert.assertTrue(errorMessageForEmail);
		ReportsAndScreenshots.captureScreenShot(driver);

		//		Verify Following error message should be displayed:	There is 1 error -- Invalid email address.
		boolean errorMessageForEmail1=driver.findElement(By.xpath("//div[contains(@class,'alert alert-danger')]//li[contains(text(),'Invalid email address.')]")).isDisplayed();
		Assert.assertTrue(errorMessageForEmail1);
		ReportsAndScreenshots.captureScreenShot(driver);

		//		Verify Error Message  -- Following error message should be displayed:	There is 1 error -- Invalid email address.
		System.out.println("Following error message should be displayed:	There is 1 error -- Invalid email address.");
	}
	@Test
	public static void s_VerifyErrorMessageForNoEmailId_103()
	{

		//Click on sign in button
		driver.findElement(By.xpath("//a[@title='Log in to your customer account']")).click();
		ReportsAndScreenshots.captureScreenShot(driver);

		//		3. Clear The Email Address - Text box
		driver.findElement(By.xpath("//h3[contains(text(),'Already registered?')]/following-sibling::div//label[contains(text(),'Email address')]/following-sibling::input")).click();
		driver.findElement(By.xpath("//h3[contains(text(),'Already registered?')]/following-sibling::div//label[contains(text(),'Email address')]/following-sibling::input")).clear();
		ReportsAndScreenshots.captureScreenShot(driver);

		//		Click on Sign In Button
		driver.findElement(By.xpath("//button[@id='SubmitLogin']")).click();
		ReportsAndScreenshots.captureScreenShot(driver);

		//		Verify Following error message should be displayed:	There is 1 error -- Invalid email address.
		boolean errorMessageForEmail=driver.findElement(By.xpath("//div[contains(@class,'alert alert-danger')]//p[contains(text(),'There is 1 error')]")).isDisplayed();
		Assert.assertTrue(errorMessageForEmail);
		ReportsAndScreenshots.captureScreenShot(driver);

		//		Verify Following error message should be displayed:	There is 1 error -- Invalid email address.
		boolean errorMessageForEmail1=driver.findElement(By.xpath("//div[contains(@class,'alert alert-danger')]//li[contains(text(),'An email address required.')]")).isDisplayed();
		Assert.assertTrue(errorMessageForEmail1);
		ReportsAndScreenshots.captureScreenShot(driver);

		//		Verify Error Message  -- Following error message should be displayed:	There is 1 error -- Invalid email address.
		System.out.println("Following error message should be displayed: There is 1 error --- An email address required.");
	}	

	@Test
	public static void s_VerifyErrorMessageForNoPassword_104()
	{

		//Click on sign in button
		driver.findElement(By.xpath("//a[@title='Log in to your customer account']")).click();
		ReportsAndScreenshots.captureScreenShot(driver);

		//		3. Email Address - Text box
		driver.findElement(By.xpath("//h3[contains(text(),'Already registered?')]/following-sibling::div//label[contains(text(),'Email address')]/following-sibling::input")).click();
		driver.findElement(By.xpath("//h3[contains(text(),'Already registered?')]/following-sibling::div//label[contains(text(),'Email address')]/following-sibling::input")).sendKeys("raja.desaboina@gmail.com");
		ReportsAndScreenshots.captureScreenShot(driver);

		//		4. Clear The Password  - Text box
		driver.findElement(By.xpath("//input[@id='passwd']")).click();
		driver.findElement(By.xpath("//input[@id='passwd']")).clear();
		ReportsAndScreenshots.captureScreenShot(driver);

		//		Click on Sign In Button
		driver.findElement(By.xpath("//button[@id='SubmitLogin']")).click();
		ReportsAndScreenshots.captureScreenShot(driver);

		//		Verify Following error message should be displayed:	There is 1 error -- Invalid email address.
		boolean errorMessageForEmail=driver.findElement(By.xpath("//div[contains(@class,'alert alert-danger')]//p[contains(text(),'There is 1 error')]")).isDisplayed();
		Assert.assertTrue(errorMessageForEmail);
		ReportsAndScreenshots.captureScreenShot(driver);

		//		Verify Following error message should be displayed:	There is 1 error -- Invalid email address.
		boolean errorMessageForPassword=driver.findElement(By.xpath("//div[contains(@class,'alert alert-danger')]//li[contains(text(),'Password is required.')]")).isDisplayed();
		Assert.assertTrue(errorMessageForPassword);
		ReportsAndScreenshots.captureScreenShot(driver);

		//		Verify Error Message  -- Following error message should be displayed:	There is 1 error -- Invalid email address.
		System.out.println("Following error message should be displayed: -- There is 1 error -- Password is required.");
	}
	@Test
	public static void s_VerifyErrorMessageWhenMandatoryFieldsAreEmpty_Register_101()
	{

		//		Click on sign in button
		driver.findElement(By.xpath("//a[@title='Log in to your customer account']")).click();
		ReportsAndScreenshots.captureScreenShot(driver);

		//      CREATE AN ACCOUNT - Label
		String createAnAccount=driver.findElement(By.xpath("//h3[contains(text(),'Create an account')]")).getText();
		Assert.assertEquals(createAnAccount, "CREATE AN ACCOUNT");
		ReportsAndScreenshots.captureScreenShot(driver);
		System.out.println("Verified CREATE AN ACCOUNT - Label");

		//		3. Enter valid Email address in the "Create An Account" section.
		driver.findElement(By.xpath("//input[@id='email_create']")).click();
		driver.findElement(By.xpath("//input[@id='email_create']")).sendKeys("Anusha.Jakka@Harman.com");
		ReportsAndScreenshots.captureScreenShot(driver);

		//		Click on Create an account Button
		driver.findElement(By.xpath("//button[@id='SubmitCreate']")).click();
		ReportsAndScreenshots.captureScreenShot(driver);

		//		4. Verify That Create an account header is Present In Registration Page
		boolean status=driver.findElement(By.xpath("//h1[contains(text(),'Create an account')]")).isDisplayed();
		Assert.assertTrue(status);
		ReportsAndScreenshots.captureScreenShot(driver);

		//		5. Click on Register Button
		driver.findElement(By.xpath("//button[@id='submitAccount']")).click();
		ReportsAndScreenshots.captureScreenShot(driver);

		//		Verify Following error message should be displayed:	There is 8 error -- Register Page.
		boolean errorMessageForRegisterPage=driver.findElement(By.xpath("//div[contains(@class,'alert alert-danger')]//p[contains(text(),'There are 8 errors')]")).isDisplayed();
		Assert.assertTrue(errorMessageForRegisterPage);
		ReportsAndScreenshots.captureScreenShot(driver);
		System.out.println("There are 8 errors");

		//		Verify Following error message should be displayed:	There is 8 error -- You must register at least one phone number..
		boolean errorMessageForPhoneNumber=driver.findElement(By.xpath("//div[contains(@class,'alert alert-danger')]//li[contains(text(),'You must register at least one phone number.')]")).isDisplayed();
		Assert.assertTrue(errorMessageForPhoneNumber);
		ReportsAndScreenshots.captureScreenShot(driver);
		System.out.println("You must register at least one phone number.");

		//		Verify Following error message should be displayed:	There is 8 error -- lastname is required.
		boolean errorMessageForLastName=driver.findElement(By.xpath("//div[contains(@class,'alert alert-danger')]//b[contains(text(),'lastname')]")).isDisplayed();
		Assert.assertTrue(errorMessageForLastName);
		ReportsAndScreenshots.captureScreenShot(driver);
		System.out.println("lastname is required.");

		//		Verify Following error message should be displayed:	There is 8 error -- firstname is required.
		boolean errorMessageForFirstName=driver.findElement(By.xpath("//div[contains(@class,'alert alert-danger')]//b[contains(text(),'firstname')]")).isDisplayed();
		Assert.assertTrue(errorMessageForFirstName);
		ReportsAndScreenshots.captureScreenShot(driver);
		System.out.println("firstname is required.");

		//		Verify Following error message should be displayed:	There is 8 error -- passwd is required.
		boolean errorMessageForPasswd=driver.findElement(By.xpath("//div[contains(@class,'alert alert-danger')]//b[contains(text(),'passwd')]")).isDisplayed();
		Assert.assertTrue(errorMessageForPasswd);
		ReportsAndScreenshots.captureScreenShot(driver);
		System.out.println("passwd is required.");

		//		Verify Following error message should be displayed:	There is 8 error -- address1 is required.
		boolean errorMessageForAddress1=driver.findElement(By.xpath("//div[contains(@class,'alert alert-danger')]//b[contains(text(),'address1')]")).isDisplayed();
		Assert.assertTrue(errorMessageForAddress1);
		ReportsAndScreenshots.captureScreenShot(driver);
		System.out.println("address1 is required.");

		//		Verify Following error message should be displayed:	There is 8 error -- city is required.
		boolean errorMessageForCity=driver.findElement(By.xpath("//div[contains(@class,'alert alert-danger')]//b[contains(text(),'city')]")).isDisplayed();
		Assert.assertTrue(errorMessageForCity);
		ReportsAndScreenshots.captureScreenShot(driver);
		System.out.println("city is required.");

		//		Verify Following error message should be displayed:	There is 8 error -- The Zip/Postal code you've entered is invalid. It must follow this format: 00000
		boolean errorMessageForPostal=driver.findElement(By.xpath("//div[contains(@class,'alert alert-danger')]//li[contains(text(),'The Zip')]")).isDisplayed();
		Assert.assertTrue(errorMessageForPostal);
		ReportsAndScreenshots.captureScreenShot(driver);
		ReportsAndScreenshots.captureScreenShot(driver);
		System.out.println("The Zip/Postal code you've entered is invalid. It must follow this format: 00000");

		//		Verify Following error message should be displayed:	There is 8 error -- This country requires you to choose a State.
		boolean errorMessageForCountry=driver.findElement(By.xpath("//div[contains(@class,'alert alert-danger')]//li[contains(text(),'This country requires you to choose a State.')]")).isDisplayed();
		Assert.assertTrue(errorMessageForCountry);
		ReportsAndScreenshots.captureScreenShot(driver);
		System.out.println("This country requires you to choose a State.");

		//		Verify Error Message  -- Following error message should be displayed: There are 8 errors
		System.out.println("Following error message should be displayed: There are 8 errors");
	}

	@Test
	public static void s_VerifyErrorWhenRegisteringWithSameEmailAddress_Register_102() {

		// Click on sign in button
		driver.findElement(By.xpath("//a[@title='Log in to your customer account']")).click();
		ReportsAndScreenshots.captureScreenShot(driver);

		// CREATE AN ACCOUNT - Label
		String createAnAccount = driver.findElement(By.xpath("//h3[contains(text(),'Create an account')]")).getText();
		Assert.assertEquals(createAnAccount, "CREATE AN ACCOUNT");
		ReportsAndScreenshots.captureScreenShot(driver);
		System.out.println("Verified CREATE AN ACCOUNT - Label");

		// 3. Enter valid Email address in the "Create An Account" section.
		driver.findElement(By.xpath("//input[@id='email_create']")).click();
		driver.findElement(By.xpath("//input[@id='email_create']")).sendKeys("raja.desaboina@gmail.com");
		ReportsAndScreenshots.captureScreenShot(driver);
		System.out.println("Enter All ready Registered Email Id");

		// Click on Create an account Button
		driver.findElement(By.xpath("//button[@id='SubmitCreate']")).click();
		ReportsAndScreenshots.captureScreenShot(driver);
		System.out.println("Click on Create an account Button");

		//		Verify Following error message should be displayed:	There is 8 error -- This country requires you to choose a State.
		boolean errorMessageForAlreadyRegistered=driver.findElement(By.xpath("//div[contains(@class,'alert alert-danger')]//li[contains(text(),'An account using this email address has already been registered. Please enter a valid password or request a new one.')]")).isDisplayed();
		Assert.assertTrue(errorMessageForAlreadyRegistered);
		ReportsAndScreenshots.captureScreenShot(driver);

		//		Verify Error Message  -- Following error message should be displayed: An account using this email address has already been registered. Please enter a valid password or request a new one.
		System.out.println("Following error message should be displayed: An account using this email address has already been registered. Please enter a valid password or request a new one.");
	}
	@Test
	public static void s_VerifyUserIsAbleToRegisterSuccessfully_Register_103() {

		RegistrationModule object=new RegistrationModule(driver);

		//		Verify That Sign In Button is Present In Home Page
		boolean status=driver.findElement(By.xpath("//a[@title='Log in to your customer account']")).isDisplayed();
		Assert.assertTrue(status);

		//		Sign In Common Method
		object.Register();

		//		Verify User should be sign in successfully and navigated to My Accounts page.
		System.out.println("User should be registered successfully and navigated to My Accounts page.");
	}
	@Test
	public static void s_VerifyErrorMessageWhenCurrentPasswordFieldIsEmpty_My_Personal_Info_101() {

		LoginModule object=new LoginModule(driver);

		//		Verify That Sign In Button is Present In Home Page
		boolean status=driver.findElement(By.xpath("//a[@title='Log in to your customer account']")).isDisplayed();
		Assert.assertTrue(status);

		//		Sign In Common Method
		object.signIn();

		//		User should be sign in successfully and navigated to My Accounts page.
		System.out.println("User should be sign in successfully and navigated to My Accounts page.");

		//		Click on "My Personal Information" link.
		driver.findElement(By.xpath("//a[@title='Information']//span[contains(text(),'My personal information')]")).click();
		ReportsAndScreenshots.captureScreenShot(driver);
		System.out.println("Click on My Personal Information link");

		//		Do not enter "Current Password".
		driver.findElement(By.xpath("//input[@id='old_passwd']")).click();
		driver.findElement(By.xpath("//input[@id='old_passwd']")).clear();
		ReportsAndScreenshots.captureScreenShot(driver);
		System.out.println("Do not enter Current Password");

		//		Click on "Save" button.
		driver.findElement(By.xpath("//button[@name='submitIdentity']")).click();
		ReportsAndScreenshots.captureScreenShot(driver);
		System.out.println("Click on Save button.");

		//		Verify Following error message should be displayed:	There is 8 error -- Register Page.
		boolean errorMessageForRegisterPage=driver.findElement(By.xpath("//div[contains(@class,'alert alert-danger')]//p[contains(text(),'There is 1 error')]")).isDisplayed();
		Assert.assertTrue(errorMessageForRegisterPage);
		ReportsAndScreenshots.captureScreenShot(driver);
		System.out.println("There are 1 errors");

		//		Verify Following error message should be displayed:	There is 1 error -- The password you entered is incorrect.
		boolean errorMessageForPassword=driver.findElement(By.xpath("//div[contains(@class,'alert alert-danger')]//li[contains(text(),'The password you entered is incorrect.')]")).isDisplayed();
		Assert.assertTrue(errorMessageForPassword);
		ReportsAndScreenshots.captureScreenShot(driver);
		System.out.println("You must register at least one phone number.");
	}
	@Test
	public static void s_VerifyUserIsAbleToSuccessfullyEditDOB_My_Personal_Info_102() {

		LoginModule object=new LoginModule(driver);

		//		Verify That Sign In Button is Present In Home Page
		boolean status=driver.findElement(By.xpath("//a[@title='Log in to your customer account']")).isDisplayed();
		Assert.assertTrue(status);
		ReportsAndScreenshots.captureScreenShot(driver);

		//		Sign In Common Method
		object.signIn();

		//		User should be sign in successfully and navigated to My Accounts page.
		System.out.println("User should be sign in successfully and navigated to My Accounts page.");

		//		Click on "My Personal Information" link.
		driver.findElement(By.xpath("//a[@title='Information']//span[contains(text(),'My personal information')]")).click();
		ReportsAndScreenshots.captureScreenShot(driver);
		System.out.println("Click on My Personal Information link");

		//		Select Date From Drop down
		Select drpDate = new Select(driver.findElement(By.xpath("//select[@id='days']")));
		drpDate.selectByValue("4");
		ReportsAndScreenshots.captureScreenShot(driver);
		System.out.println("Select Date From Drop down");

		//		Select Months From Drop down
		Select drpMonths = new Select(driver.findElement(By.xpath("//select[@id='months']")));
		drpMonths.selectByValue("3");
		ReportsAndScreenshots.captureScreenShot(driver);
		System.out.println("Select Months From Drop down");

		//		Select Years From Drop down
		Select drpyears = new Select(driver.findElement(By.xpath("//select[@id='years']")));
		drpyears.selectByValue("1991");
		ReportsAndScreenshots.captureScreenShot(driver);
		System.out.println("Select Years From Drop down");

		//		Do not enter "Current Password".
		driver.findElement(By.xpath("//input[@id='old_passwd']")).click();
		driver.findElement(By.xpath("//input[@id='old_passwd']")).sendKeys("Qwerty@2");
		ReportsAndScreenshots.captureScreenShot(driver);
		System.out.println("Do not enter Current Password");

		//		Click on "Save" button.
		driver.findElement(By.xpath("//button[@name='submitIdentity']")).click();
		ReportsAndScreenshots.captureScreenShot(driver);
		System.out.println("Click on Save button.");

		//		Verify Following error message should be displayed:	There is 8 error -- Register Page.
		boolean errorMessageForRegisterPage=driver.findElement(By.xpath("//div[contains(@class,'alert alert-danger')]//p[contains(text(),'There is 1 error')]")).isDisplayed();
		Assert.assertTrue(errorMessageForRegisterPage);
		ReportsAndScreenshots.captureScreenShot(driver);
		System.out.println("There are 1 errors");

		//		Verify Following error message should be displayed:	There is 1 error -- The password you entered is incorrect.
		boolean errorMessageForPassword=driver.findElement(By.xpath("//div[contains(@class,'alert alert-danger')]//li[contains(text(),'The password you entered is incorrect.')]")).isDisplayed();
		Assert.assertTrue(errorMessageForPassword);
		ReportsAndScreenshots.captureScreenShot(driver);
		System.out.println("You must register at least one phone number.");
	}
	@Test
	public static void s_VerifyUserIsAbleToPlaceOrderSuccessfully_E2E_101(){

		LoginModule object = new LoginModule(driver);
		AddToCart object1 = new AddToCart(driver);

		//		Verify That Sign In Button is Present In Home Page
		boolean status=driver.findElement(By.xpath("//a[@title='Log in to your customer account']")).isDisplayed();
		Assert.assertTrue(status);
		ReportsAndScreenshots.captureScreenShot(driver);

		//		Sign In Common Method
		object.signIn();

		//		User should be sign in successfully and navigated to My Accounts page.
		System.out.println("User should be sign in successfully and navigated to My Accounts page.");

		//		Added Item to Cart and Payment
		object1.ProductAddToCart();
	}
	@Test
	public static void s_VerifyItemsAddedInCartIsDisplayedOnShoppingCartSummaryPage_CartSummary_101(){

		LoginModule object = new LoginModule(driver);
		AddToCart object1 = new AddToCart(driver);

		//		Verify That Sign In Button is Present In Home Page
		boolean status=driver.findElement(By.xpath("//a[@title='Log in to your customer account']")).isDisplayed();
		Assert.assertTrue(status);
		ReportsAndScreenshots.captureScreenShot(driver);

		//		Sign In Common Method
		object.signIn();

		//		User should be sign in successfully and navigated to My Accounts page.
		System.out.println("User should be sign in successfully and navigated to My Accounts page.");

		//		Added Item to Cart and Payment
		object1.ItemsAddedToCart();

		//		1st Items added in the cart should be displayed in the Shopping Cart Summary Page.
		boolean verifyItem1=driver.findElement(By.xpath("//div[@id='order-detail-content']//a[contains(text(),'Faded Short Sleeve T-shirts')]")).isDisplayed();
		Assert.assertTrue(verifyItem1);
		ReportsAndScreenshots.captureScreenShot(driver);
		System.out.println("1st Items added in the cart should be displayed in the Shopping Cart Summary Page.");	

		//		2nd Items added in the cart should be displayed in the Shopping Cart Summary Page.
		boolean verifyItem2=driver.findElement(By.xpath("//div[@id='order-detail-content']//a[contains(text(),'Blouse')]")).isDisplayed();
		Assert.assertTrue(verifyItem2);
		ReportsAndScreenshots.captureScreenShot(driver);
		System.out.println("2nd Items added in the cart should be displayed in the Shopping Cart Summary Page.");
	}	
	@Test
	public static void s_VerifyUserIsAbleToRemoveItemsFromTheShoppingCartSummaryPage_CartSummary_102() throws InterruptedException{

		LoginModule object = new LoginModule(driver);
		AddToCart object1 = new AddToCart(driver);

		//		Verify That Sign In Button is Present In Home Page
		boolean status=driver.findElement(By.xpath("//a[@title='Log in to your customer account']")).isDisplayed();
		Assert.assertTrue(status);
		ReportsAndScreenshots.captureScreenShot(driver);

		//		Sign In Common Method
		object.signIn();

		//		User should be sign in successfully and navigated to My Accounts page.
		System.out.println("User should be sign in successfully and navigated to My Accounts page.");

		//		Added Item to Cart and Payment
		object1.ItemsAddedToCart1();

		//		1st Items added in the cart should be displayed in the Shopping Cart Summary Page.
		boolean verifyItem1=driver.findElement(By.xpath("//div[@id='order-detail-content']//a[contains(text(),'Printed Chiffon Dress')]")).isDisplayed();
		Assert.assertTrue(verifyItem1);
		ReportsAndScreenshots.captureScreenShot(driver);
		System.out.println("1st Items added in the cart should be displayed in the Shopping Cart Summary Page.");

		//		Click on "Delete" button.
		//		driver.findElement(By.xpath("//i[@class='icon-trash']")).click();
		//		driver.findElement(By.xpath("//a[@title='Delete']")).click();

		WebElement element = driver.findElement(By.xpath("//a[@title='Delete']"));
		Actions action = new Actions(driver);
		//		builder.moveToElement(driver.findElement(By.xpath("//a[@title='Delete']"))).click().build().perform();

		action.moveToElement(element).build().perform();

		element.click();
//		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'Your shopping cart is empty.')]")));
		ReportsAndScreenshots.captureScreenShot(driver);
		System.out.println("Click on Delete button.");

		//		Item should get successfully removed from the Shopping Cart Summary page.
		boolean emptyMessage=driver.findElement(By.xpath("//p[contains(text(),'Your shopping cart is empty.')]")).isDisplayed();
		Assert.assertTrue(emptyMessage);
		ReportsAndScreenshots.captureScreenShot(driver);
		System.out.println("Item should get successfully removed from the Shopping Cart Summary page.");
	}

}
