package com.shopping.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.shopping.Utils.ReportsAndScreenshots;

public class AddToCart {
	
	WebDriver driver;

	@FindBy(xpath="//a[@title='Women']")
	private WebElement WomenLable;
	
	@FindBy(xpath="//div[@class='right-block']//a[@title='Faded Short Sleeve T-shirts']")
	private WebElement iteamToAdd1;
	
	@FindBy(xpath="//button[@name='Submit']")
	private WebElement addToCartButton;
	
	@FindBy(xpath="//a[@title='Proceed to checkout']")
	private WebElement proceedToCheckoutButton;
	
	@FindBy(xpath="//span[@title='Continue shopping']")
	private WebElement continueShoppingButton;
	
	@FindBy(xpath="//div[@class='right-block']//a[@title='Blouse']")
	private WebElement iteamToAdd2;
	
	@FindBy(xpath="//a[@class='btn btn-default button button-medium']")
	private WebElement proceedToCheckoutButtonInSummaryPage1;
	
	@FindBy(xpath="//a[@class='button btn btn-default standard-checkout button-medium']")
	private WebElement proceedToCheckoutButtonInSummaryPage;
	
	@FindBy(xpath="//button[@class='button btn btn-default button-medium']")
	private WebElement proceedToCheckoutButtonInAddressPage;
	
	@FindBy(xpath="//button[@class='button btn btn-default standard-checkout button-medium']")
	private WebElement proceedToCheckoutButtonInShippingPage;
	
	@FindBy(xpath="//input[@id='cgv']")
	private WebElement termsofServiceCheckBox;
	
	@FindBy(xpath="//a[@title='Pay by bank wire']")
	private WebElement PayByBankWireLink;
	
	@FindBy(xpath="//span[contains(text(),'I confirm my order')]")
	private WebElement IConfirmMyOrderButton;
	
	@FindBy(xpath="//div[contains(@class,'box')]/p/strong[contains(text(),'Your order on My Store is complete.')]")
	private WebElement successMessage;
	
	@FindBy(xpath="//div[@id='order-detail-content']//a[contains(text(),'Faded Short Sleeve T-shirts')]")
	private WebElement verifyCartIteam;
	
	@FindBy(xpath="//div[@id='order-detail-content']//a[contains(text(),'Blouse')]")
	private WebElement verifyCartIteam1;
	
	@FindBy(xpath="//div[@class='right-block']//a[@title='Printed Chiffon Dress']")
	private WebElement iteamToAdd3;

