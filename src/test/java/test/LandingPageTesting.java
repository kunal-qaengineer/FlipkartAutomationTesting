
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
import utility.ChildBrowser;
import utility.Wait;

@Listeners (utility.Listeners.class)
public class LandingPageTesting extends BaseClass {

	//TC1
	@BeforeMethod
	public void launchBrowser() {
	driver = Browser.openBroswer("https://www.flipkart.com/");
	}

	
	//TC3.1
	@Parameters({"inputOnSearch", "xMinPriceOnSlider", "xMaxPriceOnSlider"})
	@Test
	public void selectPriceOfMobileFromTwentyThouandToThirtyThousandPlusFromPriceFilterSlider(String inputOnSearch, int xMinPriceOnSlider, int xMaxPriceOnSlider) throws InterruptedException {
	test = reports.createTest("selectPriceOfMobileFromTwentyThouandToThirtyThousandPlusFromPriceFilterSlider");
	LandingPage landingpage = new LandingPage(driver);
	landingpage.enterInputOnSearchInputField(inputOnSearch);
	Wait.applyExplicitWait("//button[@aria-label='Search for Products, Brands and More']");
	landingpage.clickEnterByKeyboard(driver);
	Wait.applyExplicitWait("/html/body/div/div/div[3]/div/div[1]/div/div[1]/div/section[2]/div[3]/div[1]");
	landingpage.selectMinPriceOnPriceFilterSlider(driver, xMinPriceOnSlider);
	Wait.applyExplicitWait("/html/body/div/div/div[3]/div/div[1]/div/div[1]/div/section[2]/div[3]/div[1]/div[1]");
	//Thread.sleep(10000);
	landingpage.selectMaxPriceOnPriceFilterSlider(driver, xMaxPriceOnSlider);
	Wait.applyExplicitWait("/html/body/div/div/div[3]/div/div[1]/div/div[1]/div/section[2]/div[3]/div[1]/div[2]");
	Assert.assertTrue(landingpage.checkPriceIsDisplayedisApplied());
	}

	//TC3.2
	@Parameters({"inputOnSearch","mobileBrandName"})
	@Test
	public void selectSamsungMobileFromBrandsOptionsFromFilterByUsingSearchFieldOnBrandFilterWindow(String inputOnSearch, String mobileBrandName) throws InterruptedException {
		test = reports.createTest("selectSamsungMobileFromBrandsOptionsFromFilterByUsingSearchFieldOnBrandFilterWindow");
		LandingPage landingpage = new LandingPage(driver);
		landingpage.enterInputOnSearchInputField(inputOnSearch);
		Wait.applyExplicitWait("//button[@aria-label='Search for Products, Brands and More']");
		landingpage.clickEnterByKeyboard(driver);
		Wait.applyExplicitWait("//div[@class='e+xvXX KvHRYS']");
		landingpage.clickOnBrandMoreOptionsText();
		Wait.applyExplicitWait("//input[@placeholder='Search Brand']");
		landingpage.enterBrandOnsearchBrandInputField(mobileBrandName);
		landingpage.clickEnterByKeyboard(driver);
		Wait.applyExplicitWait("//div[@title='SAMSUNG']");
		landingpage.clickOnSamsungOptionOnBrandFilterWindow();
		Wait.applyExplicitWait("//span[text()='Apply Filters']");
		landingpage.clickOnApplyFilterButtonOnBrandsOptionWindow();
		Wait.applyExplicitWait("(//div[text()='SAMSUNG'])[1]");
		SoftAssert softassert = new SoftAssert();
		softassert.assertTrue(landingpage.samsungTextIsDisplayedAtFilters());
		softassert.assertAll();
	}
	
