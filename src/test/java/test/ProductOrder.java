package test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseClass;
import lib.TakeScreenshot;
import pages.AmazonLoginPage;
import pages.DashBoardPage;
import pages.Productorder;

public class ProductOrder extends BaseClass
{

	Productorder Cus;
	
	public ProductOrder()
	{

		super();
	}
	
	@BeforeTest 
	public void DashBoardIntialize()
	{
		Cus=new Productorder();
	}
	
	@Test(priority=7,description="going to add product in cart")
	public void ConsumerLogoTest() throws Exception
	{
		logger1 = extent.createTest("Order Product");
		
		Cus.orderProduct();
		Thread.sleep(5000);
		TakeScreenshot.captuerScreenshot(driver, "orderdetails");
		
	}
	
	@Test(priority=8,description="order and Logout Page From Amazon")
	public void AmazonLogout() throws InterruptedException
	{
		logger1 = extent.createTest("Validation of Amazon Customer Logout Functionality");
		Cus.AmazonLogout();
		logger.info("Sucesfully logout from Amazon");
		
		AmazonLoginPage loginPage = new AmazonLoginPage();
		loginPage.AmazonLogin();
		
	}
	
}
