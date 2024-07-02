package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	
	@FindBy (xpath = "")private WebElement x;
	@FindBy (xpath = "/html/body/div[1]/div/div[1]/div/div/div/div/div[1]/div/div[1]/div/div[1]/div[1]/header/div[1]/div[2]/form/div/div/input")private WebElement searchInputField;
	@FindBy (xpath = "//button[@aria-label='Search for Products, Brands and More']")private WebElement magnifyingLenceButton;
	@FindBy (xpath = "/html/body/div/div/div[3]/div[1]/div[1]/div/div[1]/div/section[2]/div[3]/div[1]/div[1]/div")private WebElement minPriceOnPriceFilterSlider;
	@FindBy (xpath = "/html/body/div/div/div[3]/div[1]/div[1]/div/div[1]/div/section[2]/div[3]/div[1]/div[2]/div")private WebElement maxPriceOnPriceFilterSlider;
	@FindBy (xpath = "/html/body/div/div/div[3]/div/div[1]/div/div[1]/div/section[2]/div[3]/div[1]/div[1]/div")private WebElement tenThousandPriceOnPriceFilterSlider;
	@FindBy (xpath = "/html/body/div/div/div[3]/div/div[1]/div/div[1]/div/section[2]/div[3]/div[1]/div[2]/div")private WebElement twentyThousandPriceOnPriceFilterSlider;
	@FindBy (xpath = "/html/body/div/div/div[3]/div/div[1]/div/div[1]/div/section[2]/div[3]/div[1]/div[4]")private WebElement priceFilterSliderFromTenThousandToTwentyThousand;
	
	
	
	
	public LandingPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	public void enterInputOnSearchInputField(String input) {
		searchInputField.sendKeys(input);
	}
	
	public void clickOnMagnifyingLenceButton() {
		magnifyingLenceButton.click();
	}
	
	public void selectMinTenThousandPriceOnPriceFilterSlider(WebDriver driver) {
		Actions action = new Actions(driver);
		action.clickAndHold(minPriceOnPriceFilterSlider).moveToElement(tenThousandPriceOnPriceFilterSlider).release().perform();
	}
	
	public void selectMaxTwentyThousandPriceOnPriceFilterSlider(WebDriver driver) {
		Actions action = new Actions(driver);
		action.clickAndHold(maxPriceOnPriceFilterSlider).moveToElement(twentyThousandPriceOnPriceFilterSlider).release().perform();
	}
	
	public boolean checkPriceFilterSliderIsSelectedFromTenThousandToTwentyThousand() {
		return priceFilterSliderFromTenThousandToTwentyThousand.isSelected();
	}
	
	
}

