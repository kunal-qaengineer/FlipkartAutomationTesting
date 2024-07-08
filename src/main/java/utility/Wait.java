package utility;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait extends BaseClass{
	
	
	public static void applyExplicitWaitForElementVisibility(String locator ) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		
	}
	
	 public static void applyExplicitWaitForClickable(String locator) {
	        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(30));
	        wait2.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
	    }

}
