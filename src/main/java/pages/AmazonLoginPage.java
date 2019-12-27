package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;


public class AmazonLoginPage extends BaseClass
{

	@FindBy(xpath="//span[contains(text(),'Hello, Sign in')]")
	WebElement HelloSignin;
	
	@FindBy(xpath="//span[@class='nav-sprite nav-logo-base']")
	WebElement Logo;
	
	@FindBy(xpath="//input[@id='ap_email']")
	WebElement Email;
	
	@FindBy(xpath="//input[@id='ap_password']")
	WebElement Password;
	
	@FindBy(xpath="//input[@id='signInSubmit']")
	WebElement SigninButton;
	
	@FindBy(xpath="//input[@id='twotabsearchtextbox']")
	WebElement searchBox;
	
	@FindBy(xpath="//span[@class='a-size-medium a-color-base a-text-normal']")
	List<WebElement> productListNames;
	
	public AmazonLoginPage() 
	{
		PageFactory.initElements(driver, this);	
	}
	
	public boolean LogoPresent()
	{
		return Logo.isDisplayed();
		
	}
	public String ConsumerPortalGetTittle()
	{
		return driver.getTitle();
	}
	
	public void AmazonLogin() throws InterruptedException
	{
		
		HelloSignin.click(); 	//*[@id="ap_email"]
		Thread.sleep(1000);
		Email.sendKeys(prop.getProperty("UserName"));
		driver.findElement(By.xpath("//input[@id='continue']")).click();
		Password.sendKeys(prop.getProperty("Password"));
		SigninButton.click();
		
	}
	public void SearchProduct() throws InterruptedException 
	{
		searchBox.sendKeys("Mobile phone"+Keys.ENTER);
		Thread.sleep(1000);
//		for(int i=0;i<productListNames.size();i++)
//		{
//			System.out.println(productListNames.get(i).getText());
//			logger.info("Product "+i+" : "+productListNames.get(i).getText());
//		}
	}
	public DashBoardPage DashboardPage()
	{
		return new DashBoardPage();
		
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
