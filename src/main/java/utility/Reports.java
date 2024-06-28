package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reports {
	
	public static ExtentReports addReports() {
		
		ExtentSparkReporter html = new ExtentSparkReporter("extentReport.html");
		ExtentReports reports = new ExtentReports();
		reports.attachReporter(html);
		
		reports.setSystemInfo("Created By", "Kunal Satao");
		reports.setSystemInfo("Testing Type", "Functional");
		reports.setSystemInfo("Project", "Flipkart");
		reports.setSystemInfo("Modules", "HomePage");
		
		return reports;		
	}

}
