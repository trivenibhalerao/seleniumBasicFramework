package pages;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;

public class Productorder extends BaseClass
{
	
	@FindBy(xpath="//*[@id=\"hlb-view-cart-announce\"]")
	WebElement addToCartbtn;
	
	
	@FindBy(xpath="//*[@id=\"sc-item-Cb54a402c-9cc8-426e-866a-5feb1775b7e7\"]/div[4]/div/div[1]/div/div/div[2]/ul/li[1]/span/a/span")
	WebElement productInCart;
	
	@FindBy(xpath="//*[@id=\"a-autoid-1-announce\"]/span[2]")
	WebElement qtyDropDrowPart;
	
	@FindBy(linkText="Sign Out")
	WebElement SignOut;
	
	@FindBy(xpath = "//*[@id=\"nav-flyout-accountList\"]/div[1]/div")
	WebElement AccountnBtn; 
	
	
	public Productorder() 
	{
		PageFactory.initElements(driver, this);	
	}
	
	
	public void orderProduct()
	{
		// switching windows here
		Set<String> mOk = driver.getWindowHandles();

		/*
		 * for (String handle : mOk)) { driver.switchTo().window(handle);
		 */
		
		String childWindow = null;
		Iterator<String> itr = mOk.iterator();
		while (itr.hasNext()) {
			childWindow = itr.next();
		}

		driver.switchTo().window(childWindow);
		    
		addToCartbtn.click();
	}
	
	public void AmazonLogout()
	{
		
				
        WebElement element = AccountnBtn;
        WebElement subelement = SignOut;
 
        Actions action = new Actions(driver);
 
       action.moveToElement(element).moveToElement(subelement).click().build().perform();
		
	}
}
