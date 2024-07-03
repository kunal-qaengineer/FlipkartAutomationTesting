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
	@FindBy (xpath = "/html/body/div/div/div[3]/div/div[1]/div/div[1]/div/section[1]/div[2]/div[1]/div/div[2]")private WebElement priceRangeFromTenThousandToTwentyThousand;
	//@FindBy (xpath = "//div[@class='_6i1qKy']")private List<WebElement> OptionsCheckBox;
	@FindBy (xpath = "//div[@class='ewzVkT']")private List<WebElement> OptionsCheckBoxOnBrandFilters;
	@FindBy (xpath = "(//div[text()='MOTOROLA'])[1]")private WebElement motorolaTextAtHeader;	
	@FindBy (xpath = "//div[@class='e+xvXX KvHRYS']")private WebElement brandsMoreOptions;
	@FindBy (xpath = "//span[text()='Apply Filters']")private WebElement ApplyFilterButtonOnBrandsOptionWindow;
	@FindBy (xpath = "//input[@placeholder='Search Brand']")private WebElement searchBrandInputField;
	@FindBy (xpath = "//div[@title='MOTOROLA']")private WebElement motorolaOptionOnBrandFilterWindow;
	
	
	
	
	
	public LandingPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	public void enterInputOnSearchInputField(String input) {
		searchInputField.sendKeys(input);
	}
	
	public void clickOnMagnifyingLenceButton() {
		magnifyingLenceButton.click();
	}
	
	public void clickEnterByKeyboard(WebDriver driver) {
		Actions action = new Actions(driver);
		action.keyDown(Keys.ENTER).perform();
		action.release().perform();
		
	}
	
	public void selectMinTenThousandPriceOnPriceFilterSlider(WebDriver driver) {
		Actions action = new Actions(driver);
		action.dragAndDropBy(minPriceOnPriceFilterSlider, 47, 0).perform();
	}
	
	public void selectMaxTwentyThousandPriceOnPriceFilterSlider(WebDriver driver) {
		Actions action = new Actions(driver);
		//action.clickAndHold(maxPriceOnPriceFilterSlider).perform();
		action.dragAndDropBy(maxPriceOnPriceFilterSlider, -95, 0).perform();
	}
	
	public boolean checkPriceIsDisplayedFromTenThousandToTwentyThousand() {
		return priceRangeFromTenThousandToTwentyThousand.isDisplayed();
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
	
	public boolean motorolaTextIsDisplayedAtFilters() {
		return motorolaTextAtHeader.isDisplayed();
	}
	
	
	
}

