package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementsUtils;
import utils.commonUtils;

public class HomePage {
	WebDriver driver;
	private ElementsUtils elementsutils;
	public HomePage(WebDriver driver){
	this.driver = driver;
	PageFactory.initElements(driver, this);
	elementsutils = new ElementsUtils(driver);
	}
	
	//Objects
	
	@FindBy(xpath = "//span[text()='My Account']")
	private WebElement MyAccountDropMenu;
	
	@FindBy(linkText = "Login")
	private WebElement loginOption;
	
	@FindBy(linkText = "Register")
	private WebElement registeroption;
	
	@FindBy(name = "search")
	private WebElement SearchBoxField;
	
	@FindBy(xpath = "//button[contains(@class,'btn-default')]")
	private WebElement searchbutton;
	
	public SearchPage ClickonSearchButton() {
		elementsutils.ClickonElement(searchbutton, commonUtils.EXPLICIT_WAIT_BASIC_TIME);
		return new SearchPage(driver);
	}
	
	//Actions
	public void ClickonMyAccountOption() {
		elementsutils.ClickonElement(MyAccountDropMenu, commonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public LoginPage ClickOnLoginOption() {
		elementsutils.ClickonElement(loginOption, commonUtils.EXPLICIT_WAIT_BASIC_TIME);
		return new LoginPage(driver);
	}
	
	public RegisterPage ClickonRegisterOption() {
		elementsutils.ClickonElement(registeroption, commonUtils.EXPLICIT_WAIT_BASIC_TIME);
		return new RegisterPage(driver);
	}
	
	public void enterValidSearchBoxfild(String validProducttext) {
		elementsutils.TypeTextIntoElement(SearchBoxField, commonUtils.EXPLICIT_WAIT_BASIC_TIME, validProducttext);
	}


	
	
	
}
