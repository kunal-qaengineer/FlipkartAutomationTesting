
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
	
	/*
	Test Steps:
		1. Open the Flipkart website.
		2. Search for "mobile phones" in the search bar.
		3. Filter the mobile phones with certain criteria such as brand name (Samsung) using the search brand field box, RAM (8 GB Above), and price range (20,000-30,000+) using the price slider functionality.
		4. Print the cheapest and costliest phone with its name and price.
		5. Find the first phone that meets the criteria within the price range.
		6. Click on the first phone.
		7. Verify that the product details page is displayed.
		8. Check if the product is in stock.
		9. Add the product to the cart.
		10. Verify that the product is successfully added to the cart or not. Validate the amount including any discounts.
		11. Increase the quantity of the product by 1 using the number input and verify the popup text.
		12. Then decrease the quantity by using the (-) sign.
		13. Remove the product from the cart and verify the product is successfully removed.

	 */
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
				

	
//TC5, TC6, TC7
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
		//navigate to Product details page
		ChildBrowser.switchToWindow(driver, "SAMSUNG Galaxy A15 5G ( 128 GB Storage, 8 GB RAM ) Online at Best Price On Flipkart.com");
		Wait.applyExplicitWait("//button[@type='button']");
		
		Assert.assertTrue(landingpage.buyNowButtonOnMobileDetailssPageIsDisplayed());
		}
				
	
//TC8
	@Parameters({"inputOnSearch", "mobileBrandName", "nameOfCheckboxForRAM", "xMinPriceOnSlider", "xMaxPriceOnSlider"})
	@Test
	public void verifySelectedProductIsAvaiableInStockOnProductDetailsPage( String inputOnSearch, String mobileBrandName, String nameOfCheckboxForRAM, int xMinPriceOnSlider, int xMaxPriceOnSlider) throws InterruptedException {
		test = reports.createTest("verifySelectedProductIsAvaiableInStockOnProductDetailsPage");
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
		//navigate to Product details page
		ChildBrowser.switchToWindow(driver, "SAMSUNG Galaxy A15 5G ( 128 GB Storage, 8 GB RAM ) Online at Best Price On Flipkart.com");
		Wait.applyExplicitWait("//button[@type='button']");
		
		//Check this product is in Stock
		//When Buy now button is displayed to user then that Product is available in stock. And if product not in stock then Notify button is displayed instead of Buy Now button.
		landingpage.buyNowButtonOnMobileDetailssPageIsDisplayed();
		
		Assert.assertTrue(landingpage.buyNowButtonOnMobileDetailssPageIsDisplayed());
		}

//TC9	
	@Parameters({"inputOnSearch", "mobileBrandName", "nameOfCheckboxForRAM", "xMinPriceOnSlider", "xMaxPriceOnSlider"})
	@Test
	public void verifyUserAbleToAddMobileInCartAndThatIsDisplayedInAddToCartPage( String inputOnSearch, String mobileBrandName, String nameOfCheckboxForRAM, int xMinPriceOnSlider, int xMaxPriceOnSlider) throws InterruptedException {
		test = reports.createTest("verifyUserAbleToAddMobileInCartAndThatIsDisplayedInAddToCartPage");
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
		//navigate to Product details page
		ChildBrowser.switchToWindow(driver, "SAMSUNG Galaxy A15 5G ( 128 GB Storage, 8 GB RAM ) Online at Best Price On Flipkart.com");
		Wait.applyExplicitWait("//button[@type='button']");
		
		//Check this product is in Stock
		//When Buy now button is displayed to user then that Product is available in stock. And if product not in stock then Notify button is displayed instead of Buy Now button.
		landingpage.buyNowButtonOnMobileDetailssPageIsDisplayed();
		
		//click On Add to Cart button
		landingpage.clickOnAddToCartButtonOnProductDetailsPage();
		Wait.applyExplicitWait("//button[@class='QqFHMw zA2EfJ _7Pd1Fp']");
		//After click on Add To Cart Button user navigate to Add ToCart Page and page of this title is "Shopping Cart | Flipkart.com"
		Assert.assertEquals(driver.getTitle(), "Shopping Cart | Flipkart.com");
		}
	
	

	@Parameters({"inputOnSearch", "mobileBrandName", "nameOfCheckboxForRAM", "xMinPriceOnSlider", "xMaxPriceOnSlider"})
	@Test
	public void verifyDiscuoutIsReducedFromThePriceAndValidateTotalAmmoutToBuyMobile(String inputOnSearch, String mobileBrandName, String nameOfCheckboxForRAM, int xMinPriceOnSlider, int xMaxPriceOnSlider) throws InterruptedException {
		test = reports.createTest("verifyDiscuoutIsReducedFromThePriceAndValidateTotalAmmoutToBuyMobile");
		
		
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
	//	Wait.applyExplicitWait("(//div[text()='SAMSUNG'])[1]");
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
		//navigate to Product details page
		ChildBrowser.switchToWindow(driver, "SAMSUNG Galaxy A15 5G ( 128 GB Storage, 8 GB RAM ) Online at Best Price On Flipkart.com");
		Wait.applyExplicitWait("//button[@type='button']");
		
		//Check this product is in Stock
		//When Buy now button is displayed to user then that Product is available in stock. And if product not in stock then Notify button is displayed instead of Buy Now button.
		landingpage.buyNowButtonOnMobileDetailssPageIsDisplayed();
		
		//click On Add to Cart button
		landingpage.clickOnAddToCartButtonOnProductDetailsPage();
		Wait.applyExplicitWait("//button[@class='QqFHMw zA2EfJ _7Pd1Fp']");
		
		int expectedBuyingPrice=landingpage.expectedBuyingPriceAfterdiscountAndDeliveryChargesReducedFromTotalAmount();
		
		 // Assert that the actual buying price matches the expected buying price
	    Assert.assertEquals(landingpage.buyingPriceOfTheProductOnAddToCartPage(), expectedBuyingPrice, "The buying price is incorrect.");
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

