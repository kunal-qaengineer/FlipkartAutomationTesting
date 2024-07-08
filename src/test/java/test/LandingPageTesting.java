
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
	
	
	// ********* Helper methods for reducing redundancy and improving readability ******
	
	private void searchForProduct(String inputOnSearch) {
		LandingPage landingPage = new LandingPage(driver);
	    landingPage.enterInputOnSearchInputField(inputOnSearch);
	    Wait.applyExplicitWaitForElementVisibility("//button[@aria-label='Search for Products, Brands and More']");
	    landingPage.clickEnterByKeyboard(driver);
	}
	
	private void applyPriceFilter(int xMinPriceOnSlider, int xMaxPriceOnSlider) throws InterruptedException {
		LandingPage landingPage = new LandingPage(driver);
	    landingPage.selectMinPriceOnPriceFilterSlider(driver, xMinPriceOnSlider);
	    Thread.sleep(10000);
	    landingPage.selectMaxPriceOnPriceFilterSlider(driver, xMaxPriceOnSlider);
	  //  Thread.sleep(8000);
	}
	
	private void applyBrandFilter(String mobileBrandName) throws InterruptedException {
		LandingPage landingPage = new LandingPage(driver);
	    landingPage.clickOnBrandMoreOptionsText();
	    Wait.applyExplicitWaitForElementVisibility("//input[@placeholder='Search Brand']");
	    landingPage.enterBrandOnSearchBrandInputField(mobileBrandName);
	    landingPage.clickEnterByKeyboard(driver);
	    Wait.applyExplicitWaitForClickable("//div[@title='SAMSUNG']");
	    landingPage.clickOnSamsungOptionOnBrandFilterWindow();
	    Wait.applyExplicitWaitForClickable("//span[text()='Apply Filters']");
	    landingPage.clickOnApplyFilterButtonOnBrandsOptionWindow();
	    Wait.applyExplicitWaitForElementVisibility("(//div[text()='SAMSUNG'])[1]");
	}

	
	
	//TC2
	@Parameters({"inputOnSearch"})
	@Test
	public void verifyUserIsAbleToSearchProductsOnByEnetringInputsOnSearchField(String inputOnSearch) {
		test = reports.createTest("verifyUserIsAbleToSearchProductsOnByEnetringInputsOnSearchField");
		LandingPageTesting landingpagetesting = new LandingPageTesting();
		landingpagetesting.searchForProduct(inputOnSearch);
		LandingPage landingpage = new LandingPage(driver);		
		Wait.applyExplicitWaitForElementVisibility("//span[text()='Filters']");
		Assert.assertTrue(landingpage.filterTitleIsDisplayedAtTopLeft());
		
	}
	
	//TC3.1
	@Parameters({"inputOnSearch", "xMinPriceOnSlider", "xMaxPriceOnSlider"})
	@Test
	public void selectPriceOfMobileFromTwentyThouandToThirtyThousandPlusFromPriceFilterSlider(String inputOnSearch, int xMinPriceOnSlider, int xMaxPriceOnSlider) throws InterruptedException {
				test = reports.createTest("selectPriceOfMobileFromTwentyThouandToThirtyThousandPlusFromPriceFilterSlider");
				LandingPageTesting landingpagetesting = new LandingPageTesting();
				landingpagetesting.searchForProduct(inputOnSearch);
				Wait.applyExplicitWaitForElementVisibility("/html/body/div/div/div[3]/div/div[1]/div/div[1]/div/section[2]/div[3]/div[1]");
				landingpagetesting.applyPriceFilter(xMinPriceOnSlider, xMaxPriceOnSlider);
				LandingPage landingpage = new LandingPage(driver);
				Wait.applyExplicitWaitForElementVisibility("//div[@class='_6tw8ju']");
				Assert.assertTrue(landingpage.checkPriceIsDisplayedisApplied());
	}

	//TC3.2
	@Parameters({"inputOnSearch","mobileBrandName"})
	@Test
	public void selectSamsungMobileFromBrandsOptionsFromFilterByUsingSearchFieldOnBrandFilterWindow(String inputOnSearch, String mobileBrandName) throws InterruptedException {
				test = reports.createTest("selectSamsungMobileFromBrandsOptionsFromFilterByUsingSearchFieldOnBrandFilterWindow");
				//Search the Product
				LandingPageTesting landingpagetesting = new LandingPageTesting();
				landingpagetesting.searchForProduct(inputOnSearch);				
				Wait.applyExplicitWaitForElementVisibility("//div[@class='e+xvXX KvHRYS']");
				//Filter with Mobile Brand
				landingpagetesting.applyBrandFilter(mobileBrandName);
				LandingPage landingpage = new LandingPage(driver);
				SoftAssert softassert = new SoftAssert();
				softassert.assertTrue(landingpage.samsungTextIsDisplayedAtFilters());
				softassert.assertAll();
	}
	
	//TC3.3
	@Parameters({"inputOnSearch", "nameOfCheckboxForRAM"})
	@Test
	public void selectRAMFromRAMCheckboxOnMobilePhonesPage(String inputOnSearch, String nameOfCheckboxForRAM) throws InterruptedException {
				test = reports.createTest("selectRAMFromRAMCheckboxOnMobilePhonesPage");
				//Search the Product
				LandingPageTesting landingpagetesting = new LandingPageTesting();
				landingpagetesting.searchForProduct(inputOnSearch);	
				Wait.applyExplicitWaitForClickable("//div[@class='ewzVkT _3DvUAf']");
				//Filter with RAM
				LandingPage landingpage = new LandingPage(driver);
				landingpage.selectcheckBoxForRAMOnMobilePhonesPage(nameOfCheckboxForRAM);
				Wait.applyExplicitWaitForElementVisibility("(//div[text()='8 GB and Above'])[1]");
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
				//Search the Product
				LandingPageTesting landingpagetesting = new LandingPageTesting();
				landingpagetesting.searchForProduct(inputOnSearch);	
				Wait.applyExplicitWaitForElementVisibility("/html/body/div/div/div[3]/div/div[1]/div/div[1]/div/section[2]/div[3]/div[1]");
				landingpagetesting.applyPriceFilter(xMinPriceOnSlider, xMaxPriceOnSlider);
				Wait.applyExplicitWaitForElementVisibility("//div[text()='₹20000-₹30000+']");
				//Thread.sleep(8000);
			//selectSamsungMobileFromBrandsOptionsFromFilterByUsingSearchFieldOnBrandFilterWindow
				landingpagetesting.applyBrandFilter(mobileBrandName);
				Wait.applyExplicitWaitForElementVisibility("(//div[text()='SAMSUNG'])[1]");
				Thread.sleep(8000);
			//selectRAMFromRAMCheckboxOnMobilePhonesPage	
				LandingPage landingpage = new LandingPage(driver);
				landingpage.selectcheckBoxForRAMOnMobilePhonesPage(nameOfCheckboxForRAM);
				Wait.applyExplicitWaitForElementVisibility("(//div[text()='8 GB and Above'])[1]");
				Thread.sleep(8000);
			//printTheCheapestAndCostliestPhon
				landingpage.clickOnPriceLowToHigh();
				Wait.applyExplicitWaitForElementVisibility("/html/body/div/div/div[3]/div/div[2]/div[2]/div/div/div/a/div[2]/div[1]/div[1]");
				Thread.sleep(10000);
				landingpage.printNameOfCheapestAndCostliestMobilePhone(0);
				landingpage.prinPriceOfCheapestAndCostliestMobilePhone(0);				
				Assert.assertEquals(landingpage.printNameOfCheapestAndCostliestMobilePhone(0), "SAMSUNG Galaxy A15 5G (Blue Black, 128 GB)");
		
		}
				

	
