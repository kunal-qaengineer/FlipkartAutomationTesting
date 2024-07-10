package pom;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import net.bytebuddy.description.annotation.AnnotationList.Empty;

public class LandingPage {
	
	@FindBy (xpath = "")private WebElement x;
	@FindBy (xpath = "/html/body/div[1]/div/div[1]/div/div/div/div/div[1]/div/div[1]/div/div[1]/div[1]/header/div[1]/div[2]/form/div/div/input")private WebElement searchInputField;
	@FindBy (xpath = "//button[@aria-label='Search for Products, Brands and More']")private WebElement magnifyingLenceButton;
	@FindBy (xpath = "(//div[@class='PYKUdo'])[1]")private WebElement minPriceOnPriceFilterSlider;
	@FindBy (xpath = "(//div[@class='PYKUdo'])[2]")private WebElement maxPriceOnPriceFilterSlider;
	@FindBy (xpath = "/html/body/div/div/div[3]/div/div[1]/div/div[1]/div/section[2]/div[3]/div[1]/div[1]")private WebElement tenThousandPriceOnPriceFilterSlider;
	@FindBy (xpath = "/html/body/div/div/div[3]/div/div[1]/div/div[1]/div/section[2]/div[3]/div[1]/div[2]/div")private WebElement twentyThousandPriceOnPriceFilterSlider;
	@FindBy (xpath = "/html/body/div/div/div[3]/div/div[1]/div/div[1]/div/section[1]/div[2]/div[1]/div/div[2]")private WebElement displayedPriceRangeFromMinToMaxAtFilterTop;
	@FindBy (xpath = "//div[@class='ewzVkT']")private List<WebElement> OptionsCheckBoxOnBrandFilters;
	@FindBy (xpath = "(//div[text()='MOTOROLA'])[1]")private WebElement motorolaTextAtHeader;	
	@FindBy (xpath = "//div[@class='e+xvXX KvHRYS']")private WebElement brandsMoreOptions;
	@FindBy (xpath = "//span[text()='Apply Filters']")private WebElement ApplyFilterButtonOnBrandsOptionWindow;
	@FindBy (xpath = "//input[@placeholder='Search Brand']")private WebElement searchBrandInputField;
	@FindBy (xpath = "//div[@title='MOTOROLA']")private WebElement motorolaOptionOnBrandFilterWindow;
	@FindBy (xpath = "//div[@title='SAMSUNG']")private WebElement samsungOptionOnBrandFilterWindow;
	@FindBy (xpath = "(//div[text()='SAMSUNG'])[1]")private WebElement samsungTextAtHeader;	
	@FindBy (xpath = "//div[@class='ewzVkT _3DvUAf']")private List<WebElement> checkBoxOnMobilePhonesPage;
	@FindBy (xpath = "(//div[text()='8 GB and Above'])[1]")private WebElement ramTextAtHeader;	
	@FindBy (xpath = "//a[@title='Mobiles']")private WebElement mobileCategory;
	@FindBy (xpath = "//div[@class='Nx9bqj _4b5DiR']")private List<WebElement> priceOfMobilePhones;
	@FindBy (xpath = "//div[text()='Price -- Low to High']")private WebElement sortByPriceLowToHigh;
	@FindBy (xpath = "//div[@class='KzDlHZ']")private List<WebElement> nameOfMobilePhones;
	@FindBy (xpath = "//span[@role='button']")private WebElement crossButttonnLoginPopup;
	@FindBy (xpath = "//button[@type='button']")private WebElement buyNowButtonOnMobileDetailssPage;
	@FindBy (xpath = "//button[@class='QqFHMw vslbG+ In9uk2']")private WebElement addToCartButtonOnProductDetailsPage;
	@FindBy (xpath = "(//span[@class='b5rp0W'])[1]")private WebElement totlaPriceOfMobileOnProductDetailsPage;
	@FindBy (xpath = "(//span[@class='_6HMXbu'])[1]")private WebElement discountPriceOnProductDetailsPage;
	@FindBy (xpath = "(//span[@class='_6HMXbu'])[2]")private WebElement deliveryChargesOnProductDetailsPage;
	@FindBy (xpath = "(//div[@class='_1Y9Lgu'])[2]")private WebElement newPriceByReducingDiscountAndDeliveryChargesOnProductDetailsPage;
	@FindBy (xpath = "//input[@class='p6sArZ']")private WebElement inputFieldForIncreaseProductQuantityOnCartPage;
	@FindBy (xpath = "//div[@class='eIDgeN']")private WebElement messageThrowsAfterQuantityUpdateOnAddToCartPage;
	@FindBy (xpath = "(//button[@class='LcLcvv'])[1]")private WebElement minusSignOnAddToCartPageToReduceTheProductQuantity;
	@FindBy (xpath = "(//button[@class='LcLcvv'])[2]")private WebElement plusSignOnAddToCartPageToReduceTheProductQuantity;
	@FindBy (xpath = "//div[text()='Remove']")private WebElement removeButtonOnAddToCartPage;
	@FindBy (xpath = "(//div[text()='Remove'])[1]")private WebElement removeButtonOnRemoveItemPopup;
	@FindBy (xpath = "//div[@class='eIDgeN']")private WebElement messageThrowsAfterRemoveProductFromCartPage;
	@FindBy (xpath = "//span[text()='Filters']")private WebElement filterTitleAtTopLeft;
	@FindBy (xpath = "//div[text()='₹10000-₹20000']")private WebElement priceFilterAppliedAtTopFilterList;
	@FindBy (xpath = "//span[@class='_1XjE3T']")private List<WebElement> productCategoriesOnHeader;
	@FindBy (xpath = "//a[@class='_1BJVlg']")private List<WebElement> electronicMainCategories;
	@FindBy (xpath = "//a[@class='_3490ry']")private List<WebElement> moreOptionFromLaptopAndDeskTopElectronicCategory;
	@FindBy (xpath = "//a[@class='_1BJVlg _11MZbx']")private WebElement laptopAndDesktopOptionFromElectronicMainCategories;
	@FindBy (xpath = "(//a[text()='Laptops'])[3]")private WebElement laptopSubOptionFromlaptopAndDesktopOptionFromElectronicMainCategories;
	

	
	public LandingPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	public void enterInputOnSearchInputField(String inputOnSearch) {
		 searchInputField.sendKeys(inputOnSearch);
	}
	
