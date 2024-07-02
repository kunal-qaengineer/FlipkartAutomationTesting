package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reports {
	
	public static ExtentReports cretaeReport() {
		
		ExtentSparkReporter html = new ExtentSparkReporter("extentReports.html");
			
		ExtentReports reports = new ExtentReports();
		
		reports.attachReporter(html);
		
		reports.setSystemInfo("created By", "Kunal");
		reports.setSystemInfo("Type", "Regression");
		reports.setSystemInfo("Project", "Flipkart");
		reports.setSystemInfo("Module", "LandingPage");
		
		return reports;
			
	}

}
