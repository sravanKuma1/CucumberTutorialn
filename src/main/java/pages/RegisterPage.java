package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementsUtils;
import utils.commonUtils;

public class RegisterPage {
	WebDriver driver;
	private ElementsUtils elementsUtils;
	public RegisterPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		elementsUtils = new ElementsUtils(driver);
	}
	
	
	//objects
	@FindBy(id = "input-firstname")
	private WebElement firstnamefield;
	
	@FindBy(id="input-lastname")
	private WebElement lastNamefield;
	
	@FindBy(id="input-email")
	private WebElement emailaddressFiled;
	
	@FindBy(id="input-telephone")
	private WebElement telphoneAddressfield;
	
	@FindBy(id="input-password")
	private WebElement passwordtextFeild;
	
	@FindBy(id="input-confirm")
	private WebElement paswordconfrimfield;
	
	@FindBy(name = "agree")
	private WebElement selectPrivacypolicy;
	
	@FindBy(xpath = "//input[@type='submit']")
	private WebElement continueButton;
	
	@FindBy(xpath = "//input[@name='newsletter'][@value=1]")
	private WebElement yesforNewLetter;
	
	@FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")
	private WebElement warningMessage;
	
	@FindBy(xpath = "//input[@id='input-firstname']/following-sibling::div")
	private WebElement firstnamewarning;
	
	
	//Actions
	public void EnterfirstnameText(String FirstName) {
		elementsUtils.TypeTextIntoElement(firstnamefield, commonUtils.EXPLICIT_WAIT_BASIC_TIME, FirstName);
		
	}
	
	public void Enterlastnametext(String LastName) {
		elementsUtils.TypeTextIntoElement(lastNamefield, commonUtils.EXPLICIT_WAIT_BASIC_TIME, LastName);
		
	}
	
	public void enterEmailText(String emailtext) {
		elementsUtils.TypeTextIntoElement(emailaddressFiled, commonUtils.EXPLICIT_WAIT_BASIC_TIME, emailtext);
	
	}
	
	public void EntertelephoneNumber(String Telephone) {
		elementsUtils.TypeTextIntoElement(telphoneAddressfield, commonUtils.EXPLICIT_WAIT_BASIC_TIME, Telephone);
	
	}
	
	public void EnterPassword(String password) {
		elementsUtils.TypeTextIntoElement(passwordtextFeild, commonUtils.EXPLICIT_WAIT_BASIC_TIME, password);
	
	}
	
	public void ConfirmPassword(String password) {
		elementsUtils.TypeTextIntoElement(paswordconfrimfield, commonUtils.EXPLICIT_WAIT_BASIC_TIME, password);
		
	}
	
	public void ClickonPrivacyPolic() {
		elementsUtils.ClickonElement(selectPrivacypolicy, commonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	}
	
	public AccountSuccessPage ClickonContinueButton() {
		elementsUtils.ClickonElement(continueButton, commonUtils.EXPLICIT_WAIT_BASIC_TIME);
		return new AccountSuccessPage(driver);
	}
	
	public void ClickonYesNewsLetter() {
		elementsUtils.ClickonElement(yesforNewLetter, commonUtils.EXPLICIT_WAIT_BASIC_TIME);
		yesforNewLetter.click();
	}
	
	public String getWarningmessageText() {
		return	elementsUtils.gettextfromElement(warningMessage, commonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	}
	
	public String getfirstnamewarning() {
		return elementsUtils.gettextfromElement(firstnamewarning, commonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	}
}