//TC5, TC6, TC7
	@Parameters({"inputOnSearch", "mobileBrandName", "nameOfCheckboxForRAM", "xMinPriceOnSlider", "xMaxPriceOnSlider"})
	@Test
	public void clickOnTheFirstCheapestAndCostliestPhoneOnMobilePhonesPage(String inputOnSearch, String mobileBrandName, String nameOfCheckboxForRAM, int xMinPriceOnSlider, int xMaxPriceOnSlider) throws InterruptedException {
				test = reports.createTest("clickOnTheFirstCheapestAndCostliestPhoneOnMobilePhonesPage");
			//selectPriceOfMobileFromTwentyThouandToThirtyThousandPlusFromPriceFilterSlider
				//Search the Product
				LandingPageTesting landingpagetesting = new LandingPageTesting();
				landingpagetesting.searchForProduct(inputOnSearch);	
				Wait.applyExplicitWaitForElementVisibility("/html/body/div/div/div[3]/div/div[1]/div/div[1]/div/section[2]/div[3]/div[1]");
				landingpagetesting.applyPriceFilter(xMinPriceOnSlider, xMaxPriceOnSlider);
				Thread.sleep(8000);
			//selectSamsungMobileFromBrandsOptionsFromFilterByUsingSearchFieldOnBrandFilterWindow
				landingpagetesting.applyBrandFilter(mobileBrandName);
			//	Wait.applyExplicitWaitForElementVisibility("(//div[text()='SAMSUNG'])[1]");
				Thread.sleep(8000);
			//selectRAMFromRAMCheckboxOnMobilePhonesPage
				LandingPage landingpage = new LandingPage(driver);
				landingpage.selectcheckBoxForRAMOnMobilePhonesPage(nameOfCheckboxForRAM);
				//Wait.applyExplicitWaitForElementVisibility("(//div[text()='8 GB and Above'])[1]");
				Thread.sleep(8000);
			//clickOnTheCheapestAndCostliestPhon
				landingpage.clickOnPriceLowToHigh();
				Thread.sleep(8000);
				landingpage.clickOnNameOfCheapestAndCostliestMobilePhone(0);
				Thread.sleep(8000);
			//navigate to Product details page
				ChildBrowser.switchToWindow(driver, "SAMSUNG Galaxy A15 5G ( 128 GB Storage, 8 GB RAM ) Online at Best Price On Flipkart.com");
				Wait.applyExplicitWaitForElementVisibility("//button[@type='button']");				
				Assert.assertTrue(landingpage.buyNowButtonOnMobileDetailssPageIsDisplayed());
		}
		
	@Parameters({"inputOnSearch", "mobileBrandName", "nameOfCheckboxForRAM", "xMinPriceOnSlider", "xMaxPriceOnSlider"})
	@Test
	public void clickOnTheSecondCheapestAndCostliestPhoneOnMobilePhonesPage( String inputOnSearch, String mobileBrandName, String nameOfCheckboxForRAM, int xMinPriceOnSlider, int xMaxPriceOnSlider) throws InterruptedException {
				test = reports.createTest("clickOnTheFirstCheapestAndCostliestPhoneOnMobilePhonesPage");
			//selectPriceOfMobileFromTwentyThouandToThirtyThousandPlusFromPriceFilterSlider
				//Search the Product
				LandingPageTesting landingpagetesting = new LandingPageTesting();
				landingpagetesting.searchForProduct(inputOnSearch);	
				Wait.applyExplicitWaitForElementVisibility("/html/body/div/div/div[3]/div/div[1]/div/div[1]/div/section[2]/div[3]/div[1]");
				landingpagetesting.applyPriceFilter(xMinPriceOnSlider, xMaxPriceOnSlider);
				Thread.sleep(8000);
			//selectSamsungMobileFromBrandsOptionsFromFilterByUsingSearchFieldOnBrandFilterWindow
				landingpagetesting.applyBrandFilter(mobileBrandName);
			//	Wait.applyExplicitWaitForElementVisibility("(//div[text()='SAMSUNG'])[1]");
				Thread.sleep(8000);
			//selectRAMFromRAMCheckboxOnMobilePhonesPage
				LandingPage landingpage = new LandingPage(driver);
				landingpage.selectcheckBoxForRAMOnMobilePhonesPage(nameOfCheckboxForRAM);
				//Wait.applyExplicitWaitForElementVisibility("(//div[text()='8 GB and Above'])[1]");
				Thread.sleep(8000);
			//clickOnTheCheapestAndCostliestPhone
				landingpage.clickOnPriceLowToHigh();
				Thread.sleep(8000);
				landingpage.clickOnNameOfCheapestAndCostliestMobilePhone(1);
				Thread.sleep(8000);
			//navigate to Product details page
				ChildBrowser.switchToWindow(driver, "SAMSUNG Galaxy A15 5G ( 128 GB Storage, 8 GB RAM ) Online at Best Price On Flipkart.com");
				Wait.applyExplicitWaitForElementVisibility("//button[@type='button']");				
				Assert.assertTrue(landingpage.buyNowButtonOnMobileDetailssPageIsDisplayed());
		}
	
