package test;

import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import base.BaseClass;
import lib.TakeScreenshot;
import pages.AmazonLoginPage;

public class AmazonLoginPageTest extends BaseClass
{
	//https://github.com/trivenibhalerao/amazonSelniumTest
	AmazonLoginPage Amz;
	@BeforeSuite
	public void setup() throws MalformedURLException
	{
		initialization();
		Amz=new AmazonLoginPage();
	}

	public AmazonLoginPageTest()
	{
		super();
	}

	@Test(/*priority=1,description="Logo On Amazon Home Page"*/)
	public void AmazonLogoTest() throws Exception
	{
		logger1 = extent.createTest("Validation of Logo On Amazon Home Page");
		boolean LogTest=Amz.LogoPresent();
		Assert.assertTrue(LogTest , "Logo is not present in Amazon.com Application");
		TakeScreenshot.captuerScreenshot(driver, "AmazonLogin");
		
	}

	@Test(/*priority=2,description=" Amazon Home Page"*/)
	public void bTittle()
	{
		logger1 = extent.createTest("Validation of Tittle On Amazon Home Page");
		String Tittle=Amz.ConsumerPortalGetTittle();
		Assert.assertEquals(Tittle, "Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more");
		logger.info("Tittle Validated Sucesfully on Amazon Home Page");
	}


	@Test(/*priority=3,description="Amazon Customer Login Page"*/)
	public void ConsumerLogoTest() throws Exception
	{
		logger1 = extent.createTest("Validation of Amazon Customer Login");
		Amz.AmazonLogin();
		logger.info("Amazon Customer Login Validation is Sucesfull");
		Amz.DashboardPage();
		TakeScreenshot.captuerScreenshot(driver, "DashboardPage");
	}
	@Test
	public void searchProduct() throws InterruptedException {
		logger1 = extent.createTest("Validation of Amazon Customer Login");
		Amz.SearchProduct();
	}

}
