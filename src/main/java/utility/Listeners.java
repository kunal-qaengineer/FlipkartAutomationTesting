package utility;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners extends BaseClass implements ITestListener{
	
	
	public void onTestStart(ITestResult result) {
		
			System.out.println("Test is started: "+ result.getName());			
	}
	
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test is Passed: "+ result.getName());
	}
	
	public void onTestFailure(ITestResult result) {
			
		System.out.println("Test is failed: "+ result.getName());
		try {
			Screenshot.takeScreenshot(driver, result.getName());
		}
		catch(Exception e){
			System.out.println("Screenshot not capture due to exception");
		}
		
	}
	
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test is skipped: "+ result.getName());
	}

}