	public void clickOnMagnifyingLenceButton() {
		magnifyingLenceButton.click();
	}
	
	public void clickEnterByKeyboard(WebDriver driver) {
		Actions action = new Actions(driver);
		action.keyDown(Keys.ENTER).perform();
		action.release().perform();
		
	}
	
	public void selectMinPriceOnPriceFilterSlider(WebDriver driver, int xMin) {
		Actions action = new Actions(driver);
		action.dragAndDropBy(minPriceOnPriceFilterSlider, xMin, 0).perform();
	}
	
	
	public void selectMaxPriceOnPriceFilterSlider(WebDriver driver, int xMax) {
		Actions action = new Actions(driver);
		//action.clickAndHold(maxPriceOnPriceFilterSlider).perform();
		action.dragAndDropBy(maxPriceOnPriceFilterSlider, xMax, 0).perform();
	}
	
	public boolean checkPriceIsDisplayedisApplied() {
		return displayedPriceRangeFromMinToMaxAtFilterTop.isDisplayed();
	}
	
	public void clickOnBrandMoreOptionsText() {
		brandsMoreOptions.click();
	}
	
	
	public void selectBrandCheckBoxOnLandingPage(String nameOfCheckbox) {
		
		int size =OptionsCheckBoxOnBrandFilters.size();
		System.out.println(size);
		
		for(int i=0; i<size; i++) 
				{
						 WebElement inputCheckBoxForBrands=OptionsCheckBoxOnBrandFilters.get(i);
						String brandName=inputCheckBoxForBrands.getAttribute("title");					
						 System.out.println(brandName);
						 System.out.println(brandName.equals(nameOfCheckbox));
						 if(brandName.equals(nameOfCheckbox)) 
								 {							 
									 inputCheckBoxForBrands.click();
									 break;
								 }	
				}
		}
	
