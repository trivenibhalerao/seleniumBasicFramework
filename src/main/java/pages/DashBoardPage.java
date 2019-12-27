package pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;

public class DashBoardPage extends BaseClass
{

	@FindBy(xpath="//input[@id='twotabsearchtextbox']")
	WebElement Search;

	@FindBy(xpath="//div[@id='resultsCol']")
	List<WebElement> MobileSearchResult;
	
	@FindBy(xpath="//*[@id=\"a-autoid-0-announce\"]/span[1]")
	WebElement sortBy;
	
	@FindBy(xpath="//*[@id=\"a-popover-3\"]/div/div/ul/li[3]")
	WebElement highToLow;

	@FindBy(xpath="//*[@id=\"search\"]/div[1]/div[2]/div/span[3]/div[1]/div[1]/div/span/div/div/div[2]/div[2]/div/div[1]/div/div/div[1]/h2/a/span")
	WebElement firstProduct;
	
	@FindBy(xpath="//input[@id='twotabsearchtextbox']")
	WebElement searchBox;
	
	public DashBoardPage()
	{
		PageFactory.initElements(driver, this);

	}

	public void MobileSearch()
	{
		Search.sendKeys("samsung m");
		Search.sendKeys(Keys.ENTER);
		List<WebElement> mList = MobileSearchResult;

		for (WebElement result:mList)
		{
			System.out.println("Result of Search is========");
			logger.info(result.getText());     
			System.out.println("=====================");

		}

	}

	public void ClickonSorting()
	{
		
		sortBy.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,50)");
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		highToLow.click();
				
	}
	
	public String mobilesSearchValidation()
	{
		return driver.getTitle(); 
			
	}
	
	public Productorder clickOnFirstProduct()
	{
		firstProduct.click();
		return new Productorder();
	}
	
	public void SearchProduct() throws InterruptedException 
	{
		searchBox.sendKeys("Mobile phone"+Keys.ENTER);
		Thread.sleep(1000);
	}


}
