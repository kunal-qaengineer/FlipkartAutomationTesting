package pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
	
	public void enterBrandOnsearchBrandInputField(String brand) {
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
	
/*	public void selectCheapestAndCostliestPriceOfPhone() {
		int size =priceOfMobilePhones.size();
		System.out.println(size);		
		for(int i=0; i<size; i++) 
				{
						 WebElement priceOfMobile=priceOfMobilePhones.get(i);
						 String price=priceOfMobile.getText();
						 
						 System.out.println(price);
					//	 System.out.println(price.equals(nameOfCheckbox));
						 while()
								 {							 
							 		inputCheckBoxForRAM.click();
									 break;
								 }	
				}
	
	}
*/
	
	public void clickOnPriceLowToHigh() {
		sortByPriceLowToHigh.click();
	}
	
	public boolean priceLowToHighSortOptionIsSelected() {
		return sortByPriceLowToHigh.isSelected();
	}
	

	
	
	public void printNameOfCheapestAndCostliestMobilePhone() {
		//	int sizeOfMobileNames =nameOfMobilePhones.size();			
		//	System.out.println(sizeOfMobileNames);		
						 WebElement nameOfMobilePhone=nameOfMobilePhones.get(0);
						 String titleOfMobile=nameOfMobilePhone.getText();						 
						 System.out.println(titleOfMobile);	
	}
	
	
	public void prinPriceOfCheapestAndCostliestMobilePhone() {
		//	int sizeOfMobilePhonesPrice =priceOfMobilePhones.size();			
		//System.out.println(sizeOfMobilePhonesPrice);		
						 WebElement priceOfMobilePhone=priceOfMobilePhones.get(0);
						 String cheapestMobilePrice=priceOfMobilePhone.getText();						 
						 System.out.println(cheapestMobilePrice);	
	}
	
	public void clickOnCrossButttonnLoginPopup() {
		crossButttonnLoginPopup.click();
	}
	
	public void clickOnNameOfCheapestAndCostliestMobilePhoneInFirstPosition() {
		//	int sizeOfMobileNames =nameOfMobilePhones.size();			
		//	System.out.println(sizeOfMobileNames);		
						 WebElement nameOfMobilePhone=nameOfMobilePhones.get(0);
						 nameOfMobilePhone.click();
	}
	
	public boolean buyNowButtonOnMobileDetailssPageIsDisplayed() {
		return buyNowButtonOnMobileDetailssPage.isDisplayed();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