	public void clickOnApplyFilterButtonOnBrandsOptionWindow() {
		ApplyFilterButtonOnBrandsOptionWindow.click();
	}
	
	public void enterBrandOnSearchBrandInputField(String brand) {
		searchBrandInputField.sendKeys(brand);
	}
	
	public void clickOnMotorolaOptionOnBrandFilterWindow() {
		motorolaOptionOnBrandFilterWindow.click();
	}
	
	public void clickOnSamsungOptionOnBrandFilterWindow() {
		samsungOptionOnBrandFilterWindow.click();
	}
	
	public boolean motorolaTextIsDisplayedAtFilters() {
		return motorolaTextAtHeader.isDisplayed();
	}
	
	public boolean samsungTextIsDisplayedAtFilters() {
		return samsungTextAtHeader.isDisplayed();
	}
	
	public String  getTextFromSAMSUNGSelectedFilter() {
		return	samsungTextAtHeader.getText();
	}
	
	public void selectcheckBoxForRAMOnMobilePhonesPage(String nameOfCheckbox) {
		int size =checkBoxOnMobilePhonesPage.size();
	//	System.out.println(size);		
		for(int i=0; i<size; i++) 
				{
						 WebElement inputCheckBoxForRAM=checkBoxOnMobilePhonesPage.get(i);
						 String RAM=inputCheckBoxForRAM.getAttribute("title");					
					//	 System.out.println(RAM);
					//	 System.out.println(RAM.equals(nameOfCheckbox));
						 if(RAM.equals(nameOfCheckbox)) 
								 {							 
							 		inputCheckBoxForRAM.click();
									 break;
								 }	
				}
	}
	
	public boolean ramTextIsSelectedDisplayedAtFilters() {
		return ramTextAtHeader.isDisplayed();
	}
	
	public boolean mobileCategoryIsDisplayed() {
		return mobileCategory.isDisplayed();
	}
	

	public void clickOnPriceLowToHigh() {
		sortByPriceLowToHigh.click();
	}
	
	public boolean priceLowToHighSortOptionIsSelected() {
		return sortByPriceLowToHigh.isSelected();
	}	
	
	public String printNameOfCheapestAndCostliestMobilePhone(int selectMobileFromTop) {
		//	int sizeOfMobileNames =nameOfMobilePhones.size();			
		//	System.out.println(sizeOfMobileNames);		
						 WebElement nameOfMobilePhone=nameOfMobilePhones.get(selectMobileFromTop);
						 String titleOfMobile=nameOfMobilePhone.getText();						 
						 System.out.println(titleOfMobile);	
						 return nameOfMobilePhone.getText();	
	}
	
	
	public String  prinPriceOfCheapestAndCostliestMobilePhone(int selectMobileFromTopAfterFilterPriceLowToHigh) {
		//	int sizeOfMobilePhonesPrice =priceOfMobilePhones.size();			
		//System.out.println(sizeOfMobilePhonesPrice);		
						 WebElement priceOfMobilePhone=priceOfMobilePhones.get(selectMobileFromTopAfterFilterPriceLowToHigh);
						 String cheapestMobilePrice=priceOfMobilePhone.getText();						 
						 System.out.println(cheapestMobilePrice);	
						return  priceOfMobilePhone.getText();	
	}
	
	public void clickOnCrossButttonnLoginPopup() {
		crossButttonnLoginPopup.click();
	}
	