	//TC3.3
	@Parameters({"inputOnSearch", "nameOfCheckboxForRAM"})
	@Test
	public void selectRAMFromRAMCheckboxOnMobilePhonesPage(String inputOnSearch, String nameOfCheckboxForRAM) throws InterruptedException {
		test = reports.createTest("selectRAMFromRAMCheckboxOnMobilePhonesPage");
		LandingPage landingpage = new LandingPage(driver);
		landingpage.enterInputOnSearchInputField(inputOnSearch);
		Wait.applyExplicitWait("//button[@aria-label='Search for Products, Brands and More']");
		landingpage.clickEnterByKeyboard(driver);
		Wait.applyExplicitWait("//div[@class='ewzVkT _3DvUAf']");
		landingpage.selectcheckBoxForRAMOnMobilePhonesPage(nameOfCheckboxForRAM);
		Wait.applyExplicitWait("(//div[text()='8 GB and Above'])[1]");
		//Thread.sleep(10000);
		SoftAssert softassert = new SoftAssert();
		softassert.assertTrue(landingpage.ramTextIsSelectedDisplayedAtFilters());
		softassert.assertAll();
	}
	
	//TC4
	@Parameters({"inputOnSearch", "mobileBrandName", "nameOfCheckboxForRAM", "xMinPriceOnSlider", "xMaxPriceOnSlider"})
	@Test
	public void printTheCheapestAndCostliestPhoneWithItsNameAndPriceOnMobilePhonesPage( String inputOnSearch, String mobileBrandName, String nameOfCheckboxForRAM, int xMinPriceOnSlider, int xMaxPriceOnSlider) throws InterruptedException {
		test = reports.createTest("printTheCheapestAndCostliestPhoneWithItsNameAndPriceOnMobilePhonesPage");
		//selectPriceOfMobileFromTwentyThouandToThirtyThousandPlusFromPriceFilterSlider
		LandingPage landingpage = new LandingPage(driver);
		landingpage.enterInputOnSearchInputField(inputOnSearch);
		Wait.applyExplicitWait("//button[@aria-label='Search for Products, Brands and More']");
		landingpage.clickEnterByKeyboard(driver);
		Wait.applyExplicitWait("/html/body/div/div/div[3]/div/div[1]/div/div[1]/div/section[2]/div[3]/div[1]");
		landingpage.selectMinPriceOnPriceFilterSlider(driver, xMinPriceOnSlider);
		//Wait.applyExplicitWait("/html/body/div/div/div[3]/div/div[1]/div/div[1]/div/section[2]/div[3]/div[1]/div[1]");
		Thread.sleep(10000);
		landingpage.selectMaxPriceOnPriceFilterSlider(driver, xMaxPriceOnSlider);
		//Wait.applyExplicitWait("//div[text()='₹20000-₹30000+']");
		Thread.sleep(8000);
		//selectSamsungMobileFromBrandsOptionsFromFilterByUsingSearchFieldOnBrandFilterWindow
		landingpage.clickOnBrandMoreOptionsText();
		Wait.applyExplicitWait("//input[@placeholder='Search Brand']");
		landingpage.enterBrandOnsearchBrandInputField(mobileBrandName);
		landingpage.clickEnterByKeyboard(driver);
		Wait.applyExplicitWait("//div[@title='SAMSUNG']");
		landingpage.clickOnSamsungOptionOnBrandFilterWindow();
		Wait.applyExplicitWait("//span[text()='Apply Filters']");
		landingpage.clickOnApplyFilterButtonOnBrandsOptionWindow();
		Wait.applyExplicitWait("(//div[text()='SAMSUNG'])[1]");
		Thread.sleep(8000);
		//selectRAMFromRAMCheckboxOnMobilePhonesPage		
		landingpage.selectcheckBoxForRAMOnMobilePhonesPage(nameOfCheckboxForRAM);
		//Wait.applyExplicitWait("(//div[text()='8 GB and Above'])[1]");
		Thread.sleep(8000);
		//printTheCheapestAndCostliestPhon
		landingpage.clickOnPriceLowToHigh();
		Thread.sleep(8000);
		landingpage.printNameOfCheapestAndCostliestMobilePhone();
		landingpage.prinPriceOfCheapestAndCostliestMobilePhone();
		
		Assert.assertTrue(landingpage.priceLowToHighSortOptionIsSelected());
		
		}
				

	
//TC4
	@Parameters({"inputOnSearch", "mobileBrandName", "nameOfCheckboxForRAM", "xMinPriceOnSlider", "xMaxPriceOnSlider"})
	@Test
	public void clickOnTheFirstCheapestAndCostliestPhoneOnMobilePhonesPage( String inputOnSearch, String mobileBrandName, String nameOfCheckboxForRAM, int xMinPriceOnSlider, int xMaxPriceOnSlider) throws InterruptedException {
		test = reports.createTest("clickOnTheFirstCheapestAndCostliestPhoneOnMobilePhonesPage");
		//selectPriceOfMobileFromTwentyThouandToThirtyThousandPlusFromPriceFilterSlider
		LandingPage landingpage = new LandingPage(driver);
		landingpage.enterInputOnSearchInputField(inputOnSearch);
		Wait.applyExplicitWait("//button[@aria-label='Search for Products, Brands and More']");
		landingpage.clickEnterByKeyboard(driver);
		Wait.applyExplicitWait("/html/body/div/div/div[3]/div/div[1]/div/div[1]/div/section[2]/div[3]/div[1]");
		landingpage.selectMinPriceOnPriceFilterSlider(driver, xMinPriceOnSlider);
		//Wait.applyExplicitWait("/html/body/div/div/div[3]/div/div[1]/div/div[1]/div/section[2]/div[3]/div[1]/div[1]");
		Thread.sleep(10000);
		landingpage.selectMaxPriceOnPriceFilterSlider(driver, xMaxPriceOnSlider);
		//Wait.applyExplicitWait("//div[text()='₹20000-₹30000+']");
		Thread.sleep(8000);
		//selectSamsungMobileFromBrandsOptionsFromFilterByUsingSearchFieldOnBrandFilterWindow
		landingpage.clickOnBrandMoreOptionsText();
		Wait.applyExplicitWait("//input[@placeholder='Search Brand']");
		landingpage.enterBrandOnsearchBrandInputField(mobileBrandName);
		landingpage.clickEnterByKeyboard(driver);
		Wait.applyExplicitWait("//div[@title='SAMSUNG']");
		landingpage.clickOnSamsungOptionOnBrandFilterWindow();
		Wait.applyExplicitWait("//span[text()='Apply Filters']");
		landingpage.clickOnApplyFilterButtonOnBrandsOptionWindow();
		Wait.applyExplicitWait("(//div[text()='SAMSUNG'])[1]");
		Thread.sleep(8000);
		//selectRAMFromRAMCheckboxOnMobilePhonesPage		
		landingpage.selectcheckBoxForRAMOnMobilePhonesPage(nameOfCheckboxForRAM);
		//Wait.applyExplicitWait("(//div[text()='8 GB and Above'])[1]");
		Thread.sleep(8000);
		//printTheCheapestAndCostliestPhon
		landingpage.clickOnPriceLowToHigh();
		Thread.sleep(8000);
		landingpage.clickOnNameOfCheapestAndCostliestMobilePhoneInFirstPosition();
		Thread.sleep(8000);
		ChildBrowser.switchToWindow(driver, "SAMSUNG Galaxy A15 5G ( 128 GB Storage, 8 GB RAM ) Online at Best Price On Flipkart.com");
		Wait.applyExplicitWait("//button[@type='button']");
		
		Assert.assertTrue(landingpage.buyNowButtonOnMobileDetailssPageIsDisplayed());
		}
				
	}
	

	
/*	
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
	
	
	@Parameters({"inputOnSearch"})
	@Test
	public void selectPriceOfMobileFromTenThousandToTwentyThouandFromPriceFilterSlider(String inputOnSearch) throws InterruptedException {
	test = reports.createTest("selectPriceOfMobileFromTenThousandToTwentyThouandFromPriceFilterSlider");
	LandingPage landingpage = new LandingPage(driver);
	landingpage.enterInputOnSearchInputField(inputOnSearch);
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
*/

