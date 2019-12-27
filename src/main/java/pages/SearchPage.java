package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;

public class SearchPage extends BaseClass {

	@FindBy(xpath="//span[@class='a-size-medium a-color-base a-text-normal']")
	List<WebElement> productListNames;
	
	public SearchPage() 
	{
		PageFactory.initElements(driver, this);	
	}
	public void getSearchResults() {
		
		for(int i=0;i<productListNames.size();i++)
		{
			System.out.println(productListNames.get(i).getText());
			logger.info("Product "+i+" : "+productListNames.get(i).getText());
		}
	}
	
}