	public void clickOnNameOfCheapestAndCostliestMobilePhone(int selectMobileFromTopAfterFilterPriceLowToHigh) {
		//	int sizeOfMobileNames =nameOfMobilePhones.size();			
		//	System.out.println(sizeOfMobileNames);		
						 WebElement nameOfMobilePhone=nameOfMobilePhones.get(selectMobileFromTopAfterFilterPriceLowToHigh);
						 nameOfMobilePhone.click();
	}
	
	public boolean buyNowButtonOnMobileDetailssPageIsDisplayed() {
		return buyNowButtonOnMobileDetailssPage.isDisplayed();
	}
	
	public void clickOnAddToCartButtonOnProductDetailsPage() {
		addToCartButtonOnProductDetailsPage.click();
	}
	
	
	public int expectedBuyingPriceAfterdiscountAndDeliveryChargesReducedFromTotalAmount() {
		
		//delivery charges are free
		int deliveryCharges =0;
		
		// Extract text from elements
		 String buyingPriceText = newPriceByReducingDiscountAndDeliveryChargesOnProductDetailsPage.getText();
		 String totalPriceText = totlaPriceOfMobileOnProductDetailsPage.getText();
		 String discountText = discountPriceOnProductDetailsPage.getText();
		
		
		// Remove non-numeric characters (e.g., currency symbols, commas)
	    String buyingPriceStr = buyingPriceText.replaceAll("[^0-9]", "");
	    String totalPriceStr = totalPriceText.replaceAll("[^0-9]", "");
	    String discountStr = discountText.replaceAll("[^0-9]", "");
	   
	    
	    // Convert to integers
	    int buyingPrice = Integer.parseInt(buyingPriceStr);
	    int totalPrice = Integer.parseInt(totalPriceStr);
	    int discount = Integer.parseInt(discountStr);
	  
	    
	    // Print values for debugging
	    System.out.println("Buying Price: " + buyingPrice);
	    System.out.println("Total Price: " + totalPrice);
	    System.out.println("Discount: " + discount);
	    System.out.println("Delivery Charges: " + deliveryCharges);
	    
	    // Calculate expected buying price
	    int expectedBuyingPrice = totalPrice - discount + deliveryCharges;
	    
	    // Print expected buying price for debugging
	    System.out.println("Expected Buying Price: " + expectedBuyingPrice);
	    return expectedBuyingPrice;
	}
	
	public int buyingPriceOfTheProductOnAddToCartPage() {
		 String buyingPriceText = newPriceByReducingDiscountAndDeliveryChargesOnProductDetailsPage.getText();
		 String buyingPriceStr = buyingPriceText.replaceAll("[^0-9]", "");
		 int buyingPrice = Integer.parseInt(buyingPriceStr);
		 return buyingPrice;
	}
	
	public void enterInputOnInputFieldForIncreaseProductQuantityOnCartPage(WebDriver driver, String productQuantityToIncrease) {
	    Actions action = new Actions(driver);
	    
	    // Move to the input field and click to focus
	    action.moveToElement(inputFieldForIncreaseProductQuantityOnCartPage).click().perform();
	    
	    // Select all text in the input field (Ctrl + A)
	    action.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
	    
	    // Clear the input field (send backspace or delete)
	    action.sendKeys(Keys.BACK_SPACE).perform();
	    
	    // Enter '2' in the input field
	    action.sendKeys(productQuantityToIncrease).perform();
	    
	    // (Optional) Submit the form or press Enter if needed
	    action.sendKeys(Keys.ENTER).perform();
	}
	
	public String getTextFromInputFieldForIncreaseProductQuantityOnCartPage(WebDriver driver) {
	    // Move to the input field to ensure it's visible and focused
	    Actions action = new Actions(driver);
	    action.moveToElement(inputFieldForIncreaseProductQuantityOnCartPage).perform();

	    // Retrieve and return the text from the input field
	    return inputFieldForIncreaseProductQuantityOnCartPage.getAttribute("value");
	}
	