//TC8
	@Parameters({"inputOnSearch", "mobileBrandName", "nameOfCheckboxForRAM", "xMinPriceOnSlider", "xMaxPriceOnSlider", "selectMobileFromTopAfterFilterPriceLowToHigh"})
	@Test
	public void verifySelectedProductIsAvaiableInStockOnProductDetailsPage( String inputOnSearch, String mobileBrandName, String nameOfCheckboxForRAM, int xMinPriceOnSlider, int xMaxPriceOnSlider, int selectMobileFromTopAfterFilterPriceLowToHigh) throws InterruptedException {
				test = reports.createTest("verifySelectedProductIsAvaiableInStockOnProductDetailsPage");
			//selectPriceOfMobileFromTwentyThouandToThirtyThousandPlusFromPriceFilterSlider
				//Search the Product
				LandingPageTesting landingpagetesting = new LandingPageTesting();
				landingpagetesting.searchForProduct(inputOnSearch);	
				Wait.applyExplicitWaitForElementVisibility("/html/body/div/div/div[3]/div/div[1]/div/div[1]/div/section[2]/div[3]/div[1]");
				landingpagetesting.applyPriceFilter(xMinPriceOnSlider, xMaxPriceOnSlider);
				Thread.sleep(8000);
			//selectSamsungMobileFromBrandsOptionsFromFilterByUsingSearchFieldOnBrandFilterWindow
				landingpagetesting.applyBrandFilter(mobileBrandName);
			//	Wait.applyExplicitWaitForElementVisibility("(//div[text()='SAMSUNG'])[1]");
				Thread.sleep(8000);
			//selectRAMFromRAMCheckboxOnMobilePhonesPage
				LandingPage landingpage = new LandingPage(driver);
				landingpage.selectcheckBoxForRAMOnMobilePhonesPage(nameOfCheckboxForRAM);
				//Wait.applyExplicitWaitForElementVisibility("(//div[text()='8 GB and Above'])[1]");
				Thread.sleep(8000);
			//clickOnTheCheapestAndCostliestPhone
				landingpage.clickOnPriceLowToHigh();
				Thread.sleep(8000);
				landingpage.clickOnNameOfCheapestAndCostliestMobilePhone(selectMobileFromTopAfterFilterPriceLowToHigh);
				Thread.sleep(8000);
			//navigate to Product details page
				ChildBrowser.switchToWindow(driver, "SAMSUNG Galaxy A15 5G ( 128 GB Storage, 8 GB RAM ) Online at Best Price On Flipkart.com");
				Wait.applyExplicitWaitForElementVisibility("//button[@type='button']");				
			//Check this product is in Stock
			//When Buy now button is displayed to user then that Product is available in stock. And if product not in stock then Notify button is displayed instead of Buy Now button.
				landingpage.buyNowButtonOnMobileDetailssPageIsDisplayed();				
				Assert.assertTrue(landingpage.buyNowButtonOnMobileDetailssPageIsDisplayed());
		}

