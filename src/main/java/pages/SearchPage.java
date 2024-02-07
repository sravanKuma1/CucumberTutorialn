package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import net.bytebuddy.asm.Advice.This;
import utils.ElementsUtils;
import utils.commonUtils;

public class SearchPage {
	WebDriver driver ;
	private ElementsUtils elementsUtils;
	public SearchPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
		elementsUtils = new ElementsUtils(driver);
	}
	
	@FindBy(linkText = "HP LP3065")
	private WebElement validproductdisplay;
	
	@FindBy(xpath = "//input[@value='Search']/following-sibling::p")
	private WebElement warningmessageinvaildproduct;
	
	public boolean searchVaildProductDisplayed() {
		return elementsUtils.DisplaystatusOfelement(validproductdisplay, commonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	}
	
	public String warninginvaildproductMessage() {
		return elementsUtils.gettextfromElement(warningmessageinvaildproduct, commonUtils.EXPLICIT_WAIT_BASIC_TIME);

	}
	
	
}
