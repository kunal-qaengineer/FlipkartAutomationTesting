package utility;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class BaseClass {
	
	public static WebDriver driver;
	public static ExtentReports reports;
	public static ExtentTest test;

	
		
	@BeforeTest
	public void createReport() {
		reports=Reports.addReports();
	}
	
	
	@AfterMethod
	public void logReport(ITestResult result) 
	{
		
			if(result.getStatus()==ITestResult.SUCCESS) 
					{
						 test.log(Status.PASS, result.getName());
					}
			else if(result.getStatus()==ITestResult.FAILURE) 
					{
						test.log(Status.FAIL, result.getName());
						try 
						{
						  Screenshot.captureScreenshot(driver, result.getName());
						}
						catch(Exception e)
						{
							System.out.println("Screenshot is not capture due to : "+ e);
						}
					}
			else if(result.getStatus()==ITestResult.SKIP) 
					{
						test.log(Status.SKIP, result.getName());
					}
		driver.quit();
	}
		
	
	@AfterTest
	public void flushReport() {
		reports.flush();
	}
	

}
