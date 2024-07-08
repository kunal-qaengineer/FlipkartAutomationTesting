package utility;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BrokenLinks extends BaseClass{
	
	// To check all the link on the Home page are working or not. 
	// To check please run this test case special
	 
	
	public static void checkAllLiksAreWorking() {
		
		List <WebElement> links =driver.findElements(By.tagName("a"));
		System.out.println(links.size());
		
		int index = 0;
		
		while(index < links.size()) {
			WebElement link = links.get(index);
			String url = link.getAttribute("href");
			
			if(url==null || url.isEmpty()) {
				System.out.println("URL is either not configured for anchor tag or it is empty" + url);
			}else {
				try {
		            URL linkURL = new URL(url);
		            HttpURLConnection httpURLConnection = (HttpURLConnection) linkURL.openConnection();
		            httpURLConnection.setRequestMethod("HEAD");
		            httpURLConnection.connect();
		            int responseCode = httpURLConnection.getResponseCode();

		            if (responseCode >= 400) {
		                System.out.println(url+ ": " +responseCode + " is a broken link");
		                
		            }
		            else {
		               // System.out.println(url + " is a valid link");
		            }
		        } catch (Exception e) {
		            System.out.println(e);
		        }
				index++;
			}
			
			
		}
	}

}


