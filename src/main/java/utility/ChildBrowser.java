package utility;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class ChildBrowser extends BaseClass {
	
	public static void switchToWindow(WebDriver driver, String title ) {

		
        Set<String> handles =driver.getWindowHandles(); 
        Iterator<String> i=handles.iterator();
        
        while(i.hasNext())
        {
        	String handle=i.next();
        	driver.switchTo().window(handle);
        	String currentTitle=driver.getTitle();
        	
        	if(currentTitle.equals(title))
        			{
        				break;
        			}
        	
        }
		
	}
}