	public boolean messageThrowsAfterQuantityUpdateOnAddToCartPageIsDisplayed() {
		return messageThrowsAfterQuantityUpdateOnAddToCartPage.isDisplayed();
	}
	
	public String getTextFrommessageThrowsAfterQuantityUpdateOnAddToCartPage() {
		return messageThrowsAfterQuantityUpdateOnAddToCartPage.getText();
	}
	
	public void clickOnMinusSignOnAddToCartPageToReduceTheProductQuantity() {
		minusSignOnAddToCartPageToReduceTheProductQuantity.click();
	}
	
	public void clickOnRemoveButtonOnAddToCartPage() {
		removeButtonOnAddToCartPage.click();
	}
	
	public void clickOnRemoveButtonOnRemoveItemPopup() {
		removeButtonOnRemoveItemPopup.click();
	}
	
	public boolean messageThrowsAfterRemoveProductFromCartPageIsDisplayed() {
		return messageThrowsAfterRemoveProductFromCartPage.isDisplayed();
	}
	
	public String getTextFromMessageThrowsAfterRemoveProductFromCartPage() {
		return messageThrowsAfterRemoveProductFromCartPage.getText();
	}
	
	public boolean filterTitleIsDisplayedAtTopLeft() {
		return filterTitleAtTopLeft.isDisplayed();
	}
	
	public String priceFilterDropDownMaximumIsSelected() {
	
		String filterText=priceFilterAppliedAtTopFilterList.getText();
		System.out.println(filterText + ": textpriceFilterDropDownMaximum");		
		return filterText;
	}
	
	public void selectProductCategoryFromHeaders(WebDriver driver, String categoryHeader) {		
		
		int size = productCategoriesOnHeader.size();
	//	System.out.println("Main Category Count: " + size);
		
		for (int i = 0; i < size; i++) {
			
				WebElement productCategory=productCategoriesOnHeader.get(i);
				String categoryName=productCategory.getText();
				
					if(categoryName.equals(categoryHeader)) {
						Actions action  = new Actions(driver);
						action.moveToElement(productCategory).perform();
						break;
			}		
		}
	}
	
	public void categoryFromElectronicProducts(WebDriver driver , String actualElectronicOption) {
		
		int size = electronicMainCategories.size();
	//	System.out.println("electronicMainCategories count: " + size);
		
			for (int i = 0; i < size; i++) {				
				WebElement electronicCategoryOptions=electronicMainCategories.get(i);
				String electronicOption=electronicCategoryOptions.getText();
		//		System.out.println("electronicCategoryOptions are : ");
		//		System.out.println(electronicOption);
				
					if(electronicOption.equals(actualElectronicOption)) {
						Actions action  = new Actions(driver);
						action.moveToElement(electronicCategoryOptions).perform();
						break;
					}		
			}
	}
	
	public void clickOnLaptopSubCategoryFromElectronicLaptopAndDesktopOptions(WebDriver driver, String actualLaptopAndDesktopOption) {		
		
		int size=moreOptionFromLaptopAndDeskTopElectronicCategory.size();
	//	System.out.println("moreOptionFromLaptopAndDeskTopElectronicCategory count: " + size);
		
			for (int i = 0; i < size; i++) {					
					WebElement LaptopAndDesktopCategoryOptions=moreOptionFromLaptopAndDeskTopElectronicCategory.get(i);
					String laptopAndDesktopOption=LaptopAndDesktopCategoryOptions.getText();
			//		System.out.println("LaptopAndDesktopCategoryOptions are : ");
			//		System.out.println(laptopAndDesktopOption);
					
						if(laptopAndDesktopOption.equals(actualLaptopAndDesktopOption)) {
							Actions action  = new Actions(driver);
							action.moveToElement(LaptopAndDesktopCategoryOptions);
							action.click();
							action.build().perform();
							break;
						}		
			}
		
	}
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

