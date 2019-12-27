package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import lib.TakeScreenshot;
import lib.WebElementListener;

public class BaseClass
{

	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebElementListener eventListener;
	public static Logger logger;
	public static ExtentTest logger1;
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	static String nodeURL;

	@BeforeSuite

	public void ReportSetup() throws IOException 
	{
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/test-output/STMExtentReport1.html");
		extent = new ExtentReports ();
		extent.attachReporter(htmlReporter);
			
	}


	public BaseClass()
	{
		try {
			prop = new Properties();
			//System.getProperty("user.dir")+ "/src/main/java/config/Conf.properties"						
			FileInputStream ip = new FileInputStream("F:\\framework\\AmazonTest\\src\\main\\java\\config\\Conf.properties");
			prop.load(ip);
			logger=Logger.getLogger("First");
			PropertyConfigurator.configure("F:\\framework\\AmazonTest\\src\\main\\java\\config\\log4j.properties");
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}


	public static void initialization() throws MalformedURLException
	{
		String browserName = prop.getProperty("browser");

		if(browserName.equals("Chrome")){
			System.setProperty("webdriver.chrome.driver","F:\\framework\\AmazonTest\\chromedriver.exe");	
			driver = new ChromeDriver(); 
		}
		else if(browserName.equals("FireFox")){
			driver = new FirefoxDriver(); 
		}
		
		e_driver = new EventFiringWebDriver(driver);
		
		eventListener = new WebElementListener();
		e_driver.register(eventListener);
		driver = e_driver;

		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.get(prop.getProperty("url"));

	}

	@AfterMethod
	public void getResult(ITestResult result) throws Exception
	{
		if(result.getStatus() == ITestResult.FAILURE)
		{
			
			String screenshotPath = TakeScreenshot.captuerScreenshot(driver, result.getName());
			logger1.fail("Test Case Failed " + logger1.addScreenCaptureFromPath(screenshotPath));


		}
		
		else if(result.getStatus() == ITestResult.SUCCESS)
		{
			logger1.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" Test PASSED", ExtentColor.GREEN));
		}

	}
	
	
	@AfterTest
	public void Exit() {
		driver.quit();
	}


	@AfterSuite
	public void endReport()
	{
		extent.flush();
	}




}








