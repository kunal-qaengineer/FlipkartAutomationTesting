package pojo;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Browser {
	
	public static WebDriver openBroswer(String url) 
								{
									
									
									WebDriverManager.chromedriver().setup();
									WebDriver driver = new ChromeDriver();
									
									driver.get(url);
									driver.manage().window().maximize();
									driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
									
									return driver;
								}
}
