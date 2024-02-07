package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementsUtils;
import utils.commonUtils;

public class AccountPage {
	WebDriver driver;
	private ElementsUtils elementsUtils;
	public AccountPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		elementsUtils = new ElementsUtils(driver);
	}
	
	@FindBy(linkText = "Edit your account information")
	private WebElement Edityouraccountinfo;
	
	public boolean displayEdityourAccountinfo() {
		return elementsUtils.DisplaystatusOfelement(Edityouraccountinfo, commonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	}
}
