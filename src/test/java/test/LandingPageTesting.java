
package test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pojo.Browser;
import pom.LandingPage;
import utility.BaseClass;
import utility.Wait;

@Listeners (utility.Listeners.class)
public class LandingPageTesting extends BaseClass {

	@BeforeMethod
	public void launchBrowser() {
	driver = Browser.openBroswer("https://www.flipkart.com/");
	}

	
	@Test
	public void selectPriceOfMobileFromTenThousandToTwentyThouandFromPriceFilterSlider() {
	test = reports.createTest("selectPriceOfMobileFromTenThousandToTwentyThouandFromPriceFilterSlider");
	LandingPage landingpage = new LandingPage(driver);
	landingpage.enterInputOnSearchInputField("Mobiles");
	Wait.applyExplicitWait("//button[@aria-label='Search for Products, Brands and More']");
	landingpage.clickOnMagnifyingLenceButton();
	Wait.applyExplicitWait("/html/body/div/div/div[3]/div/div[1]/div/div[1]/div/section[2]/div[3]/div[1]");
	landingpage.selectMinTenThousandPriceOnPriceFilterSlider(driver);
	Wait.applyExplicitWait("/html/body/div/div/div[3]/div[1]/div[1]/div/div[1]/div/section[2]/div[3]/div[1]/div[2]");
	landingpage.selectMaxTwentyThousandPriceOnPriceFilterSlider(driver);
	Wait.applyExplicitWait("/html/body/div/div/div[3]/div/div[1]/div/div[1]/div/section[2]/div[3]/div[1]/div[4]");
	Assert.assertTrue(landingpage.checkPriceFilterSliderIsSelectedFromTenThousandToTwentyThousand());
	}
	
	
}