	public AddToCart(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
		
	public void ProductAddToCart()
	{
		
//		Click on Women Section
		WomenLable.click();
		ReportsAndScreenshots.captureScreenShot(driver);
		System.out.println("Click on Women Section");
		
//		Click on Product user want add to cart
		iteamToAdd1.click();
		ReportsAndScreenshots.captureScreenShot(driver);
		System.out.println("Click on Product user want add to cart");
		
//		Click on Add to Cart Button
		addToCartButton.click();
		ReportsAndScreenshots.captureScreenShot(driver);
		System.out.println("Click on Product user want add to cart");
		
//		Click on Continue shopping Button
		continueShoppingButton.click();
		ReportsAndScreenshots.captureScreenShot(driver);
		System.out.println("Click on Continue shopping Button");
		
//		Click on Women Section
		WomenLable.click();
		ReportsAndScreenshots.captureScreenShot(driver);
		System.out.println("Click on Women Section");
		
//		Click on Product user want add to cart
		iteamToAdd2.click();
		ReportsAndScreenshots.captureScreenShot(driver);
		System.out.println("Click on Product user want add to cart2");
		
//		Click on Add to Cart Button
		addToCartButton.click();
		ReportsAndScreenshots.captureScreenShot(driver);
		System.out.println("Click on Product user want add to cart2");
		
//		Click on Proceed To Checkout Button in PopUp Window
		proceedToCheckoutButtonInSummaryPage1.click();
		ReportsAndScreenshots.captureScreenShot(driver);
		System.out.println("Click on Proceed To Checkout Button in PopUp Window");
		
//		Click on Proceed To Checkout Button in Shopping-cart summary Page
		proceedToCheckoutButtonInSummaryPage.click();
		ReportsAndScreenshots.captureScreenShot(driver);
		System.out.println("Click on Proceed To Checkout Button in Shopping-cart summary Page");
		
//		Click on Proceed To Checkout Button in Addresses Page
		proceedToCheckoutButtonInAddressPage.click();
		ReportsAndScreenshots.captureScreenShot(driver);
		System.out.println("Click on Proceed To Checkout Button in Addresses Page");
		
//		Click on Terms of service Check Box
		termsofServiceCheckBox.click();
		ReportsAndScreenshots.captureScreenShot(driver);
		System.out.println("Click on Terms of service Check Box");
        
//		Click on Proceed To Checkout Button in Shipping Page
		proceedToCheckoutButtonInShippingPage.click();
		ReportsAndScreenshots.captureScreenShot(driver);
		System.out.println("Click on Proceed To Checkout Button in Shipping Page");
		
//		Click on Pay by bank wire Link
		PayByBankWireLink.click();
		ReportsAndScreenshots.captureScreenShot(driver);
		System.out.println("Click on Pay by bank wire Link");
		
//		Click on I Confirm My Order Button
		IConfirmMyOrderButton.click();
		ReportsAndScreenshots.captureScreenShot(driver);
		System.out.println("Click on I Confirm My Order Button");
		
//		Verify Success Message
		Assert.assertTrue(successMessage.isDisplayed(), "Assert Success Message");
		ReportsAndScreenshots.captureScreenShot(driver);
	}
	public void ItemsAddedToCart()
	{
		
//		Click on Women Section
		WomenLable.click();
		ReportsAndScreenshots.captureScreenShot(driver);
		System.out.println("Click on Women Section");
		
//		Click on Product user want add to cart
		iteamToAdd1.click();
		ReportsAndScreenshots.captureScreenShot(driver);
		System.out.println("Click on Product user want add to cart");
		
//		Click on Add to Cart Button
		addToCartButton.click();
		ReportsAndScreenshots.captureScreenShot(driver);
		System.out.println("Click on Product user want add to cart");
		
//		Click on Continue shopping Button
		continueShoppingButton.click();
		ReportsAndScreenshots.captureScreenShot(driver);
		System.out.println("Click on Continue shopping Button");
		
//		Click on Women Section
		WomenLable.click();
		ReportsAndScreenshots.captureScreenShot(driver);
		System.out.println("Click on Women Section");
		
//		Click on Product user want add to cart
		iteamToAdd2.click();
		ReportsAndScreenshots.captureScreenShot(driver);
		System.out.println("Click on Product user want add to cart2");
		
//		Click on Add to Cart Button
		addToCartButton.click();
		ReportsAndScreenshots.captureScreenShot(driver);
		System.out.println("Click on Product user want add to cart2");
		
//		Click on Proceed To Checkout Button in PopUp Window
		proceedToCheckoutButtonInSummaryPage1.click();
		ReportsAndScreenshots.captureScreenShot(driver);
		System.out.println("Click on Proceed To Checkout Button in PopUp Window");
	}
	public void ItemsAddedToCart1()
	{
		
//		Click on Women Section
		WomenLable.click();
		ReportsAndScreenshots.captureScreenShot(driver);
		System.out.println("Click on Women Section");
		
//		Click on Product user want add to cart
		iteamToAdd3.click();
		ReportsAndScreenshots.captureScreenShot(driver);
		System.out.println("Click on Product user want add to cart3");
		
//		Click on Add to Cart Button
		addToCartButton.click();
		ReportsAndScreenshots.captureScreenShot(driver);
		System.out.println("Click on Product user want add to cart");
		
//		Click on Proceed To Checkout Button in PopUp Window
		proceedToCheckoutButtonInSummaryPage1.click();
		ReportsAndScreenshots.captureScreenShot(driver);
		System.out.println("Click on Proceed To Checkout Button in PopUp Window");
	}
}
