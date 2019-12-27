
package lib;

import org.testng.ITestContext;
import org.testng.ITestListener;

import org.testng.ITestResult;




public class ListnerImpl implements ITestListener


{

	@Override
	public void onTestStart(ITestResult result)
	{
		
		System.out.println("Test Case Execution Started, for:\t"+result.getName());
		
		
	}

	@Override
	public void onTestSuccess(ITestResult result) 
	{
		
		System.out.println("Test Case Executed Sucesfully, for:\t"+result.getName());
		
	}

	@Override
	public void onTestFailure(ITestResult result) 
	{
		
		System.out.println("Test Case Execution Failed, :\t"+result.getName());
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result)
	{
		
		System.out.println("Test Case is Skipped,:\t"+result.getName());
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result)
	{
	
		
	}

	@Override
	public void onStart(ITestContext context)
	{
	
		
	}

	@Override
	public void onFinish(ITestContext context) 
	{
	
		
	}

	

}
