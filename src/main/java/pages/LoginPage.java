package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementsUtils;
import utils.commonUtils;

public class LoginPage {
	
	WebDriver driver;
	private ElementsUtils elementsUtils;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		elementsUtils = new ElementsUtils(driver);
	}
	
	@FindBy(id="input-email")
	private WebElement emailAddressField;
	
	@FindBy(id="input-password")
	private WebElement passwordAddresField;
	
	@FindBy(xpath = "//input[@value='Login']")
	private WebElement loginbuttonoption;
	
	@FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")
	private WebElement Warningmessage;
	
	//Actions
	public void EnterEmailAddress(String validEmailtext) {
		
		elementsUtils.TypeTextIntoElement(emailAddressField, commonUtils.EXPLICIT_WAIT_BASIC_TIME, validEmailtext);
		
	}
	
	public void EnterPassword(String validPasswordext) {
		elementsUtils.TypeTextIntoElement(passwordAddresField, commonUtils.EXPLICIT_WAIT_BASIC_TIME, validPasswordext);
		
	}
	
	public AccountPage ClickOnLoginButton() {
		elementsUtils.ClickonElement(loginbuttonoption, commonUtils.EXPLICIT_WAIT_BASIC_TIME);
		return new AccountPage(driver);
	}
	public String getWarningmessageText() {
		return elementsUtils.gettextfromElement(Warningmessage, commonUtils.EXPLICIT_WAIT_BASIC_TIME);

	}

	
	
}
