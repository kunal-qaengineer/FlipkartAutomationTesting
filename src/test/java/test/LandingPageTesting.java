
package test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

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
	public void selectPriceOfMobileFromTenThousandToTwentyThouandFromPriceFilterSlider() throws InterruptedException {
	test = reports.createTest("selectPriceOfMobileFromTenThousandToTwentyThouandFromPriceFilterSlider");
	LandingPage landingpage = new LandingPage(driver);
	landingpage.enterInputOnSearchInputField("Mobiles");
	Wait.applyExplicitWait("//button[@aria-label='Search for Products, Brands and More']");
	landingpage.clickEnterByKeyboard(driver);
	Wait.applyExplicitWait("/html/body/div/div/div[3]/div/div[1]/div/div[1]/div/section[2]/div[3]/div[1]");
	landingpage.selectMinTenThousandPriceOnPriceFilterSlider(driver);
	Wait.applyExplicitWait("/html/body/div/div/div[3]/div/div[1]/div/div[1]/div/section[1]/div[2]/div[1]/div/div[2]");
	//Thread.sleep(10000);
	landingpage.selectMaxTwentyThousandPriceOnPriceFilterSlider(driver);
	Wait.applyExplicitWait("/html/body/div/div/div[3]/div/div[1]/div/div[1]/div/section[2]/div[3]/div[1]/div[4]");
	Assert.assertTrue(landingpage.checkPriceIsDisplayedFromTenThousandToTwentyThousand());
	}
	
	
	@Test
	public void selectMotorolaMobileFromBrandsOptionsFromFilterByUsingSearchFieldOnBrandFilterWindow() throws InterruptedException {
		test = reports.createTest("selectMotorolaMobileFromBrandsOptionsFromFilter");
		LandingPage landingpage = new LandingPage(driver);
		landingpage.enterInputOnSearchInputField("Mobiles");
		Wait.applyExplicitWait("//button[@aria-label='Search for Products, Brands and More']");
		landingpage.clickEnterByKeyboard(driver);
		Wait.applyExplicitWait("//div[@class='e+xvXX KvHRYS']");
		landingpage.clickOnBrandMoreOptionsText();
		Wait.applyExplicitWait("//input[@placeholder='Search Brand']");
		landingpage.enterBrandOnsearchBrandInputField("MOTOROLA");
		landingpage.clickEnterByKeyboard(driver);
		Wait.applyExplicitWait("//div[@title='MOTOROLA']");
		landingpage.clickOnMotorolaOptionOnBrandFilterWindow();
		Wait.applyExplicitWait("//span[text()='Apply Filters']");
		landingpage.clickOnApplyFilterButtonOnBrandsOptionWindow();
		Wait.applyExplicitWait("(//div[text()='MOTOROLA'])[1]");
		SoftAssert softassert = new SoftAssert();
		softassert.assertTrue(landingpage.motorolaTextIsDisplayedAtFilters());
		softassert.assertAll();
	}
	
	@Parameters({"nameOfCheckbox"})
	@Test
	public void selectMobileBrandFromBrandsOptionsFromBrandFilter(String nameOfCheckbox) throws InterruptedException {
		test = reports.createTest("selectMotorolaMobileFromBrandsOptionsFromFilter");
		LandingPage landingpage = new LandingPage(driver);
		landingpage.enterInputOnSearchInputField("Mobiles");
		Wait.applyExplicitWait("//button[@aria-label='Search for Products, Brands and More']");
		landingpage.clickEnterByKeyboard(driver);
		Wait.applyExplicitWait("//div[@class='e+xvXX KvHRYS']");
		landingpage.clickOnBrandMoreOptionsText();
		Wait.applyExplicitWait("//input[@placeholder='Search Brand']");
		Thread.sleep(10000);
		landingpage.selectBrandCheckBoxOnLandingPage(nameOfCheckbox);
		Wait.applyExplicitWait("//span[text()='Apply Filters']");
		landingpage.clickOnApplyFilterButtonOnBrandsOptionWindow();
		Wait.applyExplicitWait("(//div[text()='MOTOROLA'])[1]");
		SoftAssert softassert = new SoftAssert();
		softassert.assertTrue(landingpage.motorolaTextIsDisplayedAtFilters());
		softassert.assertAll();
	}
	
}
