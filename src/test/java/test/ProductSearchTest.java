package test;

import java.net.MalformedURLException;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.AmazonLoginPage;
import pages.DashBoardPage;
import pages.SearchPage;

public class ProductSearchTest extends BaseClass{
	
	SearchPage sp;
	DashBoardPage dp;
	
	@BeforeSuite
	public void setup() throws MalformedURLException
	{
		initialization();
		sp=new SearchPage();
		dp=new DashBoardPage();
	}
	
	public ProductSearchTest() {
		super();
	}
	
	@Test
	public void searchProduct() throws InterruptedException {
		logger1 = extent.createTest("Validation of Amazon Customer Login");
		dp.SearchProduct();
		sp.getSearchResults();
	}
}