//TC9	
	@Parameters({"inputOnSearch", "mobileBrandName", "nameOfCheckboxForRAM", "xMinPriceOnSlider", "xMaxPriceOnSlider", "selectMobileFromTopAfterFilterPriceLowToHigh"})
	@Test
	public void verifyUserAbleToAddMobileInCartAndThatIsDisplayedInAddToCartPage( String inputOnSearch, String mobileBrandName, String nameOfCheckboxForRAM, int xMinPriceOnSlider, int xMaxPriceOnSlider, int selectMobileFromTopAfterFilterPriceLowToHigh) throws InterruptedException {
				test = reports.createTest("verifyUserAbleToAddMobileInCartAndThatIsDisplayedInAddToCartPage");
			//selectPriceOfMobileFromTwentyThouandToThirtyThousandPlusFromPriceFilterSlider
				//Search the Product
				LandingPageTesting landingpagetesting = new LandingPageTesting();
				landingpagetesting.searchForProduct(inputOnSearch);	
				Wait.applyExplicitWaitForElementVisibility("/html/body/div/div/div[3]/div/div[1]/div/div[1]/div/section[2]/div[3]/div[1]");
				landingpagetesting.applyPriceFilter(xMinPriceOnSlider, xMaxPriceOnSlider);
				Thread.sleep(8000);
			//selectSamsungMobileFromBrandsOptionsFromFilterByUsingSearchFieldOnBrandFilterWindow
				landingpagetesting.applyBrandFilter(mobileBrandName);
			//	Wait.applyExplicitWaitForElementVisibility("(//div[text()='SAMSUNG'])[1]");
				Thread.sleep(8000);
			//selectRAMFromRAMCheckboxOnMobilePhonesPage
				LandingPage landingpage = new LandingPage(driver);
				landingpage.selectcheckBoxForRAMOnMobilePhonesPage(nameOfCheckboxForRAM);
				//Wait.applyExplicitWaitForElementVisibility("(//div[text()='8 GB and Above'])[1]");
				Thread.sleep(8000);
			//printTheCheapestAndCostliestPhone
				landingpage.clickOnPriceLowToHigh();
				Thread.sleep(8000);
				landingpage.clickOnNameOfCheapestAndCostliestMobilePhone(selectMobileFromTopAfterFilterPriceLowToHigh);
				Thread.sleep(8000);
			//navigate to Product details page
				ChildBrowser.switchToWindow(driver, "SAMSUNG Galaxy A15 5G ( 128 GB Storage, 8 GB RAM ) Online at Best Price On Flipkart.com");
				Wait.applyExplicitWaitForElementVisibility("//button[@type='button']");				
			//Check this product is in Stock
				//When Buy now button is displayed to user then that Product is available in stock. And if product not in stock then Notify button is displayed instead of Buy Now button.
				landingpage.buyNowButtonOnMobileDetailssPageIsDisplayed();				
			//click On Add to Cart button
				landingpage.clickOnAddToCartButtonOnProductDetailsPage();
				Wait.applyExplicitWaitForElementVisibility("//button[@class='QqFHMw zA2EfJ _7Pd1Fp']");
			//After click on Add To Cart Button user navigate to Add ToCart Page and page of this title is "Shopping Cart | Flipkart.com"
				Assert.assertEquals(driver.getTitle(), "Shopping Cart | Flipkart.com");
		}
	
	

	@Parameters({"inputOnSearch", "mobileBrandName", "nameOfCheckboxForRAM", "xMinPriceOnSlider", "xMaxPriceOnSlider", "selectMobileFromTopAfterFilterPriceLowToHigh"})
	@Test
	public void verifyDiscuoutIsReducedFromThePriceAndValidateTotalAmmoutToBuyMobile(String inputOnSearch, String mobileBrandName, String nameOfCheckboxForRAM, int xMinPriceOnSlider, int xMaxPriceOnSlider, int selectMobileFromTopAfterFilterPriceLowToHigh) throws InterruptedException {
				test = reports.createTest("verifyDiscuoutIsReducedFromThePriceAndValidateTotalAmmoutToBuyMobile");				
				
			//selectPriceOfMobileFromTwentyThouandToThirtyThousandPlusFromPriceFilterSlider
				//Search the Product
				LandingPageTesting landingpagetesting = new LandingPageTesting();
				landingpagetesting.searchForProduct(inputOnSearch);	
				Wait.applyExplicitWaitForElementVisibility("/html/body/div/div/div[3]/div/div[1]/div/div[1]/div/section[2]/div[3]/div[1]");
				landingpagetesting.applyPriceFilter(xMinPriceOnSlider, xMaxPriceOnSlider);
				Thread.sleep(8000);
			//selectSamsungMobileFromBrandsOptionsFromFilterByUsingSearchFieldOnBrandFilterWindow
				landingpagetesting.applyBrandFilter(mobileBrandName);
			//	Wait.applyExplicitWaitForElementVisibility("(//div[text()='SAMSUNG'])[1]");
				Thread.sleep(8000);
			//selectRAMFromRAMCheckboxOnMobilePhonesPage
				LandingPage landingpage = new LandingPage(driver);
				landingpage.selectcheckBoxForRAMOnMobilePhonesPage(nameOfCheckboxForRAM);
				//Wait.applyExplicitWaitForElementVisibility("(//div[text()='8 GB and Above'])[1]");
				Thread.sleep(8000);
			//printTheCheapestAndCostliestPhone
				landingpage.clickOnPriceLowToHigh();
				Thread.sleep(8000);
				landingpage.clickOnNameOfCheapestAndCostliestMobilePhone(selectMobileFromTopAfterFilterPriceLowToHigh);
				Thread.sleep(8000);
			//navigate to Product details page
				ChildBrowser.switchToWindow(driver, "SAMSUNG Galaxy A15 5G ( 128 GB Storage, 8 GB RAM ) Online at Best Price On Flipkart.com");
				Wait.applyExplicitWaitForElementVisibility("//button[@type='button']");				
			//Check this product is in Stock
			//When Buy now button is displayed to user then that Product is available in stock. And if product not in stock then Notify button is displayed instead of Buy Now button.
				landingpage.buyNowButtonOnMobileDetailssPageIsDisplayed();				
			//click On Add to Cart button
				landingpage.clickOnAddToCartButtonOnProductDetailsPage();
				Wait.applyExplicitWaitForElementVisibility("//button[@class='QqFHMw zA2EfJ _7Pd1Fp']");				
				int expectedBuyingPrice=landingpage.expectedBuyingPriceAfterdiscountAndDeliveryChargesReducedFromTotalAmount();				
			 //Assert that the actual buying price matches the expected buying price
			    Assert.assertEquals(landingpage.buyingPriceOfTheProductOnAddToCartPage(), expectedBuyingPrice, "The buying price is incorrect.");
		}
	
	//TC11.1 Increase the quantity of the product by 1 using the number input
	@Parameters({"inputOnSearch", "mobileBrandName", "nameOfCheckboxForRAM", "xMinPriceOnSlider", "xMaxPriceOnSlider", "productQuantityToIncrease"})
	@Test
	public void verifyUserIsAbleToIncreaseTheQuantityOfTheProductInAddToCartPageByUsingTheNumberInput(String inputOnSearch, String mobileBrandName, String nameOfCheckboxForRAM, int xMinPriceOnSlider, int xMaxPriceOnSlider, String productQuantityToIncrease) throws InterruptedException {
		test = reports.createTest("verifyUserIsAbleToIncreaseTheQuantityOfTheProductInAddToCartPageByUsingTheNumberInput");
		
			//selectPriceOfMobileFromTwentyThouandToThirtyThousandPlusFromPriceFilterSlider
				//Search the Product
				LandingPageTesting landingpagetesting = new LandingPageTesting();
				landingpagetesting.searchForProduct(inputOnSearch);	
				Wait.applyExplicitWaitForElementVisibility("/html/body/div/div/div[3]/div/div[1]/div/div[1]/div/section[2]/div[3]/div[1]");
				landingpagetesting.applyPriceFilter(xMinPriceOnSlider, xMaxPriceOnSlider);
				Thread.sleep(8000);
			//selectSamsungMobileFromBrandsOptionsFromFilterByUsingSearchFieldOnBrandFilterWindow
				landingpagetesting.applyBrandFilter(mobileBrandName);
				//	Wait.applyExplicitWaitForElementVisibility("(//div[text()='SAMSUNG'])[1]");
				Thread.sleep(8000);
			//selectRAMFromRAMCheckboxOnMobilePhonesPage
				LandingPage landingpage = new LandingPage(driver);
				landingpage.selectcheckBoxForRAMOnMobilePhonesPage(nameOfCheckboxForRAM);
				//Wait.applyExplicitWaitForElementVisibility("(//div[text()='8 GB and Above'])[1]");
				Thread.sleep(8000);
			//printTheCheapestAndCostliestPhone
				landingpage.clickOnPriceLowToHigh();
				Thread.sleep(8000);
				landingpage.clickOnNameOfCheapestAndCostliestMobilePhone(1);
				Wait.applyExplicitWaitForElementVisibility("/html/body/div/div/div[3]/div/div[2]/div[2]/div/div/div/a/div[2]/div[1]/div[1]");
				Thread.sleep(10000);
				//navigate to Product details page
				ChildBrowser.switchToWindow(driver, "SAMSUNG Galaxy A15 5G ( 128 GB Storage, 8 GB RAM ) Online at Best Price On Flipkart.com");
				Wait.applyExplicitWaitForElementVisibility("//button[@type='button']");				
			//Check this product is in Stock
				//When Buy now button is displayed to user then that Product is available in stock. And if product not in stock then Notify button is displayed instead of Buy Now button.
				landingpage.buyNowButtonOnMobileDetailssPageIsDisplayed();				
			//click On Add to Cart button
				landingpage.clickOnAddToCartButtonOnProductDetailsPage();
				//After click on Add To Cart Button user navigate to Add ToCart Page and page of this title is "Shopping Cart | Flipkart.com"				
			//increase the quantity of the Product by entring the integer number
				landingpage.enterInputOnInputFieldForIncreaseProductQuantityOnCartPage(driver, productQuantityToIncrease);
				System.out.println(landingpage.getTextFromInputFieldForIncreaseProductQuantityOnCartPage(driver));
				//System.out.println(landingpage.messageThrowsAfterQuantityUpdateOnAddToCartPageIsDisplayed());
				Wait.applyExplicitWaitForElementVisibility("//div[@class='eIDgeN']");				
				Assert.assertEquals(landingpage.getTextFromInputFieldForIncreaseProductQuantityOnCartPage(driver), productQuantityToIncrease);		
	}
	
	//TC11.2 Increase the quantity of the product by 1 using the number input and verify the popup text.
	@Parameters({"inputOnSearch", "mobileBrandName", "nameOfCheckboxForRAM", "xMinPriceOnSlider", "xMaxPriceOnSlider", "productQuantityToIncrease"})
	@Test
	public void verifyAfterSucessfullIncreaseTheQuantityOfTheProductInAddToCartPageThenPupupTextIsDisplayedToUser(String inputOnSearch, String mobileBrandName, String nameOfCheckboxForRAM, int xMinPriceOnSlider, int xMaxPriceOnSlider, String productQuantityToIncrease) throws InterruptedException {
		test = reports.createTest("verifyAfterSucessfullIncreaseTheQuantityOfTheProductInAddToCartPageThenPupupTextIsDisplayedToUser");
		
			//selectPriceOfMobileFromTwentyThouandToThirtyThousandPlusFromPriceFilterSlider
				//Search the Product
				LandingPageTesting landingpagetesting = new LandingPageTesting();
				landingpagetesting.searchForProduct(inputOnSearch);	
				Wait.applyExplicitWaitForElementVisibility("/html/body/div/div/div[3]/div/div[1]/div/div[1]/div/section[2]/div[3]/div[1]");
				landingpagetesting.applyPriceFilter(xMinPriceOnSlider, xMaxPriceOnSlider);
				Thread.sleep(8000);
			//selectSamsungMobileFromBrandsOptionsFromFilterByUsingSearchFieldOnBrandFilterWindow
				landingpagetesting.applyBrandFilter(mobileBrandName);
				//	Wait.applyExplicitWaitForElementVisibility("(//div[text()='SAMSUNG'])[1]");
				Thread.sleep(8000);
			//selectRAMFromRAMCheckboxOnMobilePhonesPage
				LandingPage landingpage = new LandingPage(driver);
				landingpage.selectcheckBoxForRAMOnMobilePhonesPage(nameOfCheckboxForRAM);
				//Wait.applyExplicitWaitForElementVisibility("(//div[text()='8 GB and Above'])[1]");
				Thread.sleep(8000);
			//printTheCheapestAndCostliestPhon
				landingpage.clickOnPriceLowToHigh();
				Thread.sleep(8000);
				landingpage.clickOnNameOfCheapestAndCostliestMobilePhone(1);
				Thread.sleep(8000);
			//navigate to Product details page
				ChildBrowser.switchToWindow(driver, "SAMSUNG Galaxy A15 5G ( 128 GB Storage, 8 GB RAM ) Online at Best Price On Flipkart.com");
				Wait.applyExplicitWaitForElementVisibility("//button[@type='button']");				
			//Check this product is in Stock
			//When Buy now button is displayed to user then that Product is available in stock. And if product not in stock then Notify button is displayed instead of Buy Now button.
				landingpage.buyNowButtonOnMobileDetailssPageIsDisplayed();				
			//click On Add to Cart button
				landingpage.clickOnAddToCartButtonOnProductDetailsPage();
			//After click on Add To Cart Button user navigate to Add ToCart Page and page of this title is "Shopping Cart | Flipkart.com"				
			//increase the quantity of the Product by entring the integer number
				landingpage.enterInputOnInputFieldForIncreaseProductQuantityOnCartPage(driver, productQuantityToIncrease);				
				Wait.applyExplicitWaitForElementVisibility("//div[@class='eIDgeN']");
			//Check Toster message is displayed after successfully quantity updated
				System.out.println(landingpage.getTextFromInputFieldForIncreaseProductQuantityOnCartPage(driver));//Ans:productQuantityToIncrease
				System.out.println(landingpage.messageThrowsAfterQuantityUpdateOnAddToCartPageIsDisplayed());//Ans : True
				System.out.println(landingpage.getTextFrommessageThrowsAfterQuantityUpdateOnAddToCartPage());//And: You've changed 'SAMSUNG Galaxy A15 5G (Blue Black, 128 GB)' QUANTITY to '3'				
				Assert.assertTrue(landingpage.messageThrowsAfterQuantityUpdateOnAddToCartPageIsDisplayed());		
	}
	
	//12. Then decrease the quantity by using the (-) sign.
	@Parameters({"inputOnSearch", "mobileBrandName", "nameOfCheckboxForRAM", "xMinPriceOnSlider", "xMaxPriceOnSlider", "productQuantityToIncrease"})
	@Test
	public void verifyUserIsAbleToDecreaseTheQuantityOfProductInAddToCartPageByClickOnMinusSign(String inputOnSearch, String mobileBrandName, String nameOfCheckboxForRAM, int xMinPriceOnSlider, int xMaxPriceOnSlider, String productQuantityToIncrease) throws InterruptedException {
		test = reports.createTest("verifyUserIsAbleToDecreaseTheQuantityOfProductInAddToCartPageByClickOnMinusSign");
		
			//selectPriceOfMobileFromTwentyThouandToThirtyThousandPlusFromPriceFilterSlider
				//Search the Product
				LandingPageTesting landingpagetesting = new LandingPageTesting();
				landingpagetesting.searchForProduct(inputOnSearch);	
				Wait.applyExplicitWaitForElementVisibility("/html/body/div/div/div[3]/div/div[1]/div/div[1]/div/section[2]/div[3]/div[1]");
				landingpagetesting.applyPriceFilter(xMinPriceOnSlider, xMaxPriceOnSlider);
				Thread.sleep(8000);
			//selectSamsungMobileFromBrandsOptionsFromFilterByUsingSearchFieldOnBrandFilterWindow
				landingpagetesting.applyBrandFilter(mobileBrandName);
				//	Wait.applyExplicitWaitForElementVisibility("(//div[text()='SAMSUNG'])[1]");
				Thread.sleep(8000);
			//selectRAMFromRAMCheckboxOnMobilePhonesPage
				LandingPage landingpage = new LandingPage(driver);
				landingpage.selectcheckBoxForRAMOnMobilePhonesPage(nameOfCheckboxForRAM);
				//Wait.applyExplicitWaitForElementVisibility("(//div[text()='8 GB and Above'])[1]");
				Thread.sleep(8000);
			//printTheCheapestAndCostliestPhon
				landingpage.clickOnPriceLowToHigh();
				Thread.sleep(8000);
				landingpage.clickOnNameOfCheapestAndCostliestMobilePhone(2);
				Thread.sleep(8000);
				//navigate to Product details page
				ChildBrowser.switchToWindow(driver, "SAMSUNG Galaxy A15 5G ( 128 GB Storage, 8 GB RAM ) Online at Best Price On Flipkart.com");
				Wait.applyExplicitWaitForElementVisibility("//button[@type='button']");				
			//Check this product is in Stock
				//When Buy now button is displayed to user then that Product is available in stock. And if product not in stock then Notify button is displayed instead of Buy Now button.
				landingpage.buyNowButtonOnMobileDetailssPageIsDisplayed();				
			//click On Add to Cart button
				landingpage.clickOnAddToCartButtonOnProductDetailsPage();
				//After click on Add To Cart Button user navigate to Add ToCart Page and page of this title is "Shopping Cart | Flipkart.com"				
				//increase the quantity of the Product by entring the integer number
				landingpage.enterInputOnInputFieldForIncreaseProductQuantityOnCartPage(driver, productQuantityToIncrease);				
				Wait.applyExplicitWaitForElementVisibility("//div[@class='eIDgeN']");
				System.out.println("Increased quantity of the Product :" +landingpage.getTextFromInputFieldForIncreaseProductQuantityOnCartPage(driver));//Ans:productQuantityToIncrease
				System.out.println("Message thows After successfully Increased quantity of the Product : "+landingpage.messageThrowsAfterQuantityUpdateOnAddToCartPageIsDisplayed());//Ans : True
				System.out.println("Actual Message After successfully Increased quantity of the Product : " +landingpage.getTextFrommessageThrowsAfterQuantityUpdateOnAddToCartPage());//And: You've changed 'SAMSUNG Galaxy A15 5G (Blue Black, 128 GB)' QUANTITY to '2'	
				Thread.sleep(10000);
			//decrease the quantity of the Product by click on minus sign
				landingpage.clickOnMinusSignOnAddToCartPageToReduceTheProductQuantity();
				Wait.applyExplicitWaitForElementVisibility("//div[@class='eIDgeN']");
				System.out.println("Message thows After successfully decreased quantity of the Product : "+landingpage.messageThrowsAfterQuantityUpdateOnAddToCartPageIsDisplayed());//Ans : True
				System.out.println("Actual Message After successfully decreased quantity of the Product : " +landingpage.getTextFrommessageThrowsAfterQuantityUpdateOnAddToCartPage());//And: You've changed 'SAMSUNG Galaxy A15 5G (Blue Black, 128 GB)' QUANTITY to '1'				
				Assert.assertTrue(landingpage.messageThrowsAfterQuantityUpdateOnAddToCartPageIsDisplayed());		
	}
	
	
	//TC13. Remove the product from the cart and verify the product is successfully removed.
	@Parameters({"inputOnSearch", "mobileBrandName", "nameOfCheckboxForRAM", "xMinPriceOnSlider", "xMaxPriceOnSlider", "productQuantityToIncrease"})
	@Test
	public void verifyUserIsAbleRemoveProductFromAddToCartPageByClickOnRemoveButton(String inputOnSearch, String mobileBrandName, String nameOfCheckboxForRAM, int xMinPriceOnSlider, int xMaxPriceOnSlider, String productQuantityToIncrease) throws InterruptedException {
		test = reports.createTest("verifyUserIsAbleRemoveProductFromAddToCartPageByClickOnRemoveButton");
		

			//selectPriceOfMobileFromTwentyThouandToThirtyThousandPlusFromPriceFilterSlider
				//Search the Product
				LandingPageTesting landingpagetesting = new LandingPageTesting();
				landingpagetesting.searchForProduct(inputOnSearch);	
				Wait.applyExplicitWaitForElementVisibility("/html/body/div/div/div[3]/div/div[1]/div/div[1]/div/section[2]/div[3]/div[1]");
				landingpagetesting.applyPriceFilter(xMinPriceOnSlider, xMaxPriceOnSlider);
				Thread.sleep(8000);
			//selectSamsungMobileFromBrandsOptionsFromFilterByUsingSearchFieldOnBrandFilterWindow
				landingpagetesting.applyBrandFilter(mobileBrandName);
				//	Wait.applyExplicitWaitForElementVisibility("(//div[text()='SAMSUNG'])[1]");
				Thread.sleep(8000);
			//selectRAMFromRAMCheckboxOnMobilePhonesPage
				LandingPage landingpage = new LandingPage(driver);
				landingpage.selectcheckBoxForRAMOnMobilePhonesPage(nameOfCheckboxForRAM);
				//Wait.applyExplicitWaitForElementVisibility("(//div[text()='8 GB and Above'])[1]");
				Thread.sleep(8000);
			//printTheCheapestAndCostliestPhon
				landingpage.clickOnPriceLowToHigh();
				Thread.sleep(8000);
				landingpage.clickOnNameOfCheapestAndCostliestMobilePhone(1);
				Thread.sleep(8000);
			//navigate to Product details page
				ChildBrowser.switchToWindow(driver, "SAMSUNG Galaxy A15 5G ( 128 GB Storage, 8 GB RAM ) Online at Best Price On Flipkart.com");
				Wait.applyExplicitWaitForElementVisibility("//button[@type='button']");				
			//Check this product is in Stock
			//When Buy now button is displayed to user then that Product is available in stock. And if product not in stock then Notify button is displayed instead of Buy Now button.	
				landingpage.buyNowButtonOnMobileDetailssPageIsDisplayed();				
			//click On Add to Cart button
				landingpage.clickOnAddToCartButtonOnProductDetailsPage();
				//After click on Add To Cart Button user navigate to Add ToCart Page and page of this title is "Shopping Cart | Flipkart.com"				
			//increase the quantity of the Product by entring the integer number
				landingpage.enterInputOnInputFieldForIncreaseProductQuantityOnCartPage(driver, productQuantityToIncrease);				
				Wait.applyExplicitWaitForElementVisibility("//div[@class='eIDgeN']");
				System.out.println("Increased quantity of the Product :" +landingpage.getTextFromInputFieldForIncreaseProductQuantityOnCartPage(driver));//Ans:productQuantityToIncrease
				System.out.println("Message thows After successfully Increased quantity of the Product : "+landingpage.messageThrowsAfterQuantityUpdateOnAddToCartPageIsDisplayed());//Ans : True
				System.out.println("Actual Message After successfully Increased quantity of the Product : " +landingpage.getTextFrommessageThrowsAfterQuantityUpdateOnAddToCartPage());//And: You've changed 'SAMSUNG Galaxy A15 5G (Blue Black, 128 GB)' QUANTITY to '2'				
				Thread.sleep(10000);
			//decrease the quantity of the Product by click on minus sign
				landingpage.clickOnMinusSignOnAddToCartPageToReduceTheProductQuantity();
				Wait.applyExplicitWaitForElementVisibility("//div[@class='eIDgeN']");	
				Thread.sleep(10000);
			//Click on Remove button to remove the Product from the cart
				landingpage.clickOnRemoveButtonOnAddToCartPage();
				Wait.applyExplicitWaitForElementVisibility("(//div[text()='Remove'])[1]");
				landingpage.clickOnRemoveButtonOnRemoveItemPopup();
				Wait.applyExplicitWaitForElementVisibility("//div[@class='eIDgeN']");
				System.out.println("Message thows After successfully Removed Product : "+landingpage.messageThrowsAfterRemoveProductFromCartPageIsDisplayed());
				System.out.println("Actual Message After successfully Removed Product : "+landingpage.getTextFromMessageThrowsAfterRemoveProductFromCartPage());				
				Assert.assertTrue(landingpage.messageThrowsAfterRemoveProductFromCartPageIsDisplayed());		
	}
	
}

	
/*	
	@Parameters({"nameOfCheckbox"})
	@Test
	public void selectMobileBrandFromBrandsOptionsFromBrandFilter(String nameOfCheckbox) throws InterruptedException {
		test = reports.createTest("selectMotorolaMobileFromBrandsOptionsFromFilter");
		LandingPage landingpage = new LandingPage(driver);
		landingpage.enterInputOnSearchInputField("Mobiles");
		Wait.applyExplicitWaitForElementVisibility("//button[@aria-label='Search for Products, Brands and More']");
		landingpage.clickEnterByKeyboard(driver);
		Wait.applyExplicitWaitForElementVisibility("//div[@class='e+xvXX KvHRYS']");
		landingpage.clickOnBrandMoreOptionsText();
		Wait.applyExplicitWaitForElementVisibility("//input[@placeholder='Search Brand']");
		Thread.sleep(10000);
		landingpage.selectBrandCheckBoxOnLandingPage(nameOfCheckbox);
		Wait.applyExplicitWaitForElementVisibility("//span[text()='Apply Filters']");
		landingpage.clickOnApplyFilterButtonOnBrandsOptionWindow();
		Wait.applyExplicitWaitForElementVisibility("(//div[text()='MOTOROLA'])[1]");
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
	Wait.applyExplicitWaitForElementVisibility("//button[@aria-label='Search for Products, Brands and More']");
	landingpage.clickEnterByKeyboard(driver);
	Wait.applyExplicitWaitForElementVisibility("/html/body/div/div/div[3]/div/div[1]/div/div[1]/div/section[2]/div[3]/div[1]");
	landingpage.selectMinTenThousandPriceOnPriceFilterSlider(driver);
	Wait.applyExplicitWaitForElementVisibility("/html/body/div/div/div[3]/div/div[1]/div/div[1]/div/section[1]/div[2]/div[1]/div/div[2]");
	//Thread.sleep(10000);
	landingpage.selectMaxTwentyThousandPriceOnPriceFilterSlider(driver);
	Wait.applyExplicitWaitForElementVisibility("/html/body/div/div/div[3]/div/div[1]/div/div[1]/div/section[2]/div[3]/div[1]/div[4]");
	Assert.assertTrue(landingpage.checkPriceIsDisplayedFromTenThousandToTwentyThousand());
	}
*/

